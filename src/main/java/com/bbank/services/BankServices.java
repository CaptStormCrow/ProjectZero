package com.bbank.services;

import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.util.Scanner;

public interface BankServices {

    //All the menus
    CustomerServices signInCustomer(Scanner scan, String username, String password) throws BusinessException;
    CustomerServices signUpNewCustomer(Scanner scan, String username, String password) throws BusinessException;
    CustomerServices customerAccountMenu(Scanner scan, String username, String password) throws BusinessException;
    EmployeeServices employeeMenu(Scanner scan, String username, String password) throws BusinessException;
    EmployeeServices employeeSignIn(Scanner scan, String username, String password) throws BusinessException;
}
