package com.sqeteam.sqerecruitment.pojo;
// Generated Apr 7, 2017 1:28:55 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Experiences generated by hbm2java
 */
@Entity
@Table(name = "experiences")
public class Experiences implements java.io.Serializable {

    @Id
    @Column
    private Integer idExperiences;
    @Column
    private EmploymentLevels employmentLevels;
    @Column
    private JobTitles jobTitles;
    @Column
    private Persons persons;
    @Column
    private Date dateStarted;
    @Column
    private Date dateFinished;
    @Column
    private String otherJobTitle;
    @Column
    private String keyDuties;
    @Column
    private String employerName;
    @Column
    private Boolean verified;
    @Column
    private String howVerified;

    public Experiences() {
    }

    public Experiences(JobTitles jobTitles, Persons persons, Date dateStarted) {
        this.jobTitles = jobTitles;
        this.persons = persons;
        this.dateStarted = dateStarted;
    }

    public Experiences(EmploymentLevels employmentLevels, JobTitles jobTitles, Persons persons, Date dateStarted, Date dateFinished, String otherJobTitle, String keyDuties, String employerName, Boolean verified, String howVerified) {
        this.employmentLevels = employmentLevels;
        this.jobTitles = jobTitles;
        this.persons = persons;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
        this.otherJobTitle = otherJobTitle;
        this.keyDuties = keyDuties;
        this.employerName = employerName;
        this.verified = verified;
        this.howVerified = howVerified;
    }

    public Integer getIdExperiences() {
        return this.idExperiences;
    }

    public void setIdExperiences(Integer idExperiences) {
        this.idExperiences = idExperiences;
    }

    public EmploymentLevels getEmploymentLevels() {
        return this.employmentLevels;
    }

    public void setEmploymentLevels(EmploymentLevels employmentLevels) {
        this.employmentLevels = employmentLevels;
    }

    public JobTitles getJobTitles() {
        return this.jobTitles;
    }

    public void setJobTitles(JobTitles jobTitles) {
        this.jobTitles = jobTitles;
    }

    public Persons getPersons() {
        return this.persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public Date getDateStarted() {
        return this.dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateFinished() {
        return this.dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public String getOtherJobTitle() {
        return this.otherJobTitle;
    }

    public void setOtherJobTitle(String otherJobTitle) {
        this.otherJobTitle = otherJobTitle;
    }

    public String getKeyDuties() {
        return this.keyDuties;
    }

    public void setKeyDuties(String keyDuties) {
        this.keyDuties = keyDuties;
    }

    public String getEmployerName() {
        return this.employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
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
