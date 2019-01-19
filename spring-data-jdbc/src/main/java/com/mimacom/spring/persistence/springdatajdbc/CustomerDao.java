package com.mimacom.spring.persistence.springdatajdbc;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
