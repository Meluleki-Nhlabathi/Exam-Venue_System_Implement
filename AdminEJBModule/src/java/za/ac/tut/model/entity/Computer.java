/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Chimane Kokela
 */
@Entity
@Table(name = "COMPUTER")
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPUTER_ID")
    private int computerId;
 
    // Many computers belong to one venue
    @ManyToOne
    @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID")
    private Venue venue;
 
    @Column(name = "PC_NUMBER", length = 20)
    private String pcNumber;
 
    // Stored as VARCHAR(25): "WORKING" or "BROKEN"
    @Column(name = "STATUS", length = 25)
    private String status;
 
    // ── Constructors ───────────────────────────────────────────────────────
 
    public Computer() {
    }
 
    public Computer(Venue venue, String pcNumber, String status) {
        this.venue    = venue;
        this.pcNumber = pcNumber;
        this.status   = status;
    }
 
    // ── Getters & Setters ──────────────────────────────────────────────────
 
    public int getComputerId() {
        return computerId;
    }
 
    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }
 
    public Venue getVenue() {
        return venue;
    }
 
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
 
    public String getPcNumber() {
        return pcNumber;
    }
 
    public void setPcNumber(String pcNumber) {
        this.pcNumber = pcNumber;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    // ── Convenience method used by allocation logic ────────────────────────
 
    public boolean isWorking() {
        return "WORKING".equalsIgnoreCase(this.status);
    }
 
    // ── toString ───────────────────────────────────────────────────────────
 
    @Override
    public String toString() {
        return "Computer[ computerId=" + computerId +
               ", pcNumber=" + pcNumber +
               ", status=" + status + " ]";
    }
    
}
