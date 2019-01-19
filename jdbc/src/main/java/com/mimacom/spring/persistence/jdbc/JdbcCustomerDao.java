package com.mimacom.spring.persistence.jdbc;

import com.mimacom.spring.common.Customer;
import com.mimacom.spring.common.CustomerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

    @Override
    public List<Customer> getCustomers() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "sa", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT ID, FIRST_NAME, LAST_NAME FROM CUSTOMER");

        List<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            customers.add(new Customer(
                    resultSet.getInt("ID"),
                    resultSet.getString("FIRST_NAME"),
                    resultSet.getString("LAST_NAME")));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return customers;
    }
}
