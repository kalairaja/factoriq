package com.incubate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class Address {
    private String address;
    private String address1;
    private String city;
    private String state;
    private String county;
    private String postcode;
}