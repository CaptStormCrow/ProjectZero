package com.bbank;

import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.model.Employee;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class MainBank {

    static Logger log = Logger.getLogger(MainBank.class.getName());


    public static void main(String[] args) {

    }
        public void mainMenu(Scanner scan) {
            int mMenu = 0;
            do {
                try {
                    log.info("\n\nMain Menu. Please select an option: ");
                    log.info("1. Accounts");
                    log.info("2. Apply for new account");
                    log.info("3. Employee Menu");
                    log.info("4. Exit");
                    int selection = Integer.parseInt(scan.nextLine());
                    mMenu = selection;
                } catch (Exception e){
                    log.info("Invalid Entry!");
                    mMenu =0;
                }

                switch (mMenu){
                    case 1: signInCustomer(scan);
                        break;
                    case 2: this.signUpNewCustomer(scan);
                        break;
                    case 3: this.employeeMenu(scan);
                        break;
                    default: log.info("Please enter a number between 1 and 3");
                }
            }while(mMenu != 4);
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
                       customer = this.loginVerification(username, password);
                    } catch(BusinessException | SQLException e){
                        log.info(e.getMessage());
                    }


                    log.info("Signing in.");
                    isSignedIn = true;
                    this.customerMenu(scan, customer);
                }
            }
        }

        public void customerMenu(Scanner scan, Customer customer){
            int startMenu = 0;
            while (startMenu !=3){
                log.info("\n\nCustomer Menu. Please select an option: ");
                log.info("1. Accounts");
                log.info("2. Apply for new account");
                log.info("3. Exit");

                startMenu = Integer.parseInt(scan.nextLine());

                switch (startMenu){
                    case 1 : this.customerAccountMenu(scan);
                        break;
                    case 2 :
                        break;
                    case 3 : log.info("Returning to Main Menu");
                        break;
                    default: log.info("Please enter a number between 1 and 3");
                }
            }
        }

        private void signUpNewCustomer(Scanner scan){
            int menuState = 0;
            while (menuState != 3){
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
                        Customer customer = new Customer();
                    }
                }
            }
        }

        private void customerAccountMenu(Scanner scan){

        }





        private void employeeSignIn(Scanner scan){
            boolean isSignedIn = false;
            String password = null;
            String username = null;
            while (isSignedIn == false) {
                BBankImpl bankDao = new BBankImpl();
                Employee employee = new Employee();
                log.info("\n\nWelcome back. Please enter username: ");
                log.info("Or type exit to return to main menu.");
                username = scan.nextLine();
                if (username.matches("Exit")){
                    log.info("Returning to Main Menu");
                }else {
                    log.info("\nThank you, "+username+" . Enter your password");
                    password = scan.nextLine();

                    try{
                        employee = this.loginVerification(Employee);
                    } catch(BusinessException | SQLException e){
                        log.info(e.getMessage());
                    }

                    log.info("Signing in.");
                    isSignedIn = true;
                    this.employeeMenu(scan);
                }
            }
        }

    public void loginVerification(String username, String password){
        
        }

        public void employeeMenu(Scanner scan){
            int empMenu = 0;
            while (empMenu !=3){
                log.info("\n\nEmployee Menu. Please select an option: ");
                log.info("1. Accounts");
                log.info("2. Approve or deny new accounts");
                log.info("3. Deposit or withdraw");
                log.info("4. Exit");

                empMenu = Integer.parseInt(scan.nextLine());

                switch (empMenu){
                    case 1 : this.employeeAccountMenu(scan);
                        break;
                    case 2 :
                        break;
                    case 3 : log.info("Returning to Main Menu");
                        break;
                    default: log.info("Please enter a number between 1 and 3");
                }
            }
        }
        
        public void employeeAccountMenu(Scanner scan){
        
        }


}
