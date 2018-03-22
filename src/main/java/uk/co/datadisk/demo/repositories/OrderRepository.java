package uk.co.datadisk.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import uk.co.datadisk.demo.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
