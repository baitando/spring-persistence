package com.mimacom.spring.persistence.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaSample implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringDataJpaSample.class, args);
    }

    @Autowired
    private CustomerDao customerDao;

    public void run(String... strings) throws Exception {
        customerDao.save(new Customer("Max", "Mustermann"));
        customerDao.save(new Customer("Friedrich", "Freund"));
        System.out.println(customerDao.findAll());
    }
}
