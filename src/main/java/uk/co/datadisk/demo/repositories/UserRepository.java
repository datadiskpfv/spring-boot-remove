package uk.co.datadisk.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import uk.co.datadisk.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
