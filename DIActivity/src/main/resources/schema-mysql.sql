USE  `movielister-db`;

CREATE TABLE if NOT EXISTS movies (
                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        movieId VARCHAR(255) NOT NULL UNIQUE,
                        title VARCHAR(255) NOT NULL,
                        director VARCHAR(255) NOT NULL,
) engine=InnoDB;