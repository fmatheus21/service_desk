CREATE TABLE user (
  id binary(16) NOT NULL,
  id_person int NOT NULL,
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  active tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY id_person_UNIQUE (id_person),
  CONSTRAINT fk_person_user FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO user (id, id_person, created_date, active) VALUES
(UUID_TO_BIN('f968e7a9-f149-11ef-819f-581122c7752d'), 1, CURRENT_TIMESTAMP, true);

