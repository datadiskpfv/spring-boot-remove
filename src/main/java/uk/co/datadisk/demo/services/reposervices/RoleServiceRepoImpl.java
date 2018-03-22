package uk.co.datadisk.demo.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import uk.co.datadisk.demo.domain.security.Role;
import uk.co.datadisk.demo.repositories.RoleRepsoitory;
import uk.co.datadisk.demo.services.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class RoleServiceRepoImpl implements RoleService {

    private RoleRepsoitory roleRepsoitory;

    @Autowired
    public void setRoleRepsoitory(RoleRepsoitory roleRepsoitory) {
        this.roleRepsoitory = roleRepsoitory;
    }

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepsoitory.findAll().forEach(roles::add); //fun with Java 8
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepsoitory.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepsoitory.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepsoitory.delete(id);
    }
}
