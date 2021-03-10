DROP TABLE IF EXISTS specialties;

CREATE TABLE specialties (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  active BOOLEAN DEFAULT true,
  doctor_id int not null,
  CONSTRAINT doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor (id)
);
