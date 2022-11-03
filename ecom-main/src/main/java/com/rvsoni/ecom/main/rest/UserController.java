package com.rvsoni.ecom.main.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rvsoni.ecom.common.Users;
import com.rvsoni.ecom.main.AppConfig;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;

@RestController
@EnableAutoConfiguration
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AppConfig appConfig;

	@RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
	public ResponseEntity<Users> listUsers(){
		MDC.put(MDCKeys.OPERATION.toString(), Operation.ListAllUser.toString());
		log.info("User List.");
		MDC.clear();

		ResponseEntity<Users> forEntity = restTemplate.getForEntity(appConfig.getUserServiceURL() + "/user/list", Users.class);
		
		return forEntity;
	}
}
