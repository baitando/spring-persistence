package com.mimacom.spring.persistence.springjdbc;

import com.mimacom.spring.common.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcSample implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringJdbcSample.class, args);
    }

    @Autowired
    private CustomerDao customerDao;

    public void run(String... strings) throws Exception {

        System.out.println(customerDao.getCustomers());
    }
}
