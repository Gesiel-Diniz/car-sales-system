package ws.tecnologia.gds.controllers;

import java.util.List;

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

import ws.tecnologia.gds.data.v1.CustomerValueObject;
import ws.tecnologia.gds.services.CustomerServices;


@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {
	
	@Autowired
	private CustomerServices service;
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public CustomerValueObject findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);	
	}
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<CustomerValueObject> findAll() {
		return service.findAll();	
	}
	
	@PostMapping(produces = {"application/json", "application/xml"})
	public CustomerValueObject create(@RequestBody CustomerValueObject customer) {
		return service.create(customer);
	}
	
	@PutMapping(produces = {"application/json", "application/xml"})
	public CustomerValueObject update(@RequestBody CustomerValueObject customer) {
		return service.update(customer);	
	}
	
	@DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}
	
}
