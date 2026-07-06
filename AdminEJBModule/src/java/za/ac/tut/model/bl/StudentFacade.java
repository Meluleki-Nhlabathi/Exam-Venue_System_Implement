/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }
    
     @Override
    public Student findByStudentNumber(String studentNumber) {
        try {
            TypedQuery<Student> q = em.createQuery(
                "SELECT s FROM Student s WHERE s.studentNumber = :sn",
                Student.class
            );
            q.setParameter("sn", studentNumber);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
