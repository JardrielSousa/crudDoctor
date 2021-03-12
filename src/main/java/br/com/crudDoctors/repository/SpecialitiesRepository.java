package br.com.crudDoctors.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.crudDoctors.model.Specialties;

public interface SpecialitiesRepository extends JpaRepository<Specialties , Long>{
	@Transactional
	@Modifying
	@Query("delete from Specialties d WHERE d.doctor = :id")
	void deleteDoctorById(Long id);
}
