CREATE TABLE client (
  id binary(16) NOT NULL,
  id_person int NOT NULL,
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY int_UNIQUE (id),
  UNIQUE KEY id_person_UNIQUE (id_person),
  CONSTRAINT fk_person_client FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO client (id, id_person, created_date) VALUES
(UUID_TO_BIN('ae46dc08-2c64-11ee-a204-581122c7752d'), 2, CURRENT_TIMESTAMP);