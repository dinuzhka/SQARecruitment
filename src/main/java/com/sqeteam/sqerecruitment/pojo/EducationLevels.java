package com.sqeteam.sqerecruitment.pojo;
// Generated Apr 7, 2017 1:28:55 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EducationLevels generated by hbm2java
 */
@Entity
@Table(name = "education_levels")
public class EducationLevels implements java.io.Serializable {

    @Id
    @Column
    private Short idEducationLevel;
    @Column
    private String educationLevel;
    @Column
    private Set<EducationalQualifications> educationalQualificationses = new HashSet<EducationalQualifications>(0);
    @Column
    private Set<Persons> personses = new HashSet<Persons>(0);

    public EducationLevels() {
    }

    public EducationLevels(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public EducationLevels(String educationLevel, Set<EducationalQualifications> educationalQualificationses, Set<Persons> personses) {
        this.educationLevel = educationLevel;
        this.educationalQualificationses = educationalQualificationses;
        this.personses = personses;
    }

    public Short getIdEducationLevel() {
        return this.idEducationLevel;
    }

    public void setIdEducationLevel(Short idEducationLevel) {
        this.idEducationLevel = idEducationLevel;
    }

    public String getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Set<EducationalQualifications> getEducationalQualificationses() {
        return this.educationalQualificationses;
    }

    public void setEducationalQualificationses(Set<EducationalQualifications> educationalQualificationses) {
        this.educationalQualificationses = educationalQualificationses;
    }

    public Set<Persons> getPersonses() {
        return this.personses;
    }

    public void setPersonses(Set<Persons> personses) {
        this.personses = personses;
    }

}
