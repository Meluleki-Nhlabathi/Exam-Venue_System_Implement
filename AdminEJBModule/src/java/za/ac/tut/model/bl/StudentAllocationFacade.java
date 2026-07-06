/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import za.ac.tut.model.entity.Exam;
import za.ac.tut.model.entity.Student;
import za.ac.tut.model.entity.StudentAllocation;
import za.ac.tut.model.entity.StudentModule;
import za.ac.tut.model.entity.Venue;
import za.ac.tut.model.bl.VenueFacade;

/**
 *
 * @author Chimane Kokela
 */

@Stateless
public class StudentAllocationFacade extends AbstractFacade<StudentAllocation> implements StudentAllocationFacadeLocal {

    @EJB
private VenueFacadeLocal venueFacade;
    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentAllocationFacade() {
        super(StudentAllocation.class);
    }
    
    // ─────────────────────────────
    // Find by Exam
    // ─────────────────────────────
    @Override
    public List<StudentAllocation> findByExam(int examId) {
        return em.createQuery(
            "SELECT sa FROM StudentAllocation sa WHERE sa.exam.examId = :eid",
            StudentAllocation.class
        )
        .setParameter("eid", examId)
        .getResultList();
    }

    // ─────────────────────────────
    // Find by Student
    // ─────────────────────────────
    @Override
    public List<StudentAllocation> findByStudent(String studentNumber) {
        return em.createQuery(
            "SELECT sa FROM StudentAllocation sa WHERE sa.student.studentNumber = :sn",
            StudentAllocation.class
        )
        .setParameter("sn", studentNumber)
        .getResultList();
    }

    // ─────────────────────────────
    // Find by Venue
    // ─────────────────────────────
    @Override
    public List<StudentAllocation> findByVenue(int venueId) {
        return em.createQuery(
            "SELECT sa FROM StudentAllocation sa WHERE sa.venue.venueId = :vid",
            StudentAllocation.class
        )
        .setParameter("vid", venueId)
        .getResultList();
    }

    // ─────────────────────────────
    // Prevent duplicates
    // ─────────────────────────────
    @Override
    public boolean exists(String studentNumber, int examId) {

        TypedQuery<Long> q = em.createQuery(
            "SELECT COUNT(sa) FROM StudentAllocation sa " +
            "WHERE sa.student.studentNumber = :sn AND sa.exam.examId = :eid",
            Long.class
        );

        q.setParameter("sn", studentNumber);
        q.setParameter("eid", examId);

        return q.getSingleResult() > 0;
    }
    
    
   @Override
public void allocateStudentsToExam(int examId) {

    Exam exam = em.find(Exam.class, examId);

    if (exam == null) {
        throw new RuntimeException("Exam not found");
    }

    List<StudentModule> studentModules = em.createQuery(
        "SELECT sm FROM StudentModule sm " +
        "WHERE sm.module.moduleId = :mid",
        StudentModule.class
    )
    .setParameter("mid", exam.getModule().getModuleId())
    .getResultList();

    List<Venue> venues = venueFacade.findAll();

    if (venues == null || venues.isEmpty()) {
        throw new RuntimeException("No venues found");
    }

    int venueIndex = 0;

    for (StudentModule sm : studentModules) {

        if (exists(sm.getStudent().getStudentNumber(), examId)) {
            continue;
        }

        boolean allocated = false;

        while (!allocated && venueIndex < venues.size()) {

            Venue currentVenue = venues.get(venueIndex);

            // skip disabled venues
            if (!"AVAILABLE".equalsIgnoreCase(currentVenue.getStatus())) {
    venueIndex++;
    continue;
}

            long allocatedCount = getAllocatedCount(
                currentVenue.getVenueId()
            );

            int remainingSeats =
                currentVenue.getCapacity() - (int) allocatedCount;

            // venue full → move next
            if (remainingSeats <= 0) {
                venueIndex++;
                continue;
            }

            // allocate student
            StudentAllocation sa = new StudentAllocation();

            sa.setStudent(sm.getStudent());
            sa.setExam(exam);
            sa.setVenue(currentVenue);

            em.persist(sa);

            allocated = true;
        }

        // no venues left
        if (!allocated) {

            System.out.println(
                "⚠ No more available venues"
            );

            break;
        }
    }
}

    @Override
    public void deleteByExam(Integer examId) {
        String jpql =
        "DELETE FROM StudentAllocation s " +
        "WHERE s.exam.examId = :examId";

    Query query = em.createQuery(jpql);

    query.setParameter("examId", examId);

    query.executeUpdate();
    }

    @Override
    public List<StudentAllocation> findByStudentNumber(String studentNumber) {
       
    String jpql =
            "SELECT s FROM StudentAllocation s " +
            "WHERE s.student.studentNumber = :studentNumber";

    Query query = em.createQuery(jpql);

    query.setParameter("studentNumber", studentNumber);

    return query.getResultList();
    }

    private long getAllocatedCount(Integer venueId) {

    TypedQuery<Long> q = em.createQuery(
        "SELECT COUNT(sa) FROM StudentAllocation sa " +
        "WHERE sa.venue.venueId = :vid",
        Long.class
    );

    q.setParameter("vid", venueId);

    return q.getSingleResult();
}
    
    
    
}