package com.rvsoni.ecom.jpa;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "address")
@Entity(name = "address")
public class JpaAddress extends BaseEntity{

	private static final long serialVersionUID = 5893411882845240767L;

	private String address1;
	private String city;
	private String pincode;
	private String State;
	private String Country;
	
	private UUID userId;
	
	public JpaAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JpaAddress(UUID userId, String address1, String city, String pincode, String state, String country) {
		super();
		this.userId = userId;
		this.address1 = address1;
		this.city = city;
		this.pincode = pincode;
		State = state;
		Country = country;
	}

	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
}
