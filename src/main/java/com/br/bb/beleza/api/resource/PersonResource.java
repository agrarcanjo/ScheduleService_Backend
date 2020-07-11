package com.br.bb.beleza.api.resource;

import com.br.bb.beleza.api.dto.AuthDTO;
import com.br.bb.beleza.api.dto.PersonDTO;
import com.br.bb.beleza.exception.ErroAutenticacao;
import com.br.bb.beleza.exception.RegraNegocioException;
import com.br.bb.beleza.model.entity.Customer;
import com.br.bb.beleza.model.entity.Person;
import com.br.bb.beleza.service.CustomerService;
import com.br.bb.beleza.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Example.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService personService;

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody AuthDTO dto ) {
        try {
            Person usuarioAutenticado = personService.auth(dto.getEmail(), dto.getSenha());
            return ResponseEntity.ok(usuarioAutenticado);
        }catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody PersonDTO dto ) {

		Person person = Person.builder()
				.name(dto.getName())
				.cellphone(dto.getCellphone())
				.email(dto.getEmail())
				.identifier(dto.getIdentifier())
				.phone(dto.getPhone())
				.genre(dto.getGenre())
				.createdDate(LocalDate.now())
				.lastModificationPerson(dto.getLastModificationPerson())
				.lastModifiedDate(new Date())
				.build();

		try {
			Person usuarioSalvo = personService.savePerson(person);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }


    @GetMapping
	public String hello(){
    	return "hello";
	}

	@GetMapping("/{id}")
	public ResponseEntity findPerson(@PathVariable("id") Long id ) {
		return personService.findById(id)
				.map( user -> new ResponseEntity(convertPerson(user), HttpStatus.OK) )
				.orElseThrow( () -> new RegraNegocioException("Usuário não encontrado para o Id informado.")); //new ResponseEntity(HttpStatus.NOT_FOUND)
	}

	private PersonDTO convertPerson(Person person){
    	return PersonDTO.builder()
				.cellphone(person.getCellphone())
				.email(person.getEmail())
				.genre(person.getGenre())
				.identifier(person.getIdentifier())
				.lastModificationPerson(person.getLastModificationPerson())
				.name(person.getName())
				.phone(person.getPhone())
				.createdDate(person.getCreatedDate() != null ? person.getCreatedDate().toString(): "")
				.lastModifiedDate(person.getLastModifiedDate() != null ? person.getLastModifiedDate().toString(): "")
				.build();
	}

	@GetMapping
	public ResponseEntity buscar(
			@RequestParam(value ="name" , required = false) String name,
			@RequestParam(value = "identifier", required = false) String identifier
			//@RequestParam("usuario") Long idUsuario
	) {

		Person personFilter = new Person();
		personFilter.setName(name);
		personFilter.setIdentifier(identifier);

//		Optional<Person> person = personService.findById(idUsuario);
////		if(!person.isPresent()) {
////			return ResponseEntity.badRequest().body("Não foi possível realizar a consulta. Usuário não encontrado para o Id informado.");
////		}else {
////			lancamentoFiltro.setUsuario(usuario.get());
////		}


		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

		Example<Person> example = Example.of(personFilter, customExampleMatcher);

		return ResponseEntity.ok(null);
	}


}
