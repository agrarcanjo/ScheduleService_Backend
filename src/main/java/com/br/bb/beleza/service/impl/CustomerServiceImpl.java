package com.br.bb.beleza.service.impl;

import com.br.bb.beleza.exception.ErroAutenticacao;
import com.br.bb.beleza.exception.RegraNegocioException;
import com.br.bb.beleza.model.entity.Customer;
import com.br.bb.beleza.model.entity.Person;
import com.br.bb.beleza.model.repository.CustomerRepository;
import com.br.bb.beleza.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

}
