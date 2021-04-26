package com.bbank;

import com.bbank.dao.BBankDAO;
import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {

    }

    private void customerMenu(Scanner scan, Customer customer){
        int startMenu = 0;
        while (startMenu !=5)
    }




    private void signInCustomer (Scanner scan){
        boolean isSignedIn = false;
        String password = null;
        String username = null;
        while (isSignedIn == false) {
            BBankImpl bankDao = new BBankImpl();
            Customer customer = new Customer();
            log.info("\n\nWelcome back. Please enter username: ");
            log.info("Or type exit to return to main menu.");
            username = scan.nextLine();
            if (username.matches("Exit")){
                log.info("Returning to Main Menu");
            }else {
                log.info("\nThank you, "+username+ " . Enter your password");
                password = scan.nextLine();

                try{
                    customer = BBankDAO.findCustomerLogin(username, password);
                } catch(BusinessException | SQLException e){
                    log.info(e.getMessage());
                }

                log.trace("Signing in.");
                isSignedIn = true;
                this.customerMenu(scan, customer);
            }



        }
    }

    private void signUpNewCustomer(Scanner scan){
        int menuState = 0;
        while (menuState != 5){
            log.info("\n\nNew Customer Sign up. Please create a username: ");
            String username = scan.nextLine();
            if (username.matches("Exit")){
                log.info("Returning to Main Menu!");
            }else{
                log.info("Create a password: ");
                String password = scan.nextLine();
                log.info("Please enter your First Name: ");
                String firstName = scan.nextLine();
                log.info("Please enter your Last Name: ");
                String lastName = scan.nextLine();

                log.info("First Name: "+firstName+", \nLast Name: "+lastName+", \nUsername: " +username+" ,\nPassword: "+password+". \nIs this correct? Y/N");
                String answer = scan.nextLine();
                if(answer.matches("[yY]")){
                    log.info("User Created!");
                    log.info("\nRedirecting to Customer Menu. New Customers must still apply for a new account.");
                    Customer customer = new Customer(firstName, lastName, username, password);
                }
            }
        }
    }
}
