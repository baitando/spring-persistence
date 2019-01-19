package com.mimacom.spring.persistence.springdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDao extends MongoRepository<Customer, Integer> {
}
