package com.ukid.studentRegister.service;

import com.ukid.studentRegister.domain.User;

public interface UserService {
    void addUser(User user);
    Iterable<User> getUsers();
    User getUserByUsername(String username);
}
