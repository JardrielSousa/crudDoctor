package br.com.crudDoctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudDoctors.model.Doctor;

public interface DoctorRepository extends JpaRepository< Doctor ,Long>  {

}
