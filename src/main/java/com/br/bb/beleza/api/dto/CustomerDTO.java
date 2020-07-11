package com.br.bb.beleza.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private Long id;
	private String name;
	private Character gender;
	private Long idAdress;
	private String email;
	private String identifier;
	private String cellphone;
	private String phone;
	private Long userUpdate;
	private Integer typePerson;

}
