package br.com.crudDoctors.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.crudDoctors.vo.DoctorVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private Date birthDate;
	private Boolean active;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "doctor")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Transient
	private Set<Specialties> specialties = new HashSet<Specialties>();

	public Doctor setToEntity(DoctorVO doctorVO) {
		Doctor doctor = new Doctor();
		doctor.setName(doctorVO.getName());
		doctor.setBirthDate(doctorVO.getBirthDate());
		doctor.setActive(doctorVO.getActive());
		return doctor;
	}

	public Doctor changeDoctor(DoctorVO doctor, Optional<Doctor> doc) {
		Doctor newDoctor;
		newDoctor = doc.get();
		newDoctor.setId(doctor.getId());
		newDoctor.setName(doctor.getName());
		newDoctor.setBirthDate(doctor.getBirthDate());
		newDoctor.setActive(doctor.getActive());
		return newDoctor;
	}

	public Doctor(Long id) {
		Id = id;
	}
}
