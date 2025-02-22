CREATE TABLE person_type (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO person_type (id, name) VALUES
(1, 'PESSOA FÍSICA'),
(2, 'PESSOA JURÍDICA');

