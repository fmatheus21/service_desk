CREATE TABLE person_type (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY name_UNIQUE (name)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO person_type
(id,
uuid,
name)
VALUES
(<{id: }>,
<{uuid: uuid_to_bin(uuid())}>,
<{name: }>);

