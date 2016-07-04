CREATE DATABASE space_invaders;
USE space_invaders;
CREATE TABLE ranking (
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(30),
pontos INT,
PRIMARY KEY (id)
);

INSERT INTO ranking VALUES (null,'Rafael',2500);
INSERT INTO ranking VALUES (null,'Alan',2800);
INSERT INTO ranking VALUES (null,'Diovani',2810);
INSERT INTO ranking VALUES (null,'Karl',3100);
INSERT INTO ranking VALUES (null,'CPU',5500);
INSERT INTO ranking VALUES (null,'Rech',8100);

SELECT * FROM ranking;
SELECT 1+1;