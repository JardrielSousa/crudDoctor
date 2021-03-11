package br.com.crudDoctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.crudDoctors.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	@Query("select distinct d from Specialties s INNER JOIN Doctor d on s.doctor = d.id where s.name = :name")
	List<Doctor> getAllDoctorsForSpecialties(@Param("name") String name);
}
