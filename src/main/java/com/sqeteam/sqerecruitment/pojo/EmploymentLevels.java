package com.sqeteam.sqerecruitment.pojo;
// Generated Apr 7, 2017 1:28:55 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmploymentLevels generated by hbm2java
 */
@Entity
@Table(name = "EmploymentLevels")
public class EmploymentLevels implements java.io.Serializable {

    @Id
    @Column
    private Short idLevelsOfEmployment;
    @Column
    private String employmentLevel;
    @Column
    private Set<Experiences> experienceses = new HashSet<Experiences>(0);

    public EmploymentLevels() {
    }

    public EmploymentLevels(String employmentLevel) {
        this.employmentLevel = employmentLevel;
    }

    public EmploymentLevels(String employmentLevel, Set<Experiences> experienceses) {
        this.employmentLevel = employmentLevel;
        this.experienceses = experienceses;
    }

    public Short getIdLevelsOfEmployment() {
        return this.idLevelsOfEmployment;
    }

    public void setIdLevelsOfEmployment(Short idLevelsOfEmployment) {
        this.idLevelsOfEmployment = idLevelsOfEmployment;
    }

    public String getEmploymentLevel() {
        return this.employmentLevel;
    }

    public void setEmploymentLevel(String employmentLevel) {
        this.employmentLevel = employmentLevel;
    }

    public Set<Experiences> getExperienceses() {
        return this.experienceses;
    }

    public void setExperienceses(Set<Experiences> experienceses) {
        this.experienceses = experienceses;
    }

}
