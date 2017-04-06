package com.sqeteam.sqerecruitment.pojo;
// Generated Apr 7, 2017 1:28:55 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Persons generated by hbm2java
 */
@Entity
@Table(name = "persons")
public class Persons implements java.io.Serializable {

    @Id
    @Column
    private int idUser;
    @Column
    private EducationLevels educationLevels;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String title;
    @Column
    private String forename1;
    @Column
    private String forename2;
    @Column
    private String surname;
    @Column
    private String addressLine1;
    @Column
    private String addressLine2;
    @Column
    private String town;
    @Column
    private String postcode;
    @Column
    private String secondEmail;
    @Column
    private String personalUrl;
    @Column
    private byte[] photo;
    @Column
    private Boolean female;
    @Column
    private String postcodeStart;
    @Column
    private String authorityToWorkStatement;
    @Column
    private String contactPreference;
    @Column
    private Short noOfGcses;
    @Column
    private String gcseEnglishGrade;
    @Column
    private String gcseMathsGrade;
    @Column
    private Boolean fiveOrMoreGcses;
    @Column
    private Short noOfAlevels;
    @Column
    private Short ucasPoints;
    @Column
    private String studentStatus;
    @Column
    private String mobile;
    @Column
    private String landline;
    @Column
    private Date dob;
    @Column
    private Short penaltyPoints;
    @Column
    private Set<Skills> skillses = new HashSet<Skills>(0);
    @Column
    private Set<Referees> refereeses = new HashSet<Referees>(0);
    @Column
    private Set<Experiences> experienceses = new HashSet<Experiences>(0);
    @Column
    private Set<ProfessionalQualifications> professionalQualificationses = new HashSet<ProfessionalQualifications>(0);
    @Column
    private Set<EducationalQualifications> educationalQualificationses = new HashSet<EducationalQualifications>(0);
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "personses")
    private Set<JobTitles> jobTitleses = new HashSet<JobTitles>(0);

    public Persons() {
    }

    public Persons(int idUser, String username, String password, String forename1, String surname) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.forename1 = forename1;
        this.surname = surname;
    }

    public Persons(int idUser, EducationLevels educationLevels, String username, String password, String title, String forename1, String forename2, String surname, String addressLine1, String addressLine2, String town, String postcode, String secondEmail, String personalUrl, byte[] photo, Boolean female, String postcodeStart, String authorityToWorkStatement, String contactPreference, Short noOfGcses, String gcseEnglishGrade, String gcseMathsGrade, Boolean fiveOrMoreGcses, Short noOfAlevels, Short ucasPoints, String studentStatus, String mobile, String landline, Date dob, Short penaltyPoints, Set<Skills> skillses, Set<Referees> refereeses, Set<Experiences> experienceses, Set<ProfessionalQualifications> professionalQualificationses, Set<EducationalQualifications> educationalQualificationses, Set<JobTitles> jobTitleses) {
        this.idUser = idUser;
        this.educationLevels = educationLevels;
        this.username = username;
        this.password = password;
        this.title = title;
        this.forename1 = forename1;
        this.forename2 = forename2;
        this.surname = surname;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.postcode = postcode;
        this.secondEmail = secondEmail;
        this.personalUrl = personalUrl;
        this.photo = photo;
        this.female = female;
        this.postcodeStart = postcodeStart;
        this.authorityToWorkStatement = authorityToWorkStatement;
        this.contactPreference = contactPreference;
        this.noOfGcses = noOfGcses;
        this.gcseEnglishGrade = gcseEnglishGrade;
        this.gcseMathsGrade = gcseMathsGrade;
        this.fiveOrMoreGcses = fiveOrMoreGcses;
        this.noOfAlevels = noOfAlevels;
        this.ucasPoints = ucasPoints;
        this.studentStatus = studentStatus;
        this.mobile = mobile;
        this.landline = landline;
        this.dob = dob;
        this.penaltyPoints = penaltyPoints;
        this.skillses = skillses;
        this.refereeses = refereeses;
        this.experienceses = experienceses;
        this.professionalQualificationses = professionalQualificationses;
        this.educationalQualificationses = educationalQualificationses;
        this.jobTitleses = jobTitleses;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public EducationLevels getEducationLevels() {
        return this.educationLevels;
    }

    public void setEducationLevels(EducationLevels educationLevels) {
        this.educationLevels = educationLevels;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForename1() {
        return this.forename1;
    }

    public void setForename1(String forename1) {
        this.forename1 = forename1;
    }

    public String getForename2() {
        return this.forename2;
    }

    public void setForename2(String forename2) {
        this.forename2 = forename2;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSecondEmail() {
        return this.secondEmail;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }

    public String getPersonalUrl() {
        return this.personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Boolean getFemale() {
        return this.female;
    }

    public void setFemale(Boolean female) {
        this.female = female;
    }

    public String getPostcodeStart() {
        return this.postcodeStart;
    }

    public void setPostcodeStart(String postcodeStart) {
        this.postcodeStart = postcodeStart;
    }

    public String getAuthorityToWorkStatement() {
        return this.authorityToWorkStatement;
    }

    public void setAuthorityToWorkStatement(String authorityToWorkStatement) {
        this.authorityToWorkStatement = authorityToWorkStatement;
    }

    public String getContactPreference() {
        return this.contactPreference;
    }

    public void setContactPreference(String contactPreference) {
        this.contactPreference = contactPreference;
    }

    public Short getNoOfGcses() {
        return this.noOfGcses;
    }

    public void setNoOfGcses(Short noOfGcses) {
        this.noOfGcses = noOfGcses;
    }

    public String getGcseEnglishGrade() {
        return this.gcseEnglishGrade;
    }

    public void setGcseEnglishGrade(String gcseEnglishGrade) {
        this.gcseEnglishGrade = gcseEnglishGrade;
    }

    public String getGcseMathsGrade() {
        return this.gcseMathsGrade;
    }

    public void setGcseMathsGrade(String gcseMathsGrade) {
        this.gcseMathsGrade = gcseMathsGrade;
    }

    public Boolean getFiveOrMoreGcses() {
        return this.fiveOrMoreGcses;
    }

    public void setFiveOrMoreGcses(Boolean fiveOrMoreGcses) {
        this.fiveOrMoreGcses = fiveOrMoreGcses;
    }

    public Short getNoOfAlevels() {
        return this.noOfAlevels;
    }

    public void setNoOfAlevels(Short noOfAlevels) {
        this.noOfAlevels = noOfAlevels;
    }

    public Short getUcasPoints() {
        return this.ucasPoints;
    }

    public void setUcasPoints(Short ucasPoints) {
        this.ucasPoints = ucasPoints;
    }

    public String getStudentStatus() {
        return this.studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return this.landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Short getPenaltyPoints() {
        return this.penaltyPoints;
    }

    public void setPenaltyPoints(Short penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public Set<Skills> getSkillses() {
        return this.skillses;
    }

    public void setSkillses(Set<Skills> skillses) {
        this.skillses = skillses;
    }

    public Set<Referees> getRefereeses() {
        return this.refereeses;
    }

    public void setRefereeses(Set<Referees> refereeses) {
        this.refereeses = refereeses;
    }

    public Set<Experiences> getExperienceses() {
        return this.experienceses;
    }

    public void setExperienceses(Set<Experiences> experienceses) {
        this.experienceses = experienceses;
    }

    public Set<ProfessionalQualifications> getProfessionalQualificationses() {
        return this.professionalQualificationses;
    }

    public void setProfessionalQualificationses(Set<ProfessionalQualifications> professionalQualificationses) {
        this.professionalQualificationses = professionalQualificationses;
    }

    public Set<EducationalQualifications> getEducationalQualificationses() {
        return this.educationalQualificationses;
    }

    public void setEducationalQualificationses(Set<EducationalQualifications> educationalQualificationses) {
        this.educationalQualificationses = educationalQualificationses;
    }

    public Set<JobTitles> getJobTitleses() {
        return this.jobTitleses;
    }

    public void setJobTitleses(Set<JobTitles> jobTitleses) {
        this.jobTitleses = jobTitleses;
    }

}
