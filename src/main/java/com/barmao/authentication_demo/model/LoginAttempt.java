package com.barmao.authentication_demo.model;

import java.time.LocalDateTime;

public record LoginAttempt(String email,
                           boolean success,
                           LocalDateTime createdAt) {

}
