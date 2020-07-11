package com.br.bb.beleza.service;

import com.br.bb.beleza.model.entity.Customer;

import java.util.Optional;

public interface CustomerService {

	Customer saveCustomer(Customer user);

	Optional<Customer> findById(Long id);
	
}
