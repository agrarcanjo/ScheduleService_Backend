package com.br.bb.beleza.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {

	private String email;
	private String senha;
	private String name;
}
