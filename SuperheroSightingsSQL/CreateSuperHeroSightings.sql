SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS SuperHeroSighting;

CREATE DATABASE SuperHeroSighting;

USE SuperHeroSighting;

CREATE TABLE Persons (
	`PersonID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    `Description` VARCHAR(280)
);

CREATE TABLE Locations (
	`LocationID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    `Description` VARCHAR(280),
    `Street` VARCHAR(50),
    `City` VARCHAR(50),
    `State` VARCHAR(50),
    `Country` VARCHAR(50),
    `Longitude` DECIMAL(11, 8),
    `Latitude` DECIMAL(11, 8)
);

CREATE TABLE Organizations (
	`OrganizationID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    `Description` VARCHAR(280),
    `Phone` VARCHAR(50),
    `Email` VARCHAR(50),
    `LocationID` INT(11)
);

CREATE TABLE Superpowers (
	`SuperpowerID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    `Description` VARCHAR(280)
);

CREATE TABLE Persons_Superpowers (
	`Persons_SuperpowersID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `PersonID` INT(11) NOT NULL,
    `SuperpowerID` INT(11) NOT NULL
);

CREATE TABLE Persons_Organizations (
	`Persons_OrganizationsID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `PersonID` INT(11) NOT NULL,
    `OrganizationID` INT(11) NOT NULL
);

CREATE TABLE Sightings (
	`SightingID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `LocationID` INT(11) NOT NULL,
    `Date` DATE NOT NULL
);

CREATE TABLE Sightings_Persons (
	`Sightings_PersonsID` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `SightingID` INT(11) NOT NULL,
    `PersonID` INT(11) NOT NULL
);

ALTER TABLE Organizations
ADD CONSTRAINT OrganizationsLocationFK
FOREIGN KEY(LocationID) REFERENCES Locations(LocationID) ON DELETE NO ACTION;

ALTER TABLE Persons_Superpowers
ADD CONSTRAINT PS_PersonsFK
FOREIGN KEY (PersonID) REFERENCES Persons(PersonID) ON DELETE NO ACTION;

ALTER TABLE Persons_Superpowers
ADD CONSTRAINT PS_SuperpowersFK
FOREIGN KEY (SuperpowerID) REFERENCES Superpowers(SuperpowerID) ON DELETE NO ACTION;

ALTER TABLE Persons_Organizations
ADD CONSTRAINT PO_PersonsFK
FOREIGN KEY (PersonID) REFERENCES Persons(PersonID) ON DELETE NO ACTION;

ALTER TABLE Persons_Organizations
ADD CONSTRAINT PO_OrganizationsFK
FOREIGN KEY (OrganizationID) REFERENCES Organizations(OrganizationID) ON DELETE NO ACTION;

ALTER TABLE Sightings
ADD CONSTRAINT SightingsLocationFK
FOREIGN KEY (LocationID) REFERENCES Locations(LocationID) ON DELETE NO ACTION;

ALTER TABLE Sightings_Persons
ADD CONSTRAINT SP_SightingsFK
FOREIGN KEY (SightingID) REFERENCES Sightings(SightingID) ON DELETE NO ACTION;

ALTER TABLE Sightings_Persons
ADD CONSTRAINT SP_PersonsFK
FOREIGN KEY (PersonID) REFERENCES Persons(PersonID) ON DELETE NO ACTION;
