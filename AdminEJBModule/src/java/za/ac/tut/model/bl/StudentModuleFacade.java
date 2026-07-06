/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import za.ac.tut.model.entity.Student;
import za.ac.tut.model.entity.StudentModule;
import za.ac.tut.model.entity.Module;
import za.ac.tut.model.entity.StudentAllocation;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class StudentModuleFacade extends AbstractFacade<StudentModule> implements StudentModuleFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentModuleFacade() {
        super(StudentModule.class);
    }
    
     @Override
    public List<StudentModule> findByStudent(String studentNumber) {
        return em.createQuery(
            "SELECT sm FROM StudentModule sm WHERE sm.student.studentNumber = :sn",
            StudentModule.class
        )
        .setParameter("sn", studentNumber)
        .getResultList();
    }

    @Override
    public List<StudentModule> findByModule(int moduleId) {
        return em.createQuery(
            "SELECT sm FROM StudentModule sm WHERE sm.module.moduleId = :mid",
            StudentModule.class
        )
        .setParameter("mid", moduleId)
        .getResultList();
    }

    @Override
    public boolean exists(String studentNumber, int moduleId) {
        TypedQuery<Long> q = em.createQuery(
            "SELECT COUNT(sm) FROM StudentModule sm " +
            "WHERE sm.student.studentNumber = :sn AND sm.module.moduleId = :mid",
            Long.class
        );

        q.setParameter("sn", studentNumber);
        q.setParameter("mid", moduleId);

        return q.getSingleResult() > 0;
    }
    
    
    @Override
    public void assignModulesByQualification(Student student) {

        List<Integer> modules = new ArrayList<>();

        String q = student.getQualification();

        if (q.equals("Computer Science") || q.equals("Multimedia Computing")) {
            modules = Arrays.asList(1,2,3,4,5,6,7,8,9);
        }
        else if (q.equals("Information Technology")) {
            modules = Arrays.asList(1,2,4,6);
        }
        else if (q.equals("Informatics")) {
            modules = Arrays.asList(1,2);
        }

        for (Integer moduleId : modules) {

            if (!exists(student.getStudentNumber(), moduleId)) {

                StudentModule sm = new StudentModule();

                sm.setStudent(student);
                sm.setModule(em.find(Module.class, moduleId));

                em.persist(sm);
            }
        }
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
    
    
}
