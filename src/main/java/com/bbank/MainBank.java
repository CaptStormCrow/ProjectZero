package com.bbank;

import com.bbank.dao.EmployeeDAO;
import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.model.Employee;


import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class MainBank implements EmployeeDAO {

    static Logger log = Logger.getLogger(MainBank.class.getName());


    public static void main(String[] args) {

    }

    public void mainMenu(Scanner scan) {
        int mMenu;
        do {
            try {
                System.out.println("\n\nMain Menu. Please select an option: ");
                System.out.println("1. Accounts");
                System.out.println("2. Apply for new account");
                System.out.println("3. Employee Menu");
                System.out.println("4. Exit");
                mMenu = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Entry!");
                mMenu = 0;
            }

            switch (mMenu) {
                case 1:
                    signInCustomer(scan);
                    break;
                case 2:
                    this.signUpNewCustomer(scan);
                    break;
                case 3:
                    this.employeeMenu(scan);
                    break;
                default:
                    System.out.println("Please enter a number between 1 and 3");
            }
        } while (mMenu != 4);
    }



    private void signInCustomer (Scanner scan){
        boolean isSignedIn = false;
        String password = null;
        String username = null;
        while (!isSignedIn) {
            BBankImpl bankDao = new BBankImpl();
            Customer customer = new Customer();
            System.out.println("\n\nWelcome back. Please enter username: ");
            System.out.println("Or type exit to return to main menu.");
            username = scan.nextLine();
            if (username.matches("Exit")){
                System.out.println("Returning to Main Menu");
            }else {
                System.out.println("\nThank you, "+username+ " . Enter your password");
                password = scan.nextLine();

                try{
                    customer = this.loginVerification(username, password);
                    Exception ex1 = new BusinessException() ;

                    SQLException ex2 = new SQLException(ex1);
                    throw ex2;
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }


                System.out.println("Signing in.");
                isSignedIn = true;
                this.customerMenu(scan);
            }
        }
    }

        public void customerMenu(Scanner scan){
            int startMenu = 0;
            while (startMenu !=3){
                System.out.println("\n\nCustomer Menu. Please select an option: ");
                System.out.println("1. Accounts");
                System.out.println("2. Apply for new account");
                System.out.println("3. Exit");

                startMenu = Integer.parseInt(scan.nextLine());

                switch (startMenu){
                    case 1 : this.customerAccountMenu(scan);
                        break;
                    case 2 :
                        break;
                    case 3 : System.out.println("Returning to Main Menu");
                        break;
                    default: System.out.println("Please enter a number between 1 and 3");
                }
            }
        }

        private void signUpNewCustomer(Scanner scan){
           boolean isSignedUp = false;
           String username=null;
           String password=null;
           String firstName=null;
           String lastName=null;
            while (isSignedUp){
                System.out.println("\n\nNew Customer Sign up. Please create a username: ");
                username = scan.nextLine();
                if (username.matches("Exit")){
                    System.out.println("Returning to Main Menu!");
                }else{
                    System.out.println("Create a password: ");
                    password = scan.nextLine();
                    System.out.println("Please enter your First Name: ");
                    firstName = scan.nextLine();
                    System.out.println("Please enter your Last Name: ");
                    lastName = scan.nextLine();

                    System.out.println("First Name: "+firstName+", \nLast Name: "+lastName+", \nUsername: " +username+" ,\nPassword: "+password+". \nIs this correct? Y/N");
                    String answer = scan.nextLine();
                    if(answer.matches("[yY]")){
                        System.out.println("User Created!");
                        System.out.println("\nRedirecting to Customer Menu. New Customers must still apply for a new account.");
                        Customer customer = new Customer();
                    }

                    System.out.println("Signing in.");
                    isSignedUp = true;
                }
            }
        }

        private void customerAccountMenu(Scanner scan){
            int custMenu = 0;
            while (custMenu !=3){
                System.out.println("\n\nEmployee Menu. Please select an option: ");
                System.out.println("1. Accounts");
                System.out.println("2. Open new accounts");
                System.out.println("3. Deposit or withdraw");
                System.out.println("4. Exit");

                custMenu = Integer.parseInt(scan.nextLine());

                switch (custMenu){
                    case 1 : this.customerAccountMenu(scan);
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                    case 4 : System.out.println("Returning to Main Menu");
                        break;
                    default: System.out.println("Please enter a number between 1 and 3");
                }
            }
        }





        private void employeeSignIn(Scanner scan){
            boolean isSignedIn = false;
            String password = null;
            String username = null;
            while (!isSignedIn) {
                BBankImpl bankDao = new BBankImpl();
                Employee employee = new Employee();
                System.out.println("\n\nWelcome back. Please enter username: ");
                System.out.println("Or type exit to return to main menu.");
                username = scan.nextLine();
                if (username.matches("Exit")){
                    System.out.println("Returning to Main Menu");
                }else {
                    System.out.println("\nThank you, "+username+" . Enter your password");
                    password = scan.nextLine();

                    try{
                        employee = this.employeeLoginVerification(username, password);
                        Exception ex1 = new BusinessException() ;

                        SQLException ex2 = new SQLException(ex1);
                        throw ex2;
                    } catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Signing in.");
                    isSignedIn = true;
                    this.employeeMenu(scan);
                }
            }
        }



        public void employeeMenu(Scanner scan){
            int empMenu = 0;
            while (empMenu !=3){
                System.out.println("\n\nEmployee Menu. Please select an option: ");
                System.out.println("1. Accounts");
                System.out.println("2. Approve or deny new accounts");
                System.out.println("3. Deposit or withdraw");
                System.out.println("4. Exit");

                empMenu = Integer.parseInt(scan.nextLine());

                switch (empMenu){
                    case 1 : this.employeeAccountMenu(scan);
                        break;
                    case 2 :
                        break;
                    case 3 : System.out.println("Returning to Main Menu");
                        break;
                    default: System.out.println("Please enter a number between 1 and 3");
                }
            }
        }

        public void employeeAccountMenu(Scanner scan){

        }


    @Override
    public Customer loginVerification(String username, String password) {
        return null;
    }

    @Override
    public Employee employeeLoginVerification(String username, String password) {
        return null;
    }
}
