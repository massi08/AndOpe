-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: andope

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `idU` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idU`)
)

DROP TABLE IF EXISTS `cours`;

CREATE TABLE `cours` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `nbExercices` int(11) DEFAULT NULL,
  PRIMARY KEY (`idC`)
)

DROP TABLE IF EXISTS `exercice`;

CREATE TABLE `exercice` (
  `idE` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `idC` int(11) NOT NULL,
  PRIMARY KEY (`idE`),
  KEY `exercice_cours_idC_fk` (`idC`),
  CONSTRAINT `exercice_cours_idC_fk` FOREIGN KEY (`idC`) REFERENCES `cours` (`idC`)
)

DROP TABLE IF EXISTS `inscrit`;

CREATE TABLE `inscrit` (
  `idI` int(11) NOT NULL AUTO_INCREMENT,
  `idU` int(11) NOT NULL,
  `idC` int(11) NOT NULL,
  PRIMARY KEY (`idI`),
  KEY `inscrit_cours_idC_fk` (`idC`),
  KEY `inscrit_user_idU_fk` (`idU`),
  CONSTRAINT `inscrit_cours_idC_fk` FOREIGN KEY (`idC`) REFERENCES `cours` (`idC`),
  CONSTRAINT `inscrit_user_idU_fk` FOREIGN KEY (`idU`) REFERENCES `user` (`idU`)
)

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `idU` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`idP`)
)

ALTER TABLE profile
ADD CONSTRAINT profile_user_idU_fk
FOREIGN KEY (idU) REFERENCES user (idU);
ALTER TABLE profile
ADD CONSTRAINT profile_exercice_idE_fk
FOREIGN KEY (idE) REFERENCES exercice (idE);


