package ru.itis.users.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Customer {
    private String username;
    private String password;
    private String email;
}
