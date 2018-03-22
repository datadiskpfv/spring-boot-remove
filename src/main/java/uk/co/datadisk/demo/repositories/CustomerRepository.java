package uk.co.datadisk.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import uk.co.datadisk.demo.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
