package com.mimacom.spring.persistence.springjdbc;

import com.mimacom.spring.common.Customer;
import com.mimacom.spring.common.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpringJdbcCustomerDao implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getCustomers() throws Exception {
        return jdbcTemplate.query("SELECT ID, FIRST_NAME, LAST_NAME FROM CUSTOMER",
                (rs, rowNum) -> new Customer(
                        rs.getInt("ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME")));
    }
}
