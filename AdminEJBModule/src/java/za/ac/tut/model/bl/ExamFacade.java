/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import za.ac.tut.model.entity.Exam;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class ExamFacade extends AbstractFacade<Exam> implements ExamFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamFacade() {
        super(Exam.class);
    }
    
    @Override
    public List<Exam> findByModule(int moduleId) {
        return em.createQuery(
            "SELECT e FROM Exam e WHERE e.module.moduleId = :mid",
            Exam.class
        )
        .setParameter("mid", moduleId)
        .getResultList();
    }
    
   @Override
    public List<Exam> findByLecturer(int lecturerId) {
        return em.createQuery(
            "SELECT e FROM Exam e " +
            "WHERE e.module IN (" +
            "  SELECT lma.module FROM LecturerModuleAccess lma " +
            "  WHERE lma.lecturer.lecturerId = :lid" +
            ")",
            Exam.class
        )
        .setParameter("lid", lecturerId)
        .getResultList();
    }
    
}
