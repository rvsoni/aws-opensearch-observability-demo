package com.rvsoni.ecom.payment.rest;

import java.util.UUID;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rvsoni.ecom.common.Payment;
import com.rvsoni.ecom.common.User;
import com.rvsoni.ecom.common.Users;
import com.rvsoni.ecom.mdc.MDCKeys;
import com.rvsoni.ecom.mdc.Operation;
import com.rvsoni.ecom.payment.AppConfig;
import com.rvsoni.ecom.payment.service.PaymentService;

@RestController
@EnableAutoConfiguration
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ResponseEntity<Payment> makePayment(@RequestParam("amount") String amount,@RequestParam("fname") String firstName,@RequestParam("lname") String lastName){
		MDC.put(MDCKeys.OPERATION.toString(), Operation.MakePayment.toString());
		MDC.put("ECom.Amount", amount);
		MDC.put("Ecom.FirstName",firstName);
		MDC.put("Ecom.LastName",lastName);
		log.info("Make a payment.");
		MDC.clear();
		
		User user = paymentService.findUser(firstName, lastName);
		
		Payment payment = new Payment(UUID.randomUUID(), amount, user);
		
		return ResponseEntity.ok(payment);
	}
}