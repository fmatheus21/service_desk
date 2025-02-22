CREATE TABLE ticket_discussion (
  id binary(16) NOT NULL,
  id_ticket binary(16) NOT NULL,
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  discussion mediumtext NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY fk_ticket_idx (id_ticket),
  CONSTRAINT fk_ticket FOREIGN KEY (id_ticket) REFERENCES ticket (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
