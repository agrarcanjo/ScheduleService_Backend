package com.br.bb.beleza.api.resource;

import com.br.bb.beleza.api.dto.CustomerDTO;
import com.br.bb.beleza.api.dto.PersonDTO;
import com.br.bb.beleza.exception.ErroAutenticacao;
import com.br.bb.beleza.exception.RegraNegocioException;
import com.br.bb.beleza.model.entity.Customer;
import com.br.bb.beleza.service.CustomerService;
import com.br.bb.beleza.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerResource {

	private final ScheduleService lancamentoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody CustomerDTO dto ) {

//		Customer customer = Customer.builder()
//				.name(dto.getName())
//				.cellphone(dto.getCellphone())
//				.email(dto.getEmail())
//				.identifier(dto.getIdentifier())
//				.typePerson(dto.getTypePerson())
//				.genre(dto.getGender())
//				.phone(dto.getPhone())
//				.build();
//
//		try {
//			Customer usuarioSalvo = service.saveCustomer(customer);
//			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
//		}catch (RegraNegocioException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
		return null;
	}

	/*
	@GetMapping("{id}/saldo")
	public ResponseEntity obterSaldo(@PathVariable("id") Long id ) {
		Optional<Usuario> usuario = service.obterPorId(id);
		
		if(!usuario.isPresent()) {
			return new ResponseEntity( HttpStatus.NOT_FOUND );
		}
		
		BigDecimal saldo = lancamentoService.obterSaldoPorUsuario(id);
		return ResponseEntity.ok(saldo);
	}*/

}
