/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.model.entity.LecturerModuleAccess;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@Local
public interface LecturerModuleAccessFacadeLocal {

    void create(LecturerModuleAccess lecturerModuleAccess);

    void edit(LecturerModuleAccess lecturerModuleAccess);

    void remove(LecturerModuleAccess lecturerModuleAccess);

    LecturerModuleAccess find(Object id);

    List<LecturerModuleAccess> findAll();

    List<LecturerModuleAccess> findRange(int[] range);

    int count();
    
    /** All modules this lecturer is linked to. */
    List<Module> findModulesByLecturer(int lecturerId);

    /** All modules this lecturer has NOT yet joined. */
    List<Module> findModulesNotLinkedToLecturer(int lecturerId);

    /** True if the lecturer-module link already exists. */
    boolean linkExists(int lecturerId, int moduleId);

    /** Delete only this lecturer's link; other lecturers keep theirs. */
    void removeLink(int lecturerId, int moduleId);
}
