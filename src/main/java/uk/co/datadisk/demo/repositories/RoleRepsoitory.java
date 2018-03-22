package uk.co.datadisk.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import uk.co.datadisk.demo.domain.security.Role;

public interface RoleRepsoitory extends CrudRepository<Role, Integer> {
}
