package ws.tecnologia.gds.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.tecnologia.gds.models.Customer;
import ws.tecnologia.gds.services.CustomerServices;


@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {
	
	@Autowired
	private CustomerServices service;
	
	@GetMapping(value = "/{id}")
	public Optional<Customer> findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);	
	}
	
	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();	
	}
	
	@PostMapping
	public Customer create(@RequestBody Customer customer) {
		return service.create(customer);	
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		return service.update(customer);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}
	
}
