/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 *
 * @author Chimane Kokela
 */
@Entity
@Table(
    name = "LECTURER_MODULE_ACCESS",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"LECTURER_ID", "MODULE_ID"}
    )
)
public class LecturerModuleAccess implements Serializable {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "LECTURER_ID", nullable = false)
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "MODULE_ID", nullable = false)
    private Module module;

    public LecturerModuleAccess() {}

    public LecturerModuleAccess(Lecturer lecturer, Module module) {
        this.lecturer = lecturer;
        this.module   = module;
    }

    public Long     getId()                   { return id; }
    public void     setId(Long id)            { this.id = id; }

    public Lecturer getLecturer()             { return lecturer; }
    public void     setLecturer(Lecturer l)   { this.lecturer = l; }

    public Module   getModule()               { return module; }
    public void     setModule(Module m)       { this.module = m; }
    
}
