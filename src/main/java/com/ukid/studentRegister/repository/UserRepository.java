package com.ukid.studentRegister.repository;

import com.ukid.studentRegister.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
