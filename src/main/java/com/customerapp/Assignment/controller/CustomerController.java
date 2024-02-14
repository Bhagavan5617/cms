package com.customerapp.Assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.Assignment.model.CustomerEntity;
import com.customerapp.Assignment.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/login/customers")
public class CustomerController {
	private final CustomerService customerService;

	@Autowired

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public List<CustomerEntity> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
		Optional<CustomerEntity> customer = customerService.getCustomerById(id);
		return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/{id}")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) {
		CustomerEntity addedCustomer = customerService.addCustomer(customer);
		System.out.println("successfull added New Customer");
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCustomer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer) {
		Optional<CustomerEntity> customer = customerService.updateCustomer(id, updatedCustomer);

		return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		boolean deleted = customerService.deleteCustomer(id);
		if (deleted) {
			System.out.println("ok sucessfully deleted");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
