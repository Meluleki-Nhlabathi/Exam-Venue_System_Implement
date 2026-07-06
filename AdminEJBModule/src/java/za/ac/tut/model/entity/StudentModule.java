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
@Table(name = "STUDENT_MODULE")
public class StudentModule implements Serializable {

   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    // 🔥 Student FK
    @ManyToOne
    @JoinColumn(name = "STUDENT_NUMBER", referencedColumnName = "STUDENT_NUMBER")
    private Student student;

    // 🔥 Module FK
    @ManyToOne
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "MODULE_ID")
    private Module module;

    public StudentModule() {
    }

    public StudentModule(Student student, Module module) {
        this.student = student;
        this.module = module;
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return student + " -> " + module;
    }
    
}
