package com.ukid.studentRegister.service;

import com.ukid.studentRegister.domain.User;
import com.ukid.studentRegister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public Iterable<User> getUsers() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
