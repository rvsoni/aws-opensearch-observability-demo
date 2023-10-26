package com.rvsoni.ecom.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rvsoni.ecom.common.User;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;
import com.rvsoni.ecom.payment.AppConfig;

@Service
public class PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	public User findUser(String fname, String lname) {
		String url = appConfig.getUserServiceURL() + "/user/find?fname=" +fname +"&lname="+lname; 
		ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class);
		MDC.put(MDCKeys.OPERATION.toString(), Operation.MakePayment.toString());
		MDC.put("Ecom.User", fname + " " + lname);
		log.debug("Find User for Payment");
		MDC.clear();
		return forEntity.getBody();
	}
	
}
