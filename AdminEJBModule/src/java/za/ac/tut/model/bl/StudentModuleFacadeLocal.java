/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Student;
import za.ac.tut.model.entity.StudentAllocation;
import za.ac.tut.model.entity.StudentModule;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface StudentModuleFacadeLocal {

    void create(StudentModule studentModule);

    void edit(StudentModule studentModule);

    void remove(StudentModule studentModule);

    StudentModule find(Object id);

    List<StudentModule> findAll();

    List<StudentModule> findRange(int[] range);

    int count();
    
    List<StudentModule> findByStudent(String studentNumber);

    List<StudentModule> findByModule(int moduleId);

    boolean exists(String studentNumber, int moduleId);
    
    void assignModulesByQualification(Student student);
    
    List<StudentAllocation> findByStudentNumber(String studentNumber);
}
