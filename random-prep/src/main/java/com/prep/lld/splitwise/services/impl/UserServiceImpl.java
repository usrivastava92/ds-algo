package com.prep.lld.splitwise.services.impl;

import com.prep.lld.splitwise.models.User;
import com.prep.lld.splitwise.services.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IUserService {

    private static final IUserService userService = new UserServiceImpl();
    private static final Map<Long, User> USER_MAP = new HashMap<>();
    private static long id = 1;

    private UserServiceImpl() {

    }

    @Override
    public User createUser(String name) {
        User user = new User(id++, name);
        USER_MAP.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(Long id) {
        return USER_MAP.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(USER_MAP.values());
    }

    @Override
    public void deleteUser(Long id) {
        USER_MAP.remove(id);
    }

    public static IUserService getInstance() {
        return userService;
    }
}
