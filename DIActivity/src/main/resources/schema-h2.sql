drop table languages if exists;
CREATE SEQUENCE language_language_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

create table languages (
    id INT NOT NULL AUTO_INCREMENT,
    languageUUID VARCHAR(255) DEFAULT nextval('language_language_id_seq') NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE movies IF EXISTS;

CREATE TABLE movies (
    id INT NOT NULL AUTO_INCREMENT,
    movieUUID VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    languageUUID VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);