package com.rvsoni.ecom.jpa.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rvsoni.ecom.jpa.JpaAddress;

public interface AddressRepository  extends PagingAndSortingRepository<JpaAddress,UUID>{

	JpaAddress findByUserId(UUID userId);
}
