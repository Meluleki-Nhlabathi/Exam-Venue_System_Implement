/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface ModuleFacadeLocal {

    void create(Module module);

    void edit(Module module);

    void remove(Module module);

    Module find(Object id);

    List<Module> findAll();

    List<Module> findRange(int[] range);

    int count();
    
    Module findByCode(String code);
    List<Module> findAvailableModules();
    List<Module> findByLecturer(int lecturerId);
}
