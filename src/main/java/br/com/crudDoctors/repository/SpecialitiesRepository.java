package br.com.crudDoctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudDoctors.model.Specialties;

public interface SpecialitiesRepository extends JpaRepository<Specialties , Long>{

}
