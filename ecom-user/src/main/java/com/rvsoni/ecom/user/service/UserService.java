package com.rvsoni.ecom.user.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rvsoni.ecom.common.Address;
import com.rvsoni.ecom.common.User;
import com.rvsoni.ecom.jpa.JpaUser;
import com.rvsoni.ecom.jpa.repository.UserRepository;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;
import com.rvsoni.ecom.user.AppConfig;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AppConfig appConfig;
	
	@Transactional
	public Iterable<JpaUser> listAllUser() {
		return userRepository.findAll();
	}
	
	@Transactional
	public JpaUser findUser(String firstName, String lastName) {
		JpaUser user = userRepository.findByFirstNameAndLastName(firstName,lastName);
		MDC.put(MDCKeys.OPERATION.toString(),"UserFound");
		MDC.put("Ecom.FirstName",firstName);
		MDC.put("Ecom.LastName",lastName);
		log.debug("User found from database.");
		MDC.clear();
		return user;
	}
	
	public Address findAddress(User user) {
		String url = appConfig.getUserAddressServiceURL() + "/user/" + user.getId() + "/address";
		ResponseEntity<Address> forEntity = restTemplate.getForEntity(url, Address.class);
		MDC.put(MDCKeys.OPERATION.toString(), Operation.FetchUserAddress.toString());
		MDC.put("Ecom.UserId", user.getId().toString());
		MDC.put("Ecom.FirstName",user.getFirstName());
		MDC.put("Ecom.LastName",user.getLastName());
		log.debug("Get User Address.");
		MDC.clear();
		return forEntity.getBody();
	}
}
