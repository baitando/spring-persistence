package com.mimacom.spring.common;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers() throws Exception;
}
