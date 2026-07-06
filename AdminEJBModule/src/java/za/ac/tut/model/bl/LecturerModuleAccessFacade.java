/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import za.ac.tut.model.entity.LecturerModuleAccess;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@Stateless
public class LecturerModuleAccessFacade extends AbstractFacade<LecturerModuleAccess> implements LecturerModuleAccessFacadeLocal {

    @PersistenceContext(unitName = "AdminEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LecturerModuleAccessFacade() {
        super(LecturerModuleAccess.class);
    }
    
     @Override
    public List<Module> findModulesByLecturer(int lecturerId) {
        return em.createQuery(
            "SELECT lma.module FROM LecturerModuleAccess lma " +
            "WHERE lma.lecturer.lecturerId = :id",
            Module.class
        )
        .setParameter("id", lecturerId)
        .getResultList();
    }

    /**
     * Returns all modules NOT yet linked to this lecturer
     * (so the "Add Module" screen only shows modules the lecturer
     *  hasn't joined yet — other lecturers can still share them).
     */
    @Override
    public List<Module> findModulesNotLinkedToLecturer(int lecturerId) {
        return em.createQuery(
            "SELECT m FROM Module m " +
            "WHERE m NOT IN (" +
            "  SELECT lma.module FROM LecturerModuleAccess lma " +
            "  WHERE lma.lecturer.lecturerId = :id" +
            ")",
            Module.class
        )
        .setParameter("id", lecturerId)
        .getResultList();
    }

    /**
     * Check whether a link already exists (prevent duplicates before persisting).
     */
    @Override
    public boolean linkExists(int lecturerId, int moduleId) {
        Long count = em.createQuery(
            "SELECT COUNT(lma) FROM LecturerModuleAccess lma " +
            "WHERE lma.lecturer.lecturerId = :lid " +
            "AND   lma.module.moduleId     = :mid",
            Long.class
        )
        .setParameter("lid", lecturerId)
        .setParameter("mid", moduleId)
        .getSingleResult();
        return count > 0;
    }

    /**
     * Remove the link between one lecturer and one module
     * (other lecturers keep their access).
     */
    @Override
    public void removeLink(int lecturerId, int moduleId) {
        em.createQuery(
            "DELETE FROM LecturerModuleAccess lma " +
            "WHERE lma.lecturer.lecturerId = :lid " +
            "AND   lma.module.moduleId     = :mid"
        )
        .setParameter("lid", lecturerId)
        .setParameter("mid", moduleId)
        .executeUpdate();
    }
    
}
