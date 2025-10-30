package com.barmao.authentication_demo.service;

import com.barmao.authentication_demo.exception.NotFoundException;
import com.barmao.authentication_demo.model.User;
import com.barmao.authentication_demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = repository.findByEmail(email).orElseThrow(() ->
                new NotFoundException(String.format("User does not exist, email: %s", email)));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.email())
                .password(user.password())
                .build();
    }
}
