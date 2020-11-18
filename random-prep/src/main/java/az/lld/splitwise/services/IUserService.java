package az.lld.splitwise.services;

import az.lld.splitwise.models.User;

import java.util.List;

public interface IUserService {

    User createUser(String name);
    User getUser(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
