package com.bbank.services;

import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerServices{

    Scanner scan= new Scanner(System.in);
    static Logger log = Logger.getLogger(CustomerServices.class.getName());

    public void customerMenu (Scanner scan) throws BusinessException {
        int startMenu = 0;
        do {
            try {
                log.info("\n\nCustomer Main Menu. Please select an option: ");
                log.info("1. Accounts");
                log.info("2. Apply for new account");
                log.info("3. Back");
                startMenu = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                log.info("Invalid Entry!");
                startMenu = 0;
            }

            switch (startMenu) {
                case 1:
                    this.customerAccountMenu(scan);
                    break;
                case 2:
                    break;
                case 3:
                    log.info("Returning to Main Menu");
                    break;
                default:
                    log.info("Thank you. Have a wonderful day.");
            }
        }while (startMenu != 3);
    }


    public void signInCustomer() throws BusinessException {
        boolean isSignedIn = false;
        String password = null;
        String username = null;
        BBankImpl bBank= new BBankImpl();
        while (!isSignedIn) {
            Customer cust = new Customer();
            log.info("\n\nWelcome back. Please enter username: ");
            log.info("Or type exit to return to main menu.");
            username = scan.nextLine();
            if (username.matches("Exit")) {
                log.info("Returning to Main Menu");
            } else {
                log.info("\nThank you, " + username + " . Enter your password");
                password = scan.nextLine();
                try {
                    bBank.getCustomerByUserName(username);
                    cust.getUsername();
                    cust.getPassword();
                    Exception ex1 = new BusinessException();
                    SQLException ex2 = new SQLException(ex1);
                    throw ex2;
                } catch (SQLException | BusinessException e) {
                    log.info(e.getMessage());
                }
                log.info("Signing in.");
                isSignedIn = true;
                this.customerMenu(scan);
            }
        }
    }

    public void signUpNewCustomer (Scanner scan) throws BusinessException {
        boolean isSignedUp = false;
        String username = null;
        String password = null;
        String firstname = null;
        String lastname = null;
        BBankImpl bBank=new BBankImpl();
        while (!isSignedUp) {
            log.info("\n\nNew Customer Sign up. Please create a username: ");
            username = scan.nextLine();
            if (username.matches("Exit")) {
                log.info("Returning to Main Menu!");
            } else {
                log.info("Create a password: ");
                password = scan.nextLine();
                log.info("Please enter your First Name: ");
                firstname = scan.nextLine();
                log.info("Please enter your Last Name: ");
                lastname = scan.nextLine();
                log.info("First Name: " + firstname + ", \nLast Name: " + lastname + ", \nUsername: " + username + " ,\nPassword: " + password + ". \nIs this correct? Y/N");
                String answer = scan.nextLine();
                if (answer.matches("[yY]")) {
                    try{
                        log.info("User Created!");
                        log.info("\nRedirecting to Customer Menu. New Customers must still apply for a new account.");
                        Customer customer = new Customer();
                        bBank.addCustomer(firstname,lastname,username,password);
                        customer.setUsername(username);
                        customer.setPassword(password);
                        customer.setFirstname(firstname);
                        customer.setLastname(lastname);

                    } catch(BusinessException e){
                        log.info(e);
                    }
                    isSignedUp = true;
                }

                log.info("Signing in.");

            }
        }
    }

    public void customerAccountMenu (Scanner scan) throws BusinessException {
        int custMenu = 0;
        do {
            try{
                log.info("\n\nCustomer Account Menu. Please select an option: ");
                log.info("1. Accounts");
                log.info("2. Open new accounts");
                log.info("3. Deposit or withdraw");
                log.info("4. Back");
                custMenu = Integer.parseInt(scan.nextLine());
            }catch (Exception e){
                log.info("Invalid Entry!");
                custMenu = 0;
            }
            switch (custMenu) {
                case 1: log.info("Connecting to database......");
                    break;
                case 2: this.signUpNewCustomer(scan);
                    break;
                case 3: log.info("Manipulating funds........");
                    break;
                default: log.info("Returning to Main Menu");
            }
        }while (custMenu != 4);
    }
}

