/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Chimane Kokela
 */
@Entity
@Table(name = "VENUE")
public class Venue implements Serializable {

     private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENUE_ID")
    private int venueId;
 
    @Column(name = "VENUE_NAME", length = 20, unique = true)
    private String venueName;
 
    @Column(name = "CAPACITY")
    private int capacity;
 
    // Stored as VARCHAR(5): "YES" or "NO"
    @Column(name = "INTERNET_ACCESS", length = 5)
    private String internetAccess;
 
    // Stored as VARCHAR(25): e.g. "ACTIVE" or "INACTIVE"
    @Column(name = "STATUS", length = 25)
    private String status;
 
    // One venue has many computers
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Computer> computers;
    
    
 
    // ── Constructors ───────────────────────────────────────────────────────
 
    public Venue() {
    }
 
    public Venue(String venueName, int capacity,
                 String internetAccess, String status) {
        this.venueName      = venueName;
        this.capacity       = capacity;
        this.internetAccess = internetAccess;
        this.status         = status;
    }
 
    // ── Getters & Setters ──────────────────────────────────────────────────
 
    public int getVenueId() {
        return venueId;
    }
 
    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
 
    public String getVenueName() {
        return venueName;
    }
 
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
 
    public String getInternetAccess() {
        return internetAccess;
    }
 
    public void setInternetAccess(String internetAccess) {
        this.internetAccess = internetAccess;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public List<Computer> getComputers() {
        return computers;
    }
 
    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
    
    public int getWorkingComputersCount() {

    int count = 0;

    if (computers != null) {

        for (Computer c : computers) {

            if ("WORKING".equalsIgnoreCase(c.getStatus())) {
                count++;
            }
        }
    }

    return count;
}
 
    // ── toString ───────────────────────────────────────────────────────────
 
    @Override
    public String toString() {
        return "Venue[ venueId=" + venueId + ", venueName=" + venueName +
               ", capacity=" + capacity + ", status=" + status + " ]";
    }
    
}
