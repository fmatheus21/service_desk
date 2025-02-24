CREATE TABLE ticket (
  id binary(16) NOT NULL,
  id_client binary(16) NOT NULL,
  id_ticket_status int NOT NULL,
  id_user binary(16) COMMENT 'Usuário que está atendendo o chamado.',
  title varchar(100) NOT NULL,
  problem_description mediumtext NOT NULL,
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY fk_client_ticket_idx (id_client),
  KEY fk_status_ticket_idx (id_ticket_status),
  KEY fk_user_ticket_idx (id_user),
  CONSTRAINT fk_client_ticket FOREIGN KEY (id_client) REFERENCES client (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_status_ticket FOREIGN KEY (id_ticket_status) REFERENCES ticket_status (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_user_ticket FOREIGN KEY (id_user) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
