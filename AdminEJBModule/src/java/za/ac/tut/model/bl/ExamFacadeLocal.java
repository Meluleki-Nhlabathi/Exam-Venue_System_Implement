/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Exam;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface ExamFacadeLocal {

    void create(Exam exam);

    void edit(Exam exam);

    void remove(Exam exam);

    Exam find(Object id);

    List<Exam> findAll();

    List<Exam> findRange(int[] range);

    int count();
    
    
    List<Exam> findByModule(int moduleId);
    List<Exam> findByLecturer(int lecturerId);
}
