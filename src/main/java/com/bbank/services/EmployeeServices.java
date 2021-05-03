package com.bbank.services;


import com.bbank.dao.BBankDAO;
import com.bbank.dao.impl.BBankDAOImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.model.Employee;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServices {

    Scanner scan = new Scanner(System.in);
    static Logger log = Logger.getLogger(EmployeeServices.class);

        public void employeeMenu (Scanner scan){
            int empMenu = 0;
            while (empMenu != 3) {
                log.info("\n\nEmployee Menu. Please select an option: ");
                log.info("1. Accounts");
                log.info("2. Approve or deny new accounts");
                log.info("3. Deposit or withdraw");
                log.info("4. Exit");
                empMenu = Integer.parseInt(scan.nextLine());
                switch (empMenu) {
                    case 1:
//                    this.employeeAccountMenu(scan);
                        break;
                    case 2:
                        break;
                    case 3:
                        log.info("Returning to Main Menu");
                        break;
                    default:
                        log.info("Please enter a number between 1 and 3");
                }
            }
        }

//        public void employeeLoginVerification (Scanner scan){
//            boolean isSignedIn = false;
//            String password = null;
//            String username = null;
//            while (!isSignedIn) {
//                BBankDAOImpl bankDao = new BBankDAOImpl();
//                Employee employee = new Employee();
//                log.info("\n\nWelcome back. Please enter username: ");
//                log.info("Or type exit to return to main menu.");
//                username = scan.nextLine();
//                if (username.matches("Exit")) {
//                    log.info("Returning to Main Menu");
//                } else {
//                    log.info("\nThank you, " + username + " . Enter your password");
//                    password = scan.nextLine();
//                    try {
//                        Exception ex1 = new BusinessException();
//                        SQLException ex2 = new SQLException(ex1);
//                        throw ex2;
//                    } catch (SQLException e) {
//                        log.info(e.getMessage());
//                    }
//                    log.info("Signing in.");
//                    isSignedIn = true;
//                }
//            }
//        }
    }

