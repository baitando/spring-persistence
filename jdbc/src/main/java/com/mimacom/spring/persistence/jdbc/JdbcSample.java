package com.mimacom.spring.persistence.jdbc;

import com.mimacom.spring.common.CustomerDao;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class JdbcSample {

    public static void main(String[] args) {
        JdbcSample jdbcSample = new JdbcSample();
        jdbcSample.startEmbeddedDb();
        jdbcSample.run();
        jdbcSample.stopEmbeddedDb();
    }

    private EmbeddedDatabase embeddedDatabase;
    private CustomerDao customerDao;

    private JdbcSample() {
        customerDao = new JdbcCustomerDao();
    }

    private void startEmbeddedDb() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        embeddedDatabase = builder
                .setType(HSQL)
                .addDefaultScripts()
                .build();
    }

    private void stopEmbeddedDb() {
        embeddedDatabase.shutdown();
    }

    private void run() {
        try {
            System.out.println(customerDao.getCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
