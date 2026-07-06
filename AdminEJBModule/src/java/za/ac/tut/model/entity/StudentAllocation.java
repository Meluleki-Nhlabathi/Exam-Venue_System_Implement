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
@Table(name = "STUDENT_ALLOCATION")
public class StudentAllocation implements Serializable {

    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    // Many allocations belong to one student
    @ManyToOne
    @JoinColumn(name = "STUDENT_NUMBER", referencedColumnName = "STUDENT_NUMBER")
    private Student student;

    // Many allocations belong to one exam
    @ManyToOne
    @JoinColumn(name = "EXAM_ID", referencedColumnName = "EXAM_ID")
    private Exam exam;

    // Many allocations belong to one venue
    @ManyToOne
    @JoinColumn(name = "VENUE_ID", referencedColumnName = "VENUE_ID")
    private Venue venue;

    // ───────── Constructors ─────────

    public StudentAllocation() {
    }

    public StudentAllocation(Student student, Exam exam, Venue venue) {
        this.student = student;
        this.exam = exam;
        this.venue = venue;
    }

    // ───────── Getters & Setters ─────────

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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    // ───────── toString ─────────

    @Override
    public String toString() {
        return "StudentAllocation{" +
                "id=" + id +
                ", student=" + (student != null ? student.getStudentNumber() : null) +
                ", exam=" + (exam != null ? exam.getExamId() : null) +
                ", venue=" + (venue != null ? venue.getVenueId() : null) +
                '}';
    }
    
}
