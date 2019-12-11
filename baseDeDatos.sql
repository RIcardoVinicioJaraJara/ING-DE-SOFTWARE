-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Consultorio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Consultorio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Consultorio` DEFAULT CHARACTER SET utf8 ;
USE `Consultorio` ;

-- -----------------------------------------------------
-- Table `Consultorio`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Persona` (
  `per_id` INT NOT NULL AUTO_INCREMENT,
  `per_cedula` VARCHAR(45) NULL,
  `per_nombre` VARCHAR(45) NULL,
  `per_apellido` VARCHAR(45) NULL,
  `pre_direccion` VARCHAR(45) NULL,
  `per_telefono` VARCHAR(45) NULL,
  `per_fec_nacimiento` VARCHAR(45) NULL,
  `per_mail` VARCHAR(45) NULL,
  `per_contro` VARCHAR(45) NULL,
  PRIMARY KEY (`per_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Secretario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Secretario` (
  `sec_id` INT NOT NULL AUTO_INCREMENT,
  `sec_rol` VARCHAR(45) NULL,
  `Persona_per_id` INT NOT NULL,
  PRIMARY KEY (`sec_id`),
  INDEX `fk_Secretario_Persona1_idx` (`Persona_per_id` ASC) ,
  CONSTRAINT `fk_Secretario_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `Consultorio`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Paciente` (
  `pac_id` INT NOT NULL AUTO_INCREMENT,
  `per_genero` VARCHAR(45) NULL,
  `Persona_per_id1` INT NOT NULL,
  PRIMARY KEY (`pac_id`),
  INDEX `fk_Paciente_Persona2_idx` (`Persona_per_id1` ASC) ,
  CONSTRAINT `fk_Paciente_Persona2`
    FOREIGN KEY (`Persona_per_id1`)
    REFERENCES `Consultorio`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Medico` (
  `med_id` INT NOT NULL AUTO_INCREMENT,
  `med_especialidad` VARCHAR(45) NULL,
  `Persona_per_id` INT NOT NULL,
  PRIMARY KEY (`med_id`),
  INDEX `fk_Medico_Persona1_idx` (`Persona_per_id` ASC) ,
  CONSTRAINT `fk_Medico_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `Consultorio`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Cuenta` (
  `cue_id` INT NOT NULL AUTO_INCREMENT,
  `Medico_med_id` INT NOT NULL,
  PRIMARY KEY (`cue_id`),
  INDEX `fk_Cuenta_Medico1_idx` (`Medico_med_id` ASC) ,
  CONSTRAINT `fk_Cuenta_Medico1`
    FOREIGN KEY (`Medico_med_id`)
    REFERENCES `Consultorio`.`Medico` (`med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Transaccion` (
  `tra_id` INT NOT NULL AUTO_INCREMENT,
  `tra_total` DOUBLE NULL,
  `Cuenta_cue_id1` INT NOT NULL,
  PRIMARY KEY (`tra_id`),
  INDEX `fk_Transaccion_Cuenta2_idx` (`Cuenta_cue_id1` ASC) ,
  CONSTRAINT `fk_Transaccion_Cuenta2`
    FOREIGN KEY (`Cuenta_cue_id1`)
    REFERENCES `Consultorio`.`Cuenta` (`cue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Turno` (
  `tur_id` INT NOT NULL AUTO_INCREMENT,
  `tur_hora` DATE NULL,
  `tur_fecha` DATE NULL,
  `Paciente_pac_id` INT NOT NULL,
  `Medico_med_id1` INT NOT NULL,
  PRIMARY KEY (`tur_id`),
  INDEX `fk_Turno_Paciente1_idx` (`Paciente_pac_id` ASC) ,
  INDEX `fk_Turno_Medico2_idx` (`Medico_med_id1` ASC) ,
  CONSTRAINT `fk_Turno_Paciente1`
    FOREIGN KEY (`Paciente_pac_id`)
    REFERENCES `Consultorio`.`Paciente` (`pac_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turno_Medico2`
    FOREIGN KEY (`Medico_med_id1`)
    REFERENCES `Consultorio`.`Medico` (`med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`ConsultaMedica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`ConsultaMedica` (
  `con_med_id` INT NOT NULL AUTO_INCREMENT,
  `con_med_hora` DATE NULL,
  `con_med_fecha` DATE NULL,
  `Turno_tur_id` INT NOT NULL,
  PRIMARY KEY (`con_med_id`),
  INDEX `fk_ConsultaMedica_Turno1_idx` (`Turno_tur_id` ASC) ,
  CONSTRAINT `fk_ConsultaMedica_Turno1`
    FOREIGN KEY (`Turno_tur_id`)
    REFERENCES `Consultorio`.`Turno` (`tur_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Recetas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Recetas` (
  `rec_id` INT NOT NULL AUTO_INCREMENT,
  `rec_dosis` VARCHAR(45) NULL,
  `rec_frecuencia` VARCHAR(45) NULL,
  `ConsultaMedica_con_med_id` INT NOT NULL,
  PRIMARY KEY (`rec_id`),
  INDEX `fk_Recetas_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id` ASC) ,
  CONSTRAINT `fk_Recetas_ConsultaMedica1`
    FOREIGN KEY (`ConsultaMedica_con_med_id`)
    REFERENCES `Consultorio`.`ConsultaMedica` (`con_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Medicamento` (
  `med_id` INT NOT NULL AUTO_INCREMENT,
  `med_fecha_caducidad` DATE NULL,
  PRIMARY KEY (`med_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`RecetaMedicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`RecetaMedicamento` (
  `rec_med_id` INT NOT NULL AUTO_INCREMENT,
  `rec_med_dosis` VARCHAR(45) NULL,
  `Recetas_rec_id` INT NOT NULL,
  `Medicamento_med_id` INT NOT NULL,
  PRIMARY KEY (`rec_med_id`),
  INDEX `fk_RecetaMedicamento_Recetas1_idx` (`Recetas_rec_id` ASC) ,
  INDEX `fk_RecetaMedicamento_Medicamento1_idx` (`Medicamento_med_id` ASC) ,
  CONSTRAINT `fk_RecetaMedicamento_Recetas1`
    FOREIGN KEY (`Recetas_rec_id`)
    REFERENCES `Consultorio`.`Recetas` (`rec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RecetaMedicamento_Medicamento1`
    FOREIGN KEY (`Medicamento_med_id`)
    REFERENCES `Consultorio`.`Medicamento` (`med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`FichaMedica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`FichaMedica` (
  `fic_med_id` INT NOT NULL AUTO_INCREMENT,
  `fic_med_fecha` DATE NULL,
  `fic_med_hora` DATE NULL,
  `fic_med_grupo_sanguineo` VARCHAR(45) NULL,
  `fic_med_discapacidad` VARCHAR(45) NULL,
  PRIMARY KEY (`fic_med_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`ConsultaFicha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`ConsultaFicha` (
  `con_fic_id` INT NOT NULL AUTO_INCREMENT,
  `ConsultaMedica_con_med_id` INT NOT NULL,
  `FichaMedica_fic_med_id` INT NOT NULL,
  PRIMARY KEY (`con_fic_id`),
  INDEX `fk_ConsultaFicha_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id` ASC) ,
  INDEX `fk_ConsultaFicha_FichaMedica1_idx` (`FichaMedica_fic_med_id` ASC) ,
  CONSTRAINT `fk_ConsultaFicha_ConsultaMedica1`
    FOREIGN KEY (`ConsultaMedica_con_med_id`)
    REFERENCES `Consultorio`.`ConsultaMedica` (`con_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ConsultaFicha_FichaMedica1`
    FOREIGN KEY (`FichaMedica_fic_med_id`)
    REFERENCES `Consultorio`.`FichaMedica` (`fic_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Certificado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Certificado` (
  `cer_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(999) NULL,
  `desde` DATE NULL,
  `hasta` DATE NULL,
  `ConsultaMedica_con_med_id` INT NOT NULL,
  PRIMARY KEY (`cer_id`),
  INDEX `fk_Certificado_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id` ASC) ,
  CONSTRAINT `fk_Certificado_ConsultaMedica1`
    FOREIGN KEY (`ConsultaMedica_con_med_id`)
    REFERENCES `Consultorio`.`ConsultaMedica` (`con_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Alergia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Alergia` (
  `ale_id` INT NOT NULL AUTO_INCREMENT,
  `ale_tipo` VARCHAR(45) NULL,
  `ale_descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`ale_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Vacuna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Vacuna` (
  `vac_id` INT NOT NULL AUTO_INCREMENT,
  `vac_descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`vac_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Enfermedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Enfermedad` (
  `enf_id` INT NOT NULL AUTO_INCREMENT,
  `enf_tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`enf_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Enfermedad_Ficha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Enfermedad_Ficha` (
  `idEnfermedad_Ficha` INT NOT NULL,
  `Enfermedad_enf_id` INT NOT NULL,
  `FichaMedica_fic_med_id` INT NOT NULL,
  PRIMARY KEY (`idEnfermedad_Ficha`),
  INDEX `fk_Enfermedad_Ficha_Enfermedad1_idx` (`Enfermedad_enf_id` ASC) ,
  INDEX `fk_Enfermedad_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id` ASC) ,
  CONSTRAINT `fk_Enfermedad_Ficha_Enfermedad1`
    FOREIGN KEY (`Enfermedad_enf_id`)
    REFERENCES `Consultorio`.`Enfermedad` (`enf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Enfermedad_Ficha_FichaMedica1`
    FOREIGN KEY (`FichaMedica_fic_med_id`)
    REFERENCES `Consultorio`.`FichaMedica` (`fic_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Vacuna_Ficha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Vacuna_Ficha` (
  `idVacuna_Ficha` INT NOT NULL AUTO_INCREMENT,
  `Vacuna_vac_id` INT NOT NULL,
  `FichaMedica_fic_med_id` INT NOT NULL,
  PRIMARY KEY (`idVacuna_Ficha`),
  INDEX `fk_Vacuna_Ficha_Vacuna1_idx` (`Vacuna_vac_id` ASC) ,
  INDEX `fk_Vacuna_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id` ASC) ,
  CONSTRAINT `fk_Vacuna_Ficha_Vacuna1`
    FOREIGN KEY (`Vacuna_vac_id`)
    REFERENCES `Consultorio`.`Vacuna` (`vac_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vacuna_Ficha_FichaMedica1`
    FOREIGN KEY (`FichaMedica_fic_med_id`)
    REFERENCES `Consultorio`.`FichaMedica` (`fic_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`Alergia_Ficha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultorio`.`Alergia_Ficha` (
  `idAlergia_Ficha` INT NOT NULL AUTO_INCREMENT,
  `Alergia_ale_id` INT NOT NULL,
  `FichaMedica_fic_med_id` INT NOT NULL,
  PRIMARY KEY (`idAlergia_Ficha`),
  INDEX `fk_Alergia_Ficha_Alergia1_idx` (`Alergia_ale_id` ASC) ,
  INDEX `fk_Alergia_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id` ASC) ,
  CONSTRAINT `fk_Alergia_Ficha_Alergia1`
    FOREIGN KEY (`Alergia_ale_id`)
    REFERENCES `Consultorio`.`Alergia` (`ale_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alergia_Ficha_FichaMedica1`
    FOREIGN KEY (`FichaMedica_fic_med_id`)
    REFERENCES `Consultorio`.`FichaMedica` (`fic_med_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
