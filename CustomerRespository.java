package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRespository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);
  List<Customer> findByFirstName(String firstName);
  List<Customer> findByAddress(String address);
  List<Customer> findByPhone(String phone);
  List<Customer> findByEmail(String email);
  Customer findById(long id);
}