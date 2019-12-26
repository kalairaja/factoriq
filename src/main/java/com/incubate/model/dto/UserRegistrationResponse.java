package com.incubate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class UserRegistrationResponse {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
}
