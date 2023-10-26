package com.rvsoni.ecom.main.rest;

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

import com.rvsoni.ecom.common.Payment;
import com.rvsoni.ecom.common.Users;
import com.rvsoni.ecom.main.AppConfig;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;

@RestController
@EnableAutoConfiguration
public class PaymentController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AppConfig appConfig;
	
	@RequestMapping(value = "/api/payment", method = RequestMethod.GET)
	public ResponseEntity<Payment> makePayment(@RequestParam("amount") String amount,@RequestParam("fname") String firstName,@RequestParam("lname") String lastName){
		MDC.put(MDCKeys.OPERATION.toString(), Operation.MakePayment.toString());
		MDC.put("ECom.Amount", amount);
		MDC.put("Ecom.FirstName",firstName);
		MDC.put("Ecom.LastName",lastName);
		log.info("Make a payment.");
		MDC.clear();
		
		String url = appConfig.getPaymentServiceURL() + "/payment?fname="+firstName+"&lname="+lastName+"&amount="+amount;
		
		ResponseEntity<Payment> forEntity = restTemplate.getForEntity(url, Payment.class);
		
		return forEntity;
	}
}
