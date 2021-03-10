DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  birth_date datetime NOT NULL,
  active BOOLEAN DEFAULT true
);

