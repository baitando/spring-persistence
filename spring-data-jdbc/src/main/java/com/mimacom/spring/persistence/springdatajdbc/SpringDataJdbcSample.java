package com.mimacom.spring.persistence.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcSample implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringDataJdbcSample.class, args);
    }

    @Autowired
    private CustomerDao customerDao;

    public void run(String... strings) throws Exception {
        System.out.println(customerDao.findAll());
    }
}
