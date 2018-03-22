package uk.co.datadisk.demo.services;

import uk.co.datadisk.demo.domain.User;

public interface UserService extends CRUDService<User> {

    User findByUserName(String userName);
}
