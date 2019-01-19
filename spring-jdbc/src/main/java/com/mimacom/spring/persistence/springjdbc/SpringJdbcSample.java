package com.mimacom.spring.persistence.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJdbcSample implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringJdbcSample.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        List<Customer> customers =
                jdbcTemplate.query("SELECT ID, FIRST_NAME, LAST_NAME FROM CUSTOMER",
                        (rs, rowNum) -> new Customer(
                                rs.getInt("ID"),
                                rs.getString("FIRST_NAME"),
                                rs.getString("LAST_NAME")));
        System.out.println(customers);
    }
}
