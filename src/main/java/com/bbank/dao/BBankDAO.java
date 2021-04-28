package com.bbank.dao;

import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.model.Employee;

import java.util.List;


public interface BBankDAO {
    BBankImpl loginVerification(String username, String password) throws BusinessException;
    BBankImpl employeeLoginVerification(String username, String password)throws BusinessException;
    BBankImpl getCustomerByFirstName(String firstName)throws BusinessException;
    BBankImpl getCustomerByLastName(String lastName)throws BusinessException;
    BBankImpl getCustomerByUserName(String username)throws BusinessException;
}

