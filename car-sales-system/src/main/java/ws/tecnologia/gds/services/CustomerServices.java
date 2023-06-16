package ws.tecnologia.gds.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		logger.info("List one customer!");
		
		return DozerMapper.parseObject(entity, CustomerValueObject.class);
		
	}
	
	public List<CustomerValueObject> findAll() {
		
		logger.info("List all customers!");
		
		List<CustomerValueObject> customers = DozerMapper.parselistObjects(repository.findAll(), CustomerValueObject.class);

		return customers;
	}
	
	public CustomerValueObject create(CustomerValueObject customer) {
		
		Customer entity = DozerMapper.parseObject(customer, Customer.class);
		
		logger.info("Created one customer!");
		
		return DozerMapper.parseObject(repository.save(entity), CustomerValueObject.class);

	}
	
	
	public CustomerValueObject update(CustomerValueObject customer) {

		repository.findById(customer.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		Customer entity = DozerMapper.parseObject(customer, Customer.class);
		
		logger.info("Update one customer!");
		
		return DozerMapper.parseObject(repository.save(entity), CustomerValueObject.class);

	}
	
	public void delete(Long id) {
		
		repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

		repository.deleteById(id);
		
	}

}
