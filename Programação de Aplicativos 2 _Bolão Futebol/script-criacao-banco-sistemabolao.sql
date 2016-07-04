SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `sistemaBolao` ;
CREATE SCHEMA IF NOT EXISTS `sistemaBolao` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sistemaBolao` ;

-- -----------------------------------------------------
-- Table `sistemaBolao`.`Grupo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Grupo` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Grupo` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `descricao_UNIQUE` (`descricao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Time` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Time` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(100) NULL,
  `cidade` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `endereco` VARCHAR(100) NULL,
  `site` VARCHAR(50) NULL,
  `nome` VARCHAR(100) NULL,
  `telefone` VARCHAR(50) NULL,
  `logo` BLOB NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Apostador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Apostador` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Apostador` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(100) NULL,
  `apelido` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `telefone` VARCHAR(40) NULL,
  `chaveGrupo` INT NOT NULL,
  `chaveTime` INT NOT NULL,
  `foto` BLOB NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `telefone_UNIQUE` (`telefone` ASC),
  INDEX `fk_Apostador_Grupo_idx` (`chaveGrupo` ASC),
  INDEX `fk_Apostador_Time1_idx` (`chaveTime` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Resultado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Resultado` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Resultado` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Competicao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Competicao` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Competicao` (
  `codigo` INT NOT NULL,
  `Torneio` VARCHAR(100) NULL,
  `datainicio` DATE NULL,
  `datafim` DATE NULL,
  `descricao` VARCHAR(150) NULL,
  `rodadaAtual` INT NULL,
  `totalRodadas` INT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Rodada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Rodada` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Rodada` (
  `codigo` INT NOT NULL,
  `numeroRodada` INT NULL,
  `datainicio` DATE NULL,
  `datafim` DATE NULL,
  `observacoes` VARCHAR(150) NULL,
  `chaveCompeticao` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Rodada_Competicao1_idx` (`chaveCompeticao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`JogosRodada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`JogosRodada` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`JogosRodada` (
  `codigo` INT NOT NULL,
  `chaveTimeMandante` INT NOT NULL,
  `chaveTimeVisitante` INT NOT NULL,
  `resultadoMandante` INT NULL,
  `resultadoVisitante` INT NULL,
  `Rodadacol` VARCHAR(45) NULL,
  `chaveResultado` INT NOT NULL,
  `chaveRodada` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Rodada_Time1_idx` (`chaveTimeMandante` ASC),
  INDEX `fk_Rodada_Time2_idx` (`chaveTimeVisitante` ASC),
  INDEX `fk_Rodada_Resultado1_idx` (`chaveResultado` ASC),
  INDEX `fk_JogosRodada_Rodada1_idx` (`chaveRodada` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`Palpites`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`Palpites` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`Palpites` (
  `codigo` INT NOT NULL,
  `chaveApostador` INT NOT NULL,
  `chaveJogoRodada` INT NOT NULL,
  `resultadoMandante` INT NULL,
  `resultadoVisitante` INT NULL,
  `chaveResultado` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Palpites_Apostador1_idx` (`chaveApostador` ASC),
  INDEX `fk_Palpites_JogosRodada1_idx` (`chaveJogoRodada` ASC),
  INDEX `fk_Palpites_Resultado1_idx` (`chaveResultado` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`TabelaCompeticao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`TabelaCompeticao` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`TabelaCompeticao` (
  `codigo` INT NOT NULL,
  `numeroPontos` INT NULL,
  `numeroJogos` INT NULL,
  `numeroVitorias` INT NULL,
  `numeroEmpates` INT NULL,
  `numeroDerrotas` INT NULL,
  `saldoGolsPro` INT NULL,
  `saldoGolsSofrido` INT NULL,
  `chaveCompeticao` INT NOT NULL,
  `chaveTime` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_TabelaCompeticao_Competicao1_idx` (`chaveCompeticao` ASC),
  INDEX `fk_TabelaCompeticao_Time1_idx` (`chaveTime` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaBolao`.`RankingBolao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaBolao`.`RankingBolao` ;

CREATE TABLE IF NOT EXISTS `sistemaBolao`.`RankingBolao` (
  `codigo` INT NOT NULL,
  `posicao` INT NULL,
  `numeroPontos` INT NULL,
  `chaveApostador` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_RankingBolao_Apostador1_idx` (`chaveApostador` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
