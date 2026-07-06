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
import za.ac.tut.model.entity.Venue;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class VenueFacade extends AbstractFacade<Venue> implements VenueFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VenueFacade() {
        super(Venue.class);
    }
    
    
    @Override
    public List<Venue> findActiveVenues() {
        TypedQuery<Venue> query = em.createQuery(
            "SELECT v FROM Venue v WHERE v.status = 'AVAILABLE' ORDER BY v.venueName",
            Venue.class
        );
        return query.getResultList();
    }
 
    /**
     * Returns all venues that are currently INACTIVE (disabled).
     */
    @Override
    public List<Venue> findInactiveVenues() {
        TypedQuery<Venue> query = em.createQuery(
            "SELECT v FROM Venue v WHERE v.status = 'MAINTENANCE' ORDER BY v.venueName",
            Venue.class
        );
        return query.getResultList();
    }
 
    /**
     * Soft-deletes a venue by marking it INACTIVE.
     * Preserves historical allocation records linked to this venue.
     *
     * @param venueId the ID of the venue to disable
     */
    @Override
    public void disableVenue(int venueId) {
        Venue venue = find(venueId);
        if (venue != null) {
            venue.setStatus("MAINTENANCE");
            edit(venue);
        }
    }
    
    @Override
public void enableVenue(int venueId) {
    Venue venue = find(venueId);

    if (venue != null) {
        venue.setStatus("AVAILABLE");
        edit(venue);
    }
}
    
@Override
public int countAllVenues() {
    TypedQuery<Long> query = em.createQuery(
        "SELECT COUNT(v) FROM Venue v",
        Long.class
    );
    return query.getSingleResult().intValue();
}

@Override
public int countActiveVenues() {
    TypedQuery<Long> query = em.createQuery(
        "SELECT COUNT(v) FROM Venue v WHERE v.status = 'AVAILABLE'",
        Long.class
    );
    return query.getSingleResult().intValue();
}
    
    
}
