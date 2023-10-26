package com.rvsoni.ecom.user.address.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvsoni.ecom.jpa.JpaAddress;
import com.rvsoni.ecom.jpa.repository.AddressRepository;

@Service
public class UserAddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public JpaAddress findByUserId(UUID userId) {
		return addressRepository.findByUserId(userId);
	}
}
