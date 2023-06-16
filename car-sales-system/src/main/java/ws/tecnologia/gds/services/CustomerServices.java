package ws.tecnologia.gds.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.tecnologia.gds.exceptions.ResourceNotFoundException;
import ws.tecnologia.gds.models.Customer;
import ws.tecnologia.gds.repositories.CustomerRepository;

@Service
public class CustomerServices {
	
	private Logger logger = Logger.getLogger(CustomerServices.class.getName());
	
	@Autowired
	CustomerRepository repository;
	
	
	public Optional<Customer> findById(Long id) {
		
		repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		logger.info("List one customer!");
		
		return repository.findById(id);
	}
	
	public List<Customer> findAll() {
		
		logger.info("List all customers!");
		
		return repository.findAll();
	}
	
	public Customer create(Customer customer) {
		
		logger.info("Created one customer!");
		
		return repository.save(customer);
	}
	
	
	public Customer update(Customer customer) {
		
		logger.info("Update one customer!");
		
		repository.findById(customer.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		return repository.save(customer);

	}
	
	public void delete(Long id) {
		
		repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

		repository.deleteById(id);
		
	}

}
