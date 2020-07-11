package com.br.bb.beleza.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private String name;
	private Character genre;
	private String email;
	private String identifier;
	private String cellphone;
	private String phone;
	private String lastModificationPerson;
	private String createdDate;
	private String lastModifiedDate;

}
