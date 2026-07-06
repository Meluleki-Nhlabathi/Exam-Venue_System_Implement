/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.StudentAllocation;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface StudentAllocationFacadeLocal {

    void create(StudentAllocation studentAllocation);

    void edit(StudentAllocation studentAllocation);

    void remove(StudentAllocation studentAllocation);

    StudentAllocation find(Object id);

    List<StudentAllocation> findAll();

    List<StudentAllocation> findRange(int[] range);

    int count();
    
     List<StudentAllocation> findByExam(int examId);

    List<StudentAllocation> findByStudent(String studentNumber);

    List<StudentAllocation> findByVenue(int venueId);

    boolean exists(String studentNumber, int examId);
    
    void allocateStudentsToExam(int examId);
    
    void deleteByExam(Integer examId);
    
    List<StudentAllocation> findByStudentNumber(String studentNumber);
}
