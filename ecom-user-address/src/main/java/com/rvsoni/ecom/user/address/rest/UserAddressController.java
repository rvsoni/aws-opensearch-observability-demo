package com.rvsoni.ecom.user.address.rest;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rvsoni.ecom.common.Address;
import com.rvsoni.ecom.jpa.JpaAddress;
import com.rvsoni.ecom.user.address.service.UserAddressService;

@RestController
@EnableAutoConfiguration
public class UserAddressController {
	
	private static final Logger log = LoggerFactory.getLogger(UserAddressController.class);
	
	@Autowired
	UserAddressService userAddressService; 

	@RequestMapping(value = "/user/{userId}/address", method = RequestMethod.GET)
	public ResponseEntity<Address> getUserAddress(@PathVariable("userId") String userId){
		
		JpaAddress jpaAddress = userAddressService.findByUserId(UUID.fromString(userId));
		
		MDC.put("Ecom.UserId", userId);
		log.info("Finding Address.");
		MDC.clear();
		
		Address address = new Address();
		address.setAddress1(jpaAddress.getAddress1());
		address.setCity(jpaAddress.getCity());
		address.setCountry(jpaAddress.getCountry());
		address.setState(jpaAddress.getState());
		address.setPincode(jpaAddress.getPincode());
		return ResponseEntity.ok(address);
	}
}