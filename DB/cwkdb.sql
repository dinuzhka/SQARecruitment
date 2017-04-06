SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- -----------------------------------------------------
-- Table `sectors`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sectors` (
  `idSectors` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `sectorTitle` VARCHAR(45) NULL DEFAULT NULL COMMENT 'e.g. from http://www.reed.co.uk/' ,
  PRIMARY KEY (`idSectors`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'industry and non-commercial job sectors';


-- -----------------------------------------------------
-- Table `education_levels`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `education_levels` (
  `idEducationLevel` SMALLINT(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Sixth-form or equivalent secondary education\nHNC or equivalent\nHND/foundation degree or equivalent\nBA/BSc Degree\nBA/BSc Hons Degree\nBA/BSc Good Hons Degree (2/1 or better)\nMA/MSc or equivalent\nDoctorate' ,
  `educationLevel` VARCHAR(100) NOT NULL COMMENT 'O-Level\nA-Level\nHND\nDegree\nMSc\nPhD\n' ,
  PRIMARY KEY (`idEducationLevel`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'e.g. Six-Form; Undergraduate; MSc/MA; Doctorate';


-- -----------------------------------------------------
-- Table `persons`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `persons` (
  `idUser` INT(10) UNSIGNED NOT NULL ,
  `username` VARCHAR(50) NOT NULL COMMENT 'must be a valid email' ,
  `password` VARCHAR(16) NOT NULL COMMENT 'encrypt' ,
  `title` VARCHAR(10) NULL DEFAULT NULL ,
  `forename1` VARCHAR(45) NOT NULL ,
  `forename2` VARCHAR(45) NULL DEFAULT NULL ,
  `surname` VARCHAR(45) NOT NULL ,
  `addressLine1` VARCHAR(45) NULL ,
  `addressLine2` VARCHAR(45) NULL ,
  `town` VARCHAR(45) NULL ,
  `postcode` VARCHAR(10) NULL ,
  `secondEmail` VARCHAR(50) NULL DEFAULT NULL COMMENT 'alternative email to be used if any problem with the username (primary email)\n' ,
  `personalUrl` VARCHAR(64) NULL DEFAULT NULL COMMENT 'increasingly common' ,
  `photo` MEDIUMBLOB NULL DEFAULT NULL COMMENT 'to be uploaded by the user' ,
  `female` BIT(1) NULL DEFAULT NULL COMMENT 'need to check whether there could be legal  issues collecting/using this info\n' ,
  `postcodeStart` VARCHAR(10) NULL DEFAULT NULL COMMENT 'first part of the the persons address postcode for distance calculation' ,
  `authorityToWorkStatement` VARCHAR(255) NULL DEFAULT NULL COMMENT 'List restrictions on work, e.g. max 20 hours per week (some non-EU residents)\nE.g. if not null it should be displayed' ,
  `contactPreference` ENUM('Mobile','Landline','Email1','Email2') NULL DEFAULT NULL COMMENT 'mobile\nlandline\nemail1 (username)\nemail2 (secondEmail)' ,
  `EducationLevels_idEducationLevel` SMALLINT(3) UNSIGNED NULL DEFAULT NULL COMMENT 'Highest education level achieved - from a drop-down' ,
  `noOfGcses` SMALLINT(3) UNSIGNED NULL DEFAULT '0' ,
  `gcseEnglishGrade` VARCHAR(2) NULL DEFAULT NULL ,
  `gcseMathsGrade` VARCHAR(2) NULL DEFAULT NULL ,
  `fiveOrMoreGcses` BIT(1) NULL DEFAULT NULL ,
  `noOfAlevels` SMALLINT(4) NULL DEFAULT '0' COMMENT 'entered by the user - could be checked against the number in the Alevels table.\nAS level is 0.5.  What about International Baccalaureate, French Baccalaureate,European Baccalaureate,Scottish Highers etc...' ,
  `ucasPoints` SMALLINT(4) NULL DEFAULT '0' COMMENT 'needed?' ,
  `studentStatus` ENUM('Full-time','Part-time','Not a student') NULL DEFAULT NULL COMMENT 'if a student then the details of the course should be stored in the Educational_qualifications table' ,
  `mobile` VARCHAR(16) NULL DEFAULT NULL ,
  `landline` VARCHAR(16) NULL ,
  `dob` DATE NULL DEFAULT NULL COMMENT 'date of birth - may be required by some employes but cannot be searched on' ,
  `penaltyPoints` SMALLINT(4) NULL DEFAULT NULL COMMENT 'on the UK driving license - see http://www.direct.gov.uk/en/Motoring/DriverLicensing/EndorsementsAndDisqualifications/DG_4022550' ,
  PRIMARY KEY (`idUser`) ,
  CONSTRAINT `fk_Persons_EducationLevels`
    FOREIGN KEY (`EducationLevels_idEducationLevel` )
    REFERENCES `education_levels` (`idEducationLevel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX fk_Persons_EducationLevels ON `persons` (`EducationLevels_idEducationLevel` ASC) ;


-- -----------------------------------------------------
-- Table `educational_qualifications`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `educational_qualifications` (
  `idEducationalQualifications` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Persons_idUser` INT(10) UNSIGNED NOT NULL ,
  `qualificationType` VARCHAR(16) NOT NULL COMMENT 'e.g. BSc, A-level, BSc Hon, BTEC HND  - using auto-complete from edu_qualifications_lookup\n' ,
  `courseName` VARCHAR(100) NOT NULL COMMENT ' e.g. Biology with Computing, Business Studies - using auto-complete\n' ,
  `EducationLevels_idEducationLevel` SMALLINT(3) UNSIGNED NULL DEFAULT NULL ,
  `vocational` BIT(1) NULL DEFAULT NULL COMMENT '1 if vocational, 0 if academic\nnull if not sure?  Not sure this is needed.' ,
  `mainSubject` VARCHAR(45) NULL DEFAULT NULL COMMENT 'e.g. Computer Science, Mechanical Engineering - auto-compelete from subjects-lookup\n' ,
  `nameOfInstitutions` VARCHAR(100) NULL DEFAULT NULL COMMENT 'school, college, university' ,
  `country` VARCHAR(45) NULL DEFAULT NULL COMMENT 'where qualification gained - auto-lookup or drop-down may be useful' ,
  `yearObtained` DATE NULL DEFAULT NULL COMMENT 'year, may be months as well?' ,
  `result` VARCHAR(20) NULL DEFAULT NULL COMMENT 'e.g. A grade, PASS, 2nd Class Hons, Distinction - where appropriate' ,
  `thesesTitle` VARCHAR(200) NULL DEFAULT NULL COMMENT 'when approapriate, e.g.final year BSc project title' ,
  `verified` BIT(1) NULL DEFAULT NULL COMMENT 'if checked' ,
  `howVerified` VARCHAR(45) NULL DEFAULT NULL COMMENT 'who checked and how' ,
  PRIMARY KEY (`idEducationalQualifications`) ,
  CONSTRAINT `fk_EduQuals_Persons`
    FOREIGN KEY (`Persons_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EduQuals_EducationLevels`
    FOREIGN KEY (`EducationLevels_idEducationLevel` )
    REFERENCES `education_levels` (`idEducationLevel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'post 16 Academic and Vocational - not Professional';

CREATE INDEX fk_EduQuals_Persons ON `educational_qualifications` (`Persons_idUser` ASC) ;

CREATE INDEX fk_EduQuals_EducationLevels ON `educational_qualifications` (`EducationLevels_idEducationLevel` ASC) ;


-- -----------------------------------------------------
-- Table `employment_levels`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employment_levels` (
  `idLevelsOfEmployment` SMALLINT(4) NOT NULL AUTO_INCREMENT ,
  `employmentLevel` VARCHAR(45) NOT NULL COMMENT 'To ascertain the nature of work experience, e.g.\nentry level; experienced/non-manager; supervisor of staff; manager; executive/senior executive' ,
  PRIMARY KEY (`idLevelsOfEmployment`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'for drop-down for experience';


-- -----------------------------------------------------
-- Table `job_titles`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `job_titles` (
  `idJobTitles` SMALLINT(6) NOT NULL AUTO_INCREMENT ,
  `jobTitle` VARCHAR(45) NULL DEFAULT NULL ,
  `Sectors_idSectors` SMALLINT(5) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`idJobTitles`) ,
  CONSTRAINT `fk_JobTitles_Sectors`
    FOREIGN KEY (`Sectors_idSectors` )
    REFERENCES `sectors` (`idSectors` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'for drop-down selection from sector/job title';

CREATE INDEX fk_JobTitles_Sectors ON `job_titles` (`Sectors_idSectors` ASC) ;


-- -----------------------------------------------------
-- Table `experiences`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `experiences` (
  `idExperiences` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Persons_idUser` INT(10) UNSIGNED NOT NULL ,
  `dateStarted` DATE NOT NULL COMMENT 'this must be unique for each person as it is part the composite PK' ,
  `dateFinished` DATE NULL DEFAULT NULL ,
  `JobTitles_idJobTitles` SMALLINT(6) NOT NULL ,
  `otherJobTitle` VARCHAR(45) NULL DEFAULT NULL COMMENT 'in case a suitable job-title is not found in the drop-down from the job_titles table' ,
  `keyDuties` VARCHAR(255) NULL DEFAULT NULL COMMENT 'this could be searchable by keywork search!?' ,
  `EmploymentLevels_idLevelsOfEmployment` SMALLINT(4) NULL DEFAULT NULL ,
  `employerName` VARCHAR(45) NULL DEFAULT NULL ,
  `verified` BIT(1) NULL DEFAULT NULL ,
  `howVerified` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idExperiences`) ,
  CONSTRAINT `fk_Experiences_EmploymentLevels`
    FOREIGN KEY (`EmploymentLevels_idLevelsOfEmployment` )
    REFERENCES `employment_levels` (`idLevelsOfEmployment` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Experiences_JobTitles`
    FOREIGN KEY (`JobTitles_idJobTitles` )
    REFERENCES `job_titles` (`idJobTitles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Experiences_Persons`
    FOREIGN KEY (`Persons_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'work experience';

CREATE INDEX fk_Experiences_JobTitles ON `experiences` (`JobTitles_idJobTitles` ASC) ;

CREATE INDEX fk_Experiences_EmploymentLevels ON `experiences` (`EmploymentLevels_idLevelsOfEmployment` ASC) ;

CREATE INDEX fk_Experiences_Persons ON `experiences` (`Persons_idUser` ASC) ;


-- -----------------------------------------------------
-- Table `job_preferences`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `job_preferences` (
  `JobTitles_idJobTitles` SMALLINT(6) NOT NULL ,
  `person_idUser` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`JobTitles_idJobTitles`, `person_idUser`) ,
  CONSTRAINT `fk_JobPreferences_JobTitles`
    FOREIGN KEY (`JobTitles_idJobTitles` )
    REFERENCES `job_titles` (`idJobTitles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JobPreferences_person`
    FOREIGN KEY (`person_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'Persons select 6 job titles from 2 sectors \n';

CREATE INDEX fk_JobPreferences_JobTitles ON `job_preferences` (`JobTitles_idJobTitles` ASC) ;

CREATE INDEX fk_JobPreferences_person ON `job_preferences` (`person_idUser` ASC) ;


-- -----------------------------------------------------
-- Table `professional_qualifications`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `professional_qualifications` (
  `idProfessionalQualifications` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Persons_idUser` INT(10) UNSIGNED NOT NULL ,
  `qualificationName` VARCHAR(100) NOT NULL ,
  `Sectors_idSectors` SMALLINT(5) UNSIGNED NULL DEFAULT NULL COMMENT 'job sector if relevant' ,
  `otherSector` VARCHAR(45) NULL DEFAULT NULL COMMENT 'alternative sector if one cannot be found in the drop-down based on the sectors table' ,
  `awardingBody` VARCHAR(45) NULL DEFAULT NULL COMMENT 'if appropriate - e.g. institute of chartered surveyors' ,
  `yearObtained` DATE NULL DEFAULT NULL ,
  `result` VARCHAR(20) NULL DEFAULT NULL COMMENT 'if appropriate - some prof qualification may have classifications - e.g. the legal practice certificate: distinctinction, commendation, pass' ,
  `verified` BIT(1) NULL DEFAULT NULL ,
  `howVerified` VARCHAR(45) NULL DEFAULT NULL COMMENT 'e.g. examining certificates or lists of members of professional bodies' ,
  PRIMARY KEY (`idProfessionalQualifications`) ,
  CONSTRAINT `fk_ProfessionalQualifications_Sectors`
    FOREIGN KEY (`Sectors_idSectors` )
    REFERENCES `sectors` (`idSectors` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProfessionalQualifications_Persons`
    FOREIGN KEY (`Persons_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX fk_ProfessionalQualifications_Sectors ON `professional_qualifications` (`Sectors_idSectors` ASC) ;

CREATE INDEX fk_ProfessionalQualifications_Persons ON `professional_qualifications` (`Persons_idUser` ASC) ;


-- -----------------------------------------------------
-- Table `referees`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `referees` (
  `idReferees` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Persons_idUser` INT(10) UNSIGNED NOT NULL ,
  `title` VARCHAR(10) NULL DEFAULT NULL ,
  `forename` VARCHAR(45) NOT NULL ,
  `surname` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(50) NULL DEFAULT NULL ,
  `contactPhone` VARCHAR(16) NULL DEFAULT NULL ,
  `relationship` ENUM('employer','academic') NULL DEFAULT NULL ,
  `permissionToContact` BIT(1) NULL DEFAULT NULL COMMENT 'the person should get an agreement and tick this box to overwrite the default 0' ,
  `permissionToStoreDetails` BIT(1) NULL DEFAULT NULL COMMENT 'person should try to get an agreement and check - otherwise the record will be deleted' ,
  `verified` BIT(1) NULL DEFAULT NULL ,
  `howVerified` VARCHAR(45) NULL DEFAULT NULL COMMENT 'referee contacted by email/phone/letter' ,
  `referenceDoc` BLOB NULL DEFAULT NULL COMMENT 'uploaded scanned reference?' ,
  PRIMARY KEY (`idReferees`) ,
  CONSTRAINT `fk_Referees_Persons`
    FOREIGN KEY (`Persons_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'need to check data protection for referee data';

CREATE INDEX fk_Referees_Persons ON `referees` (`Persons_idUser` ASC) ;


-- -----------------------------------------------------
-- Table `skills`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `skills` (
  `idSkills` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Persons_idUser` INT(10) UNSIGNED NOT NULL ,
  `skillName` VARCHAR(100) NOT NULL COMMENT 'from skills_lookup or chosen name - should be warned that may not be picked up by the business searches' ,
  `skillLevel` ENUM('Basic','Good','Excellent') NULL DEFAULT NULL COMMENT 'subjective - but may be crossreferenced to to ER tests' ,
  `verified` BIT(1) NULL DEFAULT NULL ,
  `howVerified` VARCHAR(45) NULL DEFAULT NULL COMMENT 'reference, ER test or other evidence of competence' ,
  PRIMARY KEY (`idSkills`) ,
  CONSTRAINT `fk_Skills_Persons`
    FOREIGN KEY (`Persons_idUser` )
    REFERENCES `persons` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX unique_skillPerson ON `skills` (`Persons_idUser` ASC, `skillName` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
