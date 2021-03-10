package br.com.crudDoctors.vo;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorVO {
	private Long id;
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull
	@DateTimeFormat(pattern="yyyy.MM.dd HH:mm:ss")
	private Date birthDate;
	@NotNull
	private Boolean active;
	//private List<Long> specialties;
}
