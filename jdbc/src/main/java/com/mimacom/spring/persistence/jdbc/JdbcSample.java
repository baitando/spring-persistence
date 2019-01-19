package com.mimacom.spring.persistence.jdbc;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class JdbcSample {

    public static void main(String[] args) {
        JdbcSample jdbcSample = new JdbcSample();
        jdbcSample.startEmbeddedDb();
        try {
            jdbcSample.readAndPrintData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcSample.stopEmbeddedDb();
    }

    private EmbeddedDatabase embeddedDatabase;

    private void readAndPrintData() throws Exception{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "sa", "");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID, FIRST_NAME, LAST_NAME FROM CUSTOMER");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(id + ": " + firstName + " " + lastName);
            }

            resultSet.close();
            statement.close();
            connection.close();
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
}
