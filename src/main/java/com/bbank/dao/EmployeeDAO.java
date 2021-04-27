package com.bbank.dao;

import com.bbank.model.Customer;
import com.bbank.model.Employee;


public interface EmployeeDAO {
    public Customer loginVerification(String username, String password);

    public Employee employeeLoginVerification(String username, String password);

}

