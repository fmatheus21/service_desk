CREATE TABLE contact (
  id int NOT NULL AUTO_INCREMENT,
  id_person int NOT NULL,
  phone varchar(20) NOT NULL,
  email varchar(200) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY phone_UNIQUE (phone),
  UNIQUE KEY email_UNIQUE (email),
  UNIQUE KEY id_person_UNIQUE (id_person),
  CONSTRAINT fk_person_contact FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO contact (id, id_person, phone, email) VALUES
(1, 1, '21988410901', 'GUSTAVO.NUNES@DOMAIN.COM'),
(2, 2, '31997319501', 'MARIA.FERREIRA@DOMAIN.COM');

