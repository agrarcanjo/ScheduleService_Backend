package com.br.bb.beleza.service;

import com.br.bb.beleza.model.entity.Person;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person auth(String email, String pass);
    Person savePerson(Person user);
    Optional<Person> findById(Long id);
    //List<Person> findAll(Example<Person> example);


}
