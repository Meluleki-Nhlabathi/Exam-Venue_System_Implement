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
import za.ac.tut.model.entity.Computer;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class ComputerFacade extends AbstractFacade<Computer> implements ComputerFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputerFacade() {
        super(Computer.class);
    }
    
    // ── Business Methods ───────────────────────────────────────────────────
 
    /**
     * Returns all computers registered to a specific venue.
     *
     * @param venueId the venue to query
     */
    @Override
    public List<Computer> findByVenue(int venueId) {
        TypedQuery<Computer> query = em.createQuery(
            "SELECT c FROM Computer c WHERE c.venue.venueId = :venueId ORDER BY c.pcNumber",
            Computer.class
        );
        query.setParameter("venueId", venueId);
        return query.getResultList();
    }
 
    /**
     * Returns only WORKING computers for a venue.
     * Used during allocation to confirm available seats.
     *
     * @param venueId the venue to query
     */
    @Override
    public List<Computer> findWorkingByVenue(int venueId) {
        TypedQuery<Computer> query = em.createQuery(
            "SELECT c FROM Computer c WHERE c.venue.venueId = :venueId AND c.status = 'WORKING' ORDER BY c.pcNumber",
            Computer.class
        );
        query.setParameter("venueId", venueId);
        return query.getResultList();
    }
 
    /**
     * Returns the count of WORKING computers in a venue.
     * This is the key figure the allocation engine uses to determine
     * how many students can be seated in a venue.
     *
     * @param venueId the venue to count
     * @return number of working computers
     */
    @Override
    public int countWorkingByVenue(int venueId) {
        TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(c) FROM Computer c WHERE c.venue.venueId = :venueId AND c.status = 'WORKING'",
            Long.class
        );
        query.setParameter("venueId", venueId);
        return query.getSingleResult().intValue();
    }
 
    /**
     * Marks a computer as WORKING.
     *
     * @param computerId the computer to update
     */
    @Override
    public void markWorking(int computerId) {
        Computer computer = find(computerId);
        if (computer != null) {
            computer.setStatus("WORKING");
            edit(computer);
        }
    }
 
    /**
     * Marks a computer as BROKEN.
     *
     * @param computerId the computer to update
     */
    @Override
    public void markBroken(int computerId) {
        Computer computer = find(computerId);
        if (computer != null) {
            computer.setStatus("NOT-WORKING");
            edit(computer);
        }
    }
    
     @Override
    public void markFaulty(int computerId) {
        Computer computer = find(computerId);
        if (computer != null) {
            computer.setStatus("FAULTY");
            edit(computer);
        }
    }
    @Override
public int countAllComputers() {
    TypedQuery<Long> query = em.createQuery(
        "SELECT COUNT(c) FROM Computer c",
        Long.class
    );
    return query.getSingleResult().intValue();
}

@Override
public int countWorkingComputers() {
    TypedQuery<Long> query = em.createQuery(
        "SELECT COUNT(c) FROM Computer c WHERE c.status = 'WORKING'",
        Long.class
    );
    return query.getSingleResult().intValue();
}
}
