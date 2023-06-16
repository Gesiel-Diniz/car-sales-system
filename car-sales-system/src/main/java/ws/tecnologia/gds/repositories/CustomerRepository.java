package ws.tecnologia.gds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.tecnologia.gds.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{}