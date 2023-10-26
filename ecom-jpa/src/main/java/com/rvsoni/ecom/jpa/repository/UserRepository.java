package com.rvsoni.ecom.jpa.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rvsoni.ecom.jpa.JpaUser;

@Repository
public interface UserRepository extends PagingAndSortingRepository<JpaUser,UUID>{

	JpaUser findByFirstNameAndLastName(String firstName, String lastName);
	
}
