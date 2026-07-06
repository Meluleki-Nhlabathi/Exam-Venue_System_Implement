/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface LecturerFacadeLocal {

    void create(Lecturer lecturer);

    void edit(Lecturer lecturer);

    void remove(Lecturer lecturer);

    Lecturer find(Object id);

    List<Lecturer> findAll();

    List<Lecturer> findRange(int[] range);

    int count();
    
    Lecturer login(String username, String password);
 
    
    
}
