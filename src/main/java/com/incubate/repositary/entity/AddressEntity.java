package com.incubate.repositary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity(name="est_address")
public class AddressEntity{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "address", nullable = false, length=40)
	private String address;

	@Column(name = "address1", nullable = true, length=40)
	private String address1;

	@Column(name = "city", nullable = false, length=40)
	private String city;

	@Column(name = "state", nullable = false, length=40)
	private String state;

	@Column(name = "county", nullable = true, length=40)
	private String county;

	@Column(name = "postcode", nullable = false, length=40)
	private String postcode;
}