package com.barmao.authentication_demo.service;

import com.barmao.authentication_demo.model.LoginAttempt;
import com.barmao.authentication_demo.repository.LoginAttemptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LoginService {

    private final LoginAttemptRepository repository;


    public LoginService(LoginAttemptRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addLoginAttempt(String email, boolean success){
        LoginAttempt loginAttempt = new LoginAttempt(email,success, LocalDateTime.now());
        repository.add(loginAttempt);
    }

    public List<LoginAttempt> findRecentLoginAttempts(String email) {
        return repository.findRecent(email);
    }
}
