package br.com.crudDoctors.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.crudDoctors.model.Specialties;
import br.com.crudDoctors.repository.SpecialitiesRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpecialtiesService {

	public SpecialtiesService(SpecialitiesRepository specialtiesRepository) {
		this.specialitiesRepository = specialtiesRepository;
	}

	private SpecialitiesRepository specialitiesRepository;

	public Page<Specialties> getAllSpecialities(Pageable pageable) {
		return specialitiesRepository.findAll(pageable);
	}
	
	public Optional<Specialties> getSpecialtiesbyId(Long id) {
		Specialties specialties = specialtiesExists(id);
		return Optional.of(specialties);
	}

	public Specialties insertSpecialties(Specialties specialties) {
		return specialitiesRepository.save(specialties);
	}

	public Specialties updateSpecialties(Specialties specialties) {
		return insertSpecialties(specialties);
	}

	public void deleteSpecialties(Long id) {
		specialitiesRepository.deleteById(id);
	}

	private Specialties specialtiesExists(Long id) {
		log.info("verifing if exists");
		return specialitiesRepository.findById(id).orElseThrow();
	}
}
