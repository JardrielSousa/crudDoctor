package br.com.crudDoctors.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.crudDoctors.exceptions.ResourceNotFoundException;
import br.com.crudDoctors.model.Doctor;
import br.com.crudDoctors.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
public class DoctorService {
	
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	private DoctorRepository doctorRepository;

	public Page<Doctor> getAllDoctors(Pageable pageable){
		return doctorRepository.findAll(pageable);
	}
	
	public List<Doctor> getAllDoctorsForSpecialties(String name, Pageable pageable){
		return doctorRepository.getAllDoctorsForSpecialties(name);
	}
	
	public Optional<Doctor> getDoctorbyId(Long id){
		Doctor doctor = doctorExists(id);
		return Optional.of(doctor) ;
	}
	
	public Doctor insertDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	public Doctor updateDoctor(Doctor doctor) {
		return insertDoctor(doctor);
	}
	@Transactional
	public void deleteDoctor(Long id) {
		doctorExists(id);
		doctorRepository.deleteById(id);
	}
	
	private Doctor doctorExists(Long id) {
		log.info("verifing if exists");
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if(doctor.isEmpty()) {
			throw new ResourceNotFoundException("not found for id: "+id);
		}
		return doctor.get();
	}
}
