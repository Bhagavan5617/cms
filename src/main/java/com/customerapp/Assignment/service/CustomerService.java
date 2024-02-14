package com.customerapp.Assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerapp.Assignment.model.CustomerEntity;
import com.customerapp.Assignment.repository.CustomerRepo;

@Service
public class CustomerService {

	private final CustomerRepo customerRepository;

	@Autowired
	public CustomerService(CustomerRepo customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<CustomerEntity> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	public Optional<CustomerEntity> getCustomerById(Long id) {
		
		return customerRepository.findById(id);
	}

	public CustomerEntity addCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	public Optional<CustomerEntity> updateCustomer(Long id, CustomerEntity updatedCustomer) {
		Optional<CustomerEntity> customerOptional = customerRepository.findById(id);
		if (customerOptional.isPresent()) {
			CustomerEntity customer = customerOptional.get();
			// Update the customer fields with the provided values
			customer.setFirstName(updatedCustomer.getFirstName());
			customer.setLastName(updatedCustomer.getLastName());
			customer.setAddress(updatedCustomer.getAddress());
			customer.setCity(updatedCustomer.getCity());
			customer.setState(updatedCustomer.getState());
			customer.setEmail(updatedCustomer.getEmail());
			customer.setPhone(updatedCustomer.getPhone());
		

			return Optional.of(customerRepository.save(customer));
		}
		return Optional.empty();
	}

	public boolean deleteCustomer(Long id) {
		Optional<CustomerEntity> customerOptional = customerRepository.findById(id);
		if (customerOptional.isPresent()) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
