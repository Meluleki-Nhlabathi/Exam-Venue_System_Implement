/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Computer;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface ComputerFacadeLocal {

    void create(Computer computer);

    void edit(Computer computer);

    void remove(Computer computer);

    Computer find(Object id);

    List<Computer> findAll();

    List<Computer> findRange(int[] range);

    int count();
    
    // ── Business methods ───────────────────────────────────────────────────
 
    /** Returns all computers belonging to a specific venue. */
    List<Computer> findByVenue(int venueId);
 
    /** Returns only WORKING computers in a specific venue. */
    List<Computer> findWorkingByVenue(int venueId);
 
    /**
     * Counts WORKING computers in a venue.
     * This is the figure used by the allocation engine.
     */
    int countWorkingByVenue(int venueId);
 
    /** Marks a computer as WORKING. */
    void markWorking(int computerId);
 
    /** Marks a computer as BROKEN. */
    void markBroken(int computerId);
    
    void markFaulty(int computerId);
    
    int countAllComputers();
    int countWorkingComputers();
    
}
