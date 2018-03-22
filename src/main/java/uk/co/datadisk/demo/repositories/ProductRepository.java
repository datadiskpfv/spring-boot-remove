package uk.co.datadisk.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.datadisk.demo.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
