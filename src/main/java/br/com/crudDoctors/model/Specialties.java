package br.com.crudDoctors.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.crudDoctors.vo.SpecialtiesVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Specialties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String description;
	private boolean active;
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

	public Specialties(Long id) {
		Id = id;
	}

	public Specialties setToEntity(@Valid SpecialtiesVO specialtiesVO) {
		Specialties specialties = new Specialties();
		specialties.setDescription(specialtiesVO.getDescription());
		specialties.setName(specialtiesVO.getName());
		specialties.setActive(specialtiesVO.getActive());
		specialties.setDoctor(new Doctor(specialtiesVO.getDoctorId()));
		return specialties;
	}

	public Specialties changeSpecialties(SpecialtiesVO specialtiesVO, Optional<Specialties> spe) {
		Specialties newSpecialties;
		newSpecialties = spe.get();
		newSpecialties.setId(specialtiesVO.getId());
		newSpecialties.setDescription(specialtiesVO.getDescription());
		newSpecialties.setActive(specialtiesVO.getActive());
		newSpecialties.setDoctor(new Doctor(specialtiesVO.getDoctorId()));
		return newSpecialties;
	}
}
