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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Chimane Kokela
 */
@Entity
@Table(name = "LecturerTBL")
@SecondaryTable(
    name = "Lecturer_ContactTBL",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "LECTURER_ID")
)
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURER_ID")
    private int lecturerId;

    // MAIN TABLE FIELDS
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "EMAIL", length = 100, unique = true)
    private String email;

    @Column(name = "PASSWORD", length = 50)
    private String password;

    @Column(name = "EMPLOYEE_NUMBER", length = 20, unique = true)
    private String employeeNumber;

    // SECONDARY TABLE FIELDS
    @Column(name = "PHONE", length = 15, table = "Lecturer_ContactTBL")
    private String phone;

    @Column(name = "DEPARTMENT", length = 100, table = "Lecturer_ContactTBL")
    private String department;

    @Column(name = "OFFICE_ROOM", length = 20, table = "Lecturer_ContactTBL")
    private String officeRoom;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private List<LecturerModuleAccess> moduleAccesses;

    public List<LecturerModuleAccess> getModuleAccesses() {
    return moduleAccesses;
}

public void setModuleAccesses(List<LecturerModuleAccess> moduleAccesses) {
    this.moduleAccesses = moduleAccesses;
}
    
    
    
    // ── CONSTRUCTORS ─────────────────────────────

    public Lecturer() {
    }

    public Lecturer(String firstName, String lastName, String username,
                    String email, String password, String employeeNumber,
                    String phone, String department, String officeRoom) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.employeeNumber = employeeNumber;
        this.phone = phone;
        this.department = department;
        this.officeRoom = officeRoom;
    }

    // ── GETTERS & SETTERS ───────────────────────

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    // ── toString ───────────────────────────────

    @Override
    public String toString() {
        return "Lecturer[ id=" + lecturerId +
               ", username=" + username +
               ", name=" + firstName + " " + lastName +
               ", employeeNumber=" + employeeNumber + " ]";
    }
}
