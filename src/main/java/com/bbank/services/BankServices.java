package com.bbank.services;

import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.dao.impl.BBankDAOImpl;


import java.util.Scanner;

public interface BankServices {

    //All the menus
    public CustomerServices signInCustomer(Scanner scan, String username, String password) throws BusinessException;
    public CustomerServices signUpNewCustomer(Scanner scan, String username, String password) throws BusinessException;
    public CustomerServices customerAccountMenu(Scanner scan, String username, String password) throws BusinessException;
    public EmployeeServices employeeMenu(Scanner scan, String username, String password) throws BusinessException;
    public EmployeeServices employeeSignIn(Scanner scan, String username, String password) throws BusinessException;
}
