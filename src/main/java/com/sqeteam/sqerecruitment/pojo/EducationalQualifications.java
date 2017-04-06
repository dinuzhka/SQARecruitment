package com.sqeteam.sqerecruitment.pojo;
// Generated Apr 7, 2017 1:28:55 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EducationalQualifications generated by hbm2java
 */
@Entity
@Table(name = "educational_qualifications")
public class EducationalQualifications implements java.io.Serializable {

    @Id
    @Column
    private Integer idEducationalQualifications;
    @Column
    private EducationLevels educationLevels;
    @Column
    private Persons persons;
    @Column
    private String qualificationType;
    @Column
    private String courseName;
    @Column
    private Boolean vocational;
    @Column
    private String mainSubject;
    @Column
    private String nameOfInstitutions;
    @Column
    private String country;
    @Column
    private Date yearObtained;
    @Column
    private String result;
    @Column
    private String thesesTitle;
    @Column
    private Boolean verified;
    @Column
    private String howVerified;

    public EducationalQualifications() {
    }

    public EducationalQualifications(Persons persons, String qualificationType, String courseName) {
        this.persons = persons;
        this.qualificationType = qualificationType;
        this.courseName = courseName;
    }

    public EducationalQualifications(EducationLevels educationLevels, Persons persons, String qualificationType, String courseName, Boolean vocational, String mainSubject, String nameOfInstitutions, String country, Date yearObtained, String result, String thesesTitle, Boolean verified, String howVerified) {
        this.educationLevels = educationLevels;
        this.persons = persons;
        this.qualificationType = qualificationType;
        this.courseName = courseName;
        this.vocational = vocational;
        this.mainSubject = mainSubject;
        this.nameOfInstitutions = nameOfInstitutions;
        this.country = country;
        this.yearObtained = yearObtained;
        this.result = result;
        this.thesesTitle = thesesTitle;
        this.verified = verified;
        this.howVerified = howVerified;
    }

    public Integer getIdEducationalQualifications() {
        return this.idEducationalQualifications;
    }

    public void setIdEducationalQualifications(Integer idEducationalQualifications) {
        this.idEducationalQualifications = idEducationalQualifications;
    }

    public EducationLevels getEducationLevels() {
        return this.educationLevels;
    }

    public void setEducationLevels(EducationLevels educationLevels) {
        this.educationLevels = educationLevels;
    }

    public Persons getPersons() {
        return this.persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public String getQualificationType() {
        return this.qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getVocational() {
        return this.vocational;
    }

    public void setVocational(Boolean vocational) {
        this.vocational = vocational;
    }

    public String getMainSubject() {
        return this.mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public String getNameOfInstitutions() {
        return this.nameOfInstitutions;
    }

    public void setNameOfInstitutions(String nameOfInstitutions) {
        this.nameOfInstitutions = nameOfInstitutions;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getYearObtained() {
        return this.yearObtained;
    }

    public void setYearObtained(Date yearObtained) {
        this.yearObtained = yearObtained;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getThesesTitle() {
        return this.thesesTitle;
    }

    public void setThesesTitle(String thesesTitle) {
        this.thesesTitle = thesesTitle;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getHowVerified() {
        return this.howVerified;
    }

    public void setHowVerified(String howVerified) {
        this.howVerified = howVerified;
    }

}
