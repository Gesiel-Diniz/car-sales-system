package ws.tecnologia.gds.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.tecnologia.gds.controllers.CustomerController;
import ws.tecnologia.gds.data.v1.CustomerValueObject;
import ws.tecnologia.gds.exceptions.ResourceNotFoundException;
import ws.tecnologia.gds.mapper.DozerMapper;
import ws.tecnologia.gds.models.Customer;
import ws.tecnologia.gds.repositories.CustomerRepository;

@Service
public class CustomerServices {
	
	private Logger logger = Logger.getLogger(CustomerServices.class.getName());
	
	@Autowired
	CustomerRepository repository;
	
	
	public CustomerValueObject findById(Long id) {
		
		Customer entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		CustomerValueObject custommer = DozerMapper.parseObject(entity, CustomerValueObject.class);

		custommer.add(linkTo(methodOn(CustomerController.class).findById(id)).withSelfRel());
		
		logger.info("List one customer!");
		
		return custommer;
		
	}
	
	public List<CustomerValueObject> findAll() {
		
		logger.info("List all customers!");
		
		List<CustomerValueObject> customers = DozerMapper.parselistObjects(repository.findAll(), CustomerValueObject.class);
		
		customers.stream().forEach(
				custom -> custom.add(linkTo(methodOn(CustomerController.class).findById(custom.getId())).withSelfRel())
		);

		return customers;
	}
	
	public CustomerValueObject create(CustomerValueObject customer) {
		
		Customer entity = DozerMapper.parseObject(customer, Customer.class);
		
		CustomerValueObject custom = DozerMapper.parseObject(repository.save(entity), CustomerValueObject.class);
		
		custom.add(linkTo(methodOn(CustomerController.class).findById(custom.getId())).withSelfRel());
		
		logger.info("Created one customer!");
		
		return custom;

	}
	
	
	public CustomerValueObject update(CustomerValueObject customer) {

		repository.findById(customer.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		Customer entity = DozerMapper.parseObject(customer, Customer.class);
		
		CustomerValueObject custom = DozerMapper.parseObject(repository.save(entity), CustomerValueObject.class);
		
		custom.add(linkTo(methodOn(CustomerController.class).findById(custom.getId())).withSelfRel());
		
		logger.info("Update one customer!");
		
		return custom;

	}
	
	public void delete(Long id) {
		
		repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		repository.deleteById(id);
		
	}

}
