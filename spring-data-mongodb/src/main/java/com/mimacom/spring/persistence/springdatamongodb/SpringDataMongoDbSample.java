package com.mimacom.spring.persistence.springdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataMongoDbSample implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringDataMongoDbSample.class, args);
    }

    @Autowired
    private CustomerDao customerDao;

    public void run(String... strings) throws Exception {
        customerDao.save(new Customer(0, "Max", "Mustermann"));
        customerDao.save(new Customer(1, "Friedrich", "Freund"));

        System.out.println(customerDao.findAll());
    }
}
