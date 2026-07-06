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
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Chimane Kokela
 */
@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable {

   private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private int adminId;

    @Column(name = "USERNAME", length = 50)
    private String username;
 
    @Column(name = "PASSWORD", length = 50)
    private String password;
 
    // ── Constructors ───────────────────────────────────────────────────────
 
    public Admin() {
    }
 
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    // ── Getters & Setters ──────────────────────────────────────────────────
 
    public int getAdminId() {
        return adminId;
    }
 
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    // ── toString ───────────────────────────────────────────────────────────
 
    @Override
    public String toString() {
        return "Admin[ adminId=" + adminId + ", username=" + username + " ]";
    }
    
    
}
