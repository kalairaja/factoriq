package com.incubate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private Address address;
}
