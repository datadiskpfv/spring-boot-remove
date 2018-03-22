package uk.co.datadisk.demo.services.mapservices;

import uk.co.datadisk.demo.domain.DomainObject;
import uk.co.datadisk.demo.domain.User;
import uk.co.datadisk.demo.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@Profile("map")
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public User findByUserName(String userName) {

        Optional returnUser =  domainMap.values().stream().filter(new Predicate<DomainObject>() {
            @Override
            public boolean test(DomainObject domainObject) {
                User user = (User) domainObject;
                return user.getUsername().equalsIgnoreCase(userName);
            }
        }).findFirst();

        return (User) returnUser.get();
    }
}
