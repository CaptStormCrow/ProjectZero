package com.bbank.dao;

import com.bbank.dao.impl.BBankDAOImpl;
import com.bbank.dao.impl.BBankDAOImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.sql.SQLException;
import java.util.List;


public interface BBankDAO {
    BBankDAOImpl loginVerification(String username, String password) throws BusinessException;
    BBankDAOImpl employeeLoginVerification(String username, String password)throws BusinessException;
    Customer getCustomerByName(String name) throws BusinessException;
    List<Customer> getCustomerByUsername(String username) throws BusinessException;
    List<Customer> getAllEmployees() throws BusinessException, SQLException, ClassNotFoundException;

    }

