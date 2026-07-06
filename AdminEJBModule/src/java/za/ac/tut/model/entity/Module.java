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
@Table(name = "MODULE")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODULE_ID")
    private Integer moduleId;

    @Column(name = "MODULE_CODE", nullable = false, unique = true, length = 20)
    private String moduleCode;

    @Column(name = "MODULE_NAME", nullable = false, length = 100)
    private String moduleName;

    // ✅ REMOVED: @ManyToOne lecturer field
    // Lecturer-module links now live in LECTURER_MODULE_ACCESS table.

    public Module() {}

    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public Integer getModuleId()               { return moduleId; }
    public void   setModuleId(Integer moduleId){ this.moduleId = moduleId; }

    public String getModuleCode()              { return moduleCode; }
    public void   setModuleCode(String c)      { this.moduleCode = c; }

    public String getModuleName()              { return moduleName; }
    public void   setModuleName(String n)      { this.moduleName = n; }

    @Override
    public String toString() {
        return moduleCode + " - " + moduleName;
    }
}
