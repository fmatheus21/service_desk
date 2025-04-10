CREATE TABLE ticket_status (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL COMMENT 'ABERTO; EM ATENDIMENTO; PENDENTE; FECHADO',
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY name_UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO ticket_status (id, name) VALUES
(1, 'ABERTO'),
(2, 'EM ATENDIMENTO'),
(3, 'PENDENTE'),
(4, 'FECHADO');

