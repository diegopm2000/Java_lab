-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sample_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sample_db` ;

-- -----------------------------------------------------
-- Schema sample_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sample_db` ;
USE `sample_db` ;

-- -----------------------------------------------------
-- Table `sample_db`.`mark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sample_db`.`mark` ;

CREATE TABLE IF NOT EXISTS `sample_db`.`mark` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sample_db`.`shirt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sample_db`.`shirt` ;

CREATE TABLE IF NOT EXISTS `sample_db`.`shirt` (
  `id` INT NOT NULL,
  `number` INT NOT NULL,
  `idMark` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shirt_mark1_idx` (`idMark` ASC) VISIBLE,
  CONSTRAINT `fk_shirt_mark1`
    FOREIGN KEY (`idMark`)
    REFERENCES `sample_db`.`mark` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sample_db`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sample_db`.`team` ;

CREATE TABLE IF NOT EXISTS `sample_db`.`team` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sample_db`.`player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sample_db`.`player` ;

CREATE TABLE IF NOT EXISTS `sample_db`.`player` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idTeam` INT NOT NULL,
  `idShirt` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_player_team_idx` (`idTeam` ASC) VISIBLE,
  INDEX `fk_player_shirt1_idx` (`idShirt` ASC) VISIBLE,
  CONSTRAINT `fk_player_team`
    FOREIGN KEY (`idTeam`)
    REFERENCES `sample_db`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player_shirt1`
    FOREIGN KEY (`idShirt`)
    REFERENCES `sample_db`.`shirt` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `sample_db`.`mark`
-- -----------------------------------------------------
START TRANSACTION;
USE `sample_db`;
INSERT INTO `sample_db`.`mark` (`id`, `name`) VALUES (1, 'Mark 1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `sample_db`.`shirt`
-- -----------------------------------------------------
START TRANSACTION;
USE `sample_db`;
INSERT INTO `sample_db`.`shirt` (`id`, `number`, `idMark`) VALUES (1, 10, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `sample_db`.`team`
-- -----------------------------------------------------
START TRANSACTION;
USE `sample_db`;
INSERT INTO `sample_db`.`team` (`id`, `name`) VALUES (1, 'Barcelona');
INSERT INTO `sample_db`.`team` (`id`, `name`) VALUES (2, 'Juventus');

COMMIT;


-- -----------------------------------------------------
-- Data for table `sample_db`.`player`
-- -----------------------------------------------------
START TRANSACTION;
USE `sample_db`;
INSERT INTO `sample_db`.`player` (`id`, `name`, `idTeam`, `idShirt`) VALUES (1, 'Messi', 1, 1);

COMMIT;

