package br.com.crudDoctors.controller;

import java.util.List;
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

import br.com.crudDoctors.model.Doctor;
import br.com.crudDoctors.service.DoctorService;
import br.com.crudDoctors.vo.DoctorVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("v1/crud/doctor")
public class CrudDoctorsController {
	private DoctorService doctorService;

	public CrudDoctorsController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@GetMapping
	public ResponseEntity<Page<Doctor>> getAllDoctors(Pageable pageable) throws Exception {
		Page<Doctor> doctors = doctorService.getAllDoctors(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(doctors);
	}

	@GetMapping("specialties/{name}")
	public ResponseEntity<List<Doctor>> getAllDoctorsForSpecialties(@PathVariable("name") String name, Pageable pageable) throws Exception {
		List<Doctor> doctors = doctorService.getAllDoctorsForSpecialties(name,pageable);
		return ResponseEntity.status(HttpStatus.OK).body(doctors);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable("id") Long id) throws Exception {
		Optional<Doctor> doctor = doctorService.getDoctorbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
	}
	
	@PostMapping
	public ResponseEntity<?> insertDoctor(@Valid @RequestBody DoctorVO doctorVO) {
		Doctor doctor = new Doctor().setToEntity(doctorVO);
		doctorService.insertDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctor(@Valid @PathVariable("id") Long id, @RequestBody DoctorVO doctor) {
		Optional<Doctor> doc = doctorService.getDoctorbyId(id);
		Doctor newDoctor = new Doctor();
		if(doc.isPresent()) {
			newDoctor = new Doctor().changeDoctor(doctor, doc);
			doctorService.updateDoctor(newDoctor);
			log.info("Doctor was changed!!!");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newDoctor);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Doctor());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable("id") Long id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
