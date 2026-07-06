/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Venue;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface VenueFacadeLocal {

    void create(Venue venue);

    void edit(Venue venue);

    void remove(Venue venue);

    Venue find(Object id);

    List<Venue> findAll();

    List<Venue> findRange(int[] range);

    int count();
    
    /** Returns all venues with status = 'ACTIVE'. */
    List<Venue> findActiveVenues();
 
    /** Returns all venues with status = 'INACTIVE'. */
    List<Venue> findInactiveVenues();
 
    /** Soft-deletes a venue by setting its status to INACTIVE. */
    void disableVenue(int venueId);
    void enableVenue(int venueId);
    
    
    int countAllVenues();
    int countActiveVenues();
    
}
