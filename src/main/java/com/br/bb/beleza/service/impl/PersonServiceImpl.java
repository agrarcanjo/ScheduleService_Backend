package com.br.bb.beleza.service.impl;

import com.br.bb.beleza.exception.ErroAutenticacao;
import com.br.bb.beleza.model.entity.Person;
import com.br.bb.beleza.model.repository.PersonRepository;
import com.br.bb.beleza.service.PersonService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository){
        this.repository = repository;
    }

    @Override
    public Person auth(String identifier, String pass) {
        Optional<Person> person = repository.findByIdentifier(identifier);

        if(!person.isPresent()) {
            throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
        }

        if(!person.get().getPass().equals(pass)) {
            throw new ErroAutenticacao("Senha inválida.");
        }

        return person.get();
    }

    @Override
    public Person savePerson(Person user) {
        return repository.save(user);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

//    @Override
//    public List<Person> findAll(Example<Person> example) {
//        return null ; //repository.findAll(example);
//    }

}
