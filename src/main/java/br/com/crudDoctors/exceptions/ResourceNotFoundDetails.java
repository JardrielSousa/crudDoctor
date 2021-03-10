package br.com.crudDoctors.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundDetails {
	private String title;
	private int status;
	private String detail;
	private Long timestamp;
	private String developerMessage;
	
}
