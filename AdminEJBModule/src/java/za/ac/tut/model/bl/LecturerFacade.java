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
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class LecturerFacade extends AbstractFacade<Lecturer> implements LecturerFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LecturerFacade() {
        super(Lecturer.class);
    }
        @Override
    public Lecturer login(String username, String password) {

    TypedQuery<Lecturer> query = em.createQuery(
        "SELECT l FROM Lecturer l WHERE l.username = :username AND l.password = :password",
        Lecturer.class
    );

    query.setParameter("username", username);
    query.setParameter("password", password);

    List<Lecturer> results = query.getResultList();

    return results.isEmpty() ? null : results.get(0);
}
    
    
    
}
