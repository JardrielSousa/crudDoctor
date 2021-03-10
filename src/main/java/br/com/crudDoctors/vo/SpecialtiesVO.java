package br.com.crudDoctors.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialtiesVO {
	private Long id;
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull(message = "description is mandatory")
	@NotBlank(message = "description is mandatory")
	private String description;
	@NotNull
	private Boolean active;
	@NotNull(message = "id doctor is mandatory")
	private Long doctorId;
}
