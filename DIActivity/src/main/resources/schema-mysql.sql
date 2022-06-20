USE `movielister-db`;

create table if not exists languages (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    languageUUID VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL
) engine=InnoDB;

create table if not exists movies (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    movieUUID INTEGER NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    director VARCHAR (255) NOT NULL,
    languageUUID VARCHAR(255) NOT NULL
) engine=InnoDB;