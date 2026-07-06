/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class ModuleFacade extends AbstractFacade<Module> implements ModuleFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuleFacade() {
        super(Module.class);
    }
    
    @Override
    public Module findByCode(String code) {
    try {
        return em.createQuery(
                "SELECT m FROM Module m WHERE m.moduleCode = :code", Module.class)
                .setParameter("code", code)
                .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
   @Override
    public List<Module> findAvailableModules() {
        return em.createQuery("SELECT m FROM Module m", Module.class)
                 .getResultList();
    }

    /**
     * @deprecated Use LecturerModuleAccessFacadeLocal.findModulesByLecturer()
     */
    @Override
    @Deprecated
    public List<Module> findByLecturer(int lecturerId) {
        // Kept for backward compatibility during migration.
        // Delegates to the junction table.
        return em.createQuery(
            "SELECT lma.module FROM LecturerModuleAccess lma " +
            "WHERE lma.lecturer.lecturerId = :id",
            Module.class
        )
        .setParameter("id", lecturerId)
        .getResultList();
    }
    
}
