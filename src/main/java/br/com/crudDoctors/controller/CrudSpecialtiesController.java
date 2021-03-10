package br.com.crudDoctors.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudDoctors.model.Specialties;
import br.com.crudDoctors.service.SpecialtiesService;
import br.com.crudDoctors.vo.SpecialtiesVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("v1/crud/specialties")
public class CrudSpecialtiesController {
	private SpecialtiesService specialtiesService;

	public CrudSpecialtiesController(SpecialtiesService specialtiesService) {
		this.specialtiesService = specialtiesService;
	}

	@GetMapping
	public ResponseEntity<Page<Specialties>> getAllSpecialties(Pageable pageable) throws Exception {
		Page<Specialties> specialties = specialtiesService.getAllSpecialities(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(specialties);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Specialties>> getSpecialtiesById(@PathVariable("id") Long id) throws Exception {
		Optional<Specialties> specialties = specialtiesService.getSpecialtiesbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body(specialties);
	}
	
	@PostMapping
	public ResponseEntity<?> insertSpecialities(@Valid @RequestBody SpecialtiesVO specialtiesVO) {
		Specialties specialties = new Specialties().setToEntity(specialtiesVO);
		specialtiesService.insertSpecialties(specialties);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctor(@PathVariable("id") Long id, @RequestBody SpecialtiesVO specialtiesVO) {
		Optional<Specialties> spe = specialtiesService.getSpecialtiesbyId(id);
		Specialties newSpecialties = new Specialties();
		if (spe.isPresent()) {
			newSpecialties = new Specialties().changeSpecialties(specialtiesVO, spe);
			specialtiesService.updateSpecialties(newSpecialties);
			log.info("Specielties was changed!!!");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newSpecialties);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Specialties());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSpecialties(@PathVariable("id") Long id) {
		specialtiesService.deleteSpecialties(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
