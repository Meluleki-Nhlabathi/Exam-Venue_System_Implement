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
import za.ac.tut.model.entity.Admin;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

    @Override
    public Admin login(String username, String password) {
         TypedQuery<Admin> query = em.createQuery(
            "SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password",
            Admin.class
        );
        query.setParameter("username", username);
        query.setParameter("password", password);
 
        List<Admin> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
    
    
}
