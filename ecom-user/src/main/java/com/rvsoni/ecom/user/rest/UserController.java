package com.rvsoni.ecom.user.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rvsoni.ecom.common.Address;
import com.rvsoni.ecom.common.User;
import com.rvsoni.ecom.common.Users;
import com.rvsoni.ecom.jpa.JpaUser;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;
import com.rvsoni.ecom.user.AppConfig;
import com.rvsoni.ecom.user.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	UserService userService; 
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<Users> listUsers(){
		MDC.put(MDCKeys.OPERATION.toString(), Operation.ListAllUser.toString());
		log.info("User List.");
		MDC.clear();
		List<User> userList = new ArrayList<User>();
		
		Iterable<JpaUser> listAllUser = userService.listAllUser();
		
		for (JpaUser jpaUser : listAllUser) {
			/*
			 * String url = appConfig.getUserAddressServiceURL() + "/user/" + user.getId() +
			 * "/address"; ResponseEntity<Address> forEntity =
			 * restTemplate.getForEntity(url, Address.class);
			 * MDC.put(MDCKeys.OPERATION.toString(), Operation.FetchUserAddress.toString());
			 * MDC.put("UserId", user.getId().toString());
			 * MDC.put("FirstName",user.getFirstName());
			 * MDC.put("LastName",user.getLastName()); log.debug("Get User Address.");
			 * MDC.clear();
			 */
			User user = new User(jpaUser.getId(), jpaUser.getFirstName(),jpaUser.getLastName());
			Address address = userService.findAddress(user);
			user.setAddress(address);
			userList.add(user);
		} 
		
		Users users = new Users();
		users.setUsers(userList);
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value = "/user/find", method = RequestMethod.GET)
	public ResponseEntity<User> findUser(@RequestParam("fname") String firstName,@RequestParam("lname") String lastName){
		MDC.put(MDCKeys.OPERATION.toString(), Operation.GetUser.toString());
		log.info("Finding User.");
		MDC.clear();
		JpaUser findUser = userService.findUser(firstName,lastName);
		User user = new User(findUser.getId(), findUser.getFirstName(), findUser.getLastName());
		
		Address address = userService.findAddress(user);
		user.setAddress(address);
		return ResponseEntity.ok(user);
	}
}