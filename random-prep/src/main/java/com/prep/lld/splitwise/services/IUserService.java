package com.prep.lld.splitwise.services;

import com.prep.lld.splitwise.models.User;

import java.util.List;

public interface IUserService {

    User createUser(String name);
    User getUser(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
