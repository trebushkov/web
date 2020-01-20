package com.senla.cources.web.service;

import com.senla.cources.web.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String username);

    User save(User user);

    Integer getVersion();

}
