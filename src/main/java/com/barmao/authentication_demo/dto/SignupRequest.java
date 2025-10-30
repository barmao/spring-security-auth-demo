package com.barmao.authentication_demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(   @NotBlank(message = "Name cannot be blank")
                               String name,

                               @Email(message = "Invalid email format")
                               String email,

                               @NotBlank(message = "Password cannot be blank")
                               @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
                               String password) {
}
