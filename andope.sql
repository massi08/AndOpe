-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: andope

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `idU` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL UNIQUE,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idU`)
);

DROP TABLE IF EXISTS `Cours`;

CREATE TABLE `cours` (
  `idCours` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL UNIQUE ,
  nbExercices INT DEFAULT 0 NULL,
  PRIMARY KEY (`idCours`)
);
ALTER TABLE andope.cours ADD image VARCHAR(255) NULL;
ALTER TABLE andope.cours ADD description MEDIUMTEXT NULL;
ALTER TABLE andope.cours ADD finished INT DEFAULT 0 NOT NULL;
ALTER TABLE andope.cours ADD nbChapitre INT DEFAULT 0 NOT NULL;
DROP TABLE IF EXISTS `Chapitre`;

CREATE TABLE `chapitre` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `idCours` int NOT NULL ,
  PRIMARY KEY (`idC`),
  KEY `chapitre_cours_idC_fk` (`idCours`),
  CONSTRAINT `chapitre_cours_idC_fk` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`)
);

DROP TABLE IF EXISTS `exercice`;

CREATE TABLE `exercice` (
  `idE` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `idC` int(11) NOT NULL,
  PRIMARY KEY (`idE`),
  KEY `exercice_cours_idC_fk` (`idC`),
  CONSTRAINT `exercice_cours_idC_fk` FOREIGN KEY (`idC`) REFERENCES `chapitre` (`idC`)
);
ALTER TABLE andope.exercice ADD finished int(11);

DROP TABLE IF EXISTS `inscrit`;

CREATE TABLE `inscrit` (
  `idI` int(11) NOT NULL AUTO_INCREMENT,
  `idU` int(11) NOT NULL,
  `idCours` int(11) NOT NULL,
  PRIMARY KEY (`idI`),
  KEY `inscrit_cours_idCours_fk` (`idCours`),
  KEY `inscrit_user_idU_fk` (`idU`),
  CONSTRAINT `inscrit_cours_idC_fk` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`),
  CONSTRAINT `inscrit_user_idU_fk` FOREIGN KEY (`idU`) REFERENCES `user` (`idU`)
);

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `idU` int(11) NOT NULL,
  `idE` int(11) NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`idP`),
  KEY `profile_exercice_idE_fk` (`idE`),
  KEY `profile_user_idU_fk` (`idU`),
  CONSTRAINT `profile_exercice_idE_fk` FOREIGN KEY (`idE`) REFERENCES `exercice` (`idE`),
  CONSTRAINT `profile_user_idU_fk` FOREIGN KEY (`idU`) REFERENCES `user` (`idU`)
);
ALTER TABLE andope.profile ADD idCours INT NOT NULL;
ALTER TABLE andope.profile
ADD CONSTRAINT profile_cours_idCours_fk
FOREIGN KEY (idCours) REFERENCES cours (idCours);

DROP TABLE IF EXISTS `userchapitre`;

CREATE TABLE `userchapitre`
(
    `idUC` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `idU` INT NOT NULL,
    `idC` INT NOT NULL,
    CONSTRAINT userchapitre_user_idU_fk FOREIGN KEY (`idU`) REFERENCES user (`idU`),
    CONSTRAINT userchapitre_chapitre_idC_fk FOREIGN KEY (`idC`) REFERENCES chapitre (`idC`)
);
ALTER TABLE andope.userchapitre ADD idCours INT NULL;
ALTER TABLE andope.userchapitre
ADD CONSTRAINT userchapitre_cours_idCours_fk
FOREIGN KEY (idCours) REFERENCES cours (idCours);


