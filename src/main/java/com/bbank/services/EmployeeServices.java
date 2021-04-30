package com.bbank.services;


import com.bbank.dao.BBankDAO;
import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;
import com.bbank.model.Employee;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServices {

    Scanner scan= new Scanner(System.in);
    static Logger log = Logger.getLogger(EmployeeServices.class);


    public void employeeSignIn() throws BusinessException {
        int ch = 0;
        boolean isSignedIn = false;
        String empName = "Emp123";
        String empPass = "Emp123";
        String username;
        String password = "null";
        BBankImpl bBank = new BBankImpl();
        while (!isSignedIn) {
            Employee emp = new Employee();
            log.info("Welcome. Please enter your Employee ID: ");
            log.info("Or type exit to return to main menu.");
            log.info("-------------------------------------");
            username = scan.nextLine();
            log.info("Please enter your password:");
            log.info("---------------------------");
            password = scan.nextLine();
            if (username == empName && password == empPass) {
                do {
                    System.out.println("Search Employee Menu");
                    System.out.println("--------------------");
                    System.out.println("1)By Id");
                    System.out.println("2)By Name");
                    System.out.println("3)By Age");
                    System.out.println("4)By City");
                    System.out.println("5)By Gender");
                    System.out.println("6)By Department Name");
                    System.out.println("7)By Contact Number");
                    System.out.println("8)Get All Employees");
                    System.out.println("9)EXIT");
                    System.out.println("Enter your choice(1-9) : ");
                    try {
                        ch = Integer.parseInt(scan.nextLine());
                    }catch (NumberFormatException e){}
                    switch (ch){
                        case 1:
                            System.out.println("Enter Employee Id to get Employee Details");
                            try {
                                int id = Integer.parseInt(scan.nextLine());
                                Employee employee=employeeSearchService.getEmployeeById(id);
                                if(employee!=null){
                                    System.out.println("Employee with id "+id+" was found... See below for details");
                                    System.out.println(employee);
                                }

                            }catch (NumberFormatException e){
                                System.out.println("Id should be integer only");
                            } catch (BusinessException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("Enter gender to get all employees of that gender category (M-Male,F-Female,O-Others) enter M or F or O");
                            String gender=scan.nextLine();
                            try {
                                List<Employee> employeeList=employeeSearchService.getEmployeesByGender(gender);
                                if(employeeList!=null && employeeList.size()>0){
                                    System.out.println("We have total "+employeeList.size()+" no of employees in DB... Printing the details below for the gender "+gender);
                                    for(Employee e:employeeList){
                                        System.out.println(e);
                                    }
                                }
                            } catch (BusinessException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            try {
                                List<Employee> employeeList=employeeSearchService.getAllEmployees();
                                if(employeeList!=null && employeeList.size()>0){
                                    System.out.println("We have total "+employeeList.size()+" no of employees in DB... Printing the details below");
                                    for(Employee e:employeeList){
                                        System.out.println(e);
                                    }
                                }
                            } catch (BusinessException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 9:
                            System.out.println("Thank you for using your bank :) ");
                            break;
                        default:
                            System.out.println("Invalid Input! Please try again.");

                    }
                }while (ch!=9);
            } else {
                log.info("Invalid Entry. Please try again.");
                ch = 0;
            }
        }
    }

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

    public void employeeLoginVerification(Scanner scan){
        boolean isSignedIn = false;
        String password = null;
        String username = null;
        while (!isSignedIn) {
            BBankImpl bankDao = new BBankImpl();
            Employee employee = new Employee();
            log.info("\n\nWelcome back. Please enter username: ");
            log.info("Or type exit to return to main menu.");
            username = scan.nextLine();
            if (username.matches("Exit")) {
                log.info("Returning to Main Menu");
            } else {
                log.info("\nThank you, " + username + " . Enter your password");
                password = scan.nextLine();
                try {
                    Exception ex1 = new BusinessException();
                    SQLException ex2 = new SQLException(ex1);
                    throw ex2;
                } catch (SQLException e) {
                    log.info(e.getMessage());
                }
                log.info("Signing in.");
                isSignedIn = true;
                this.employeeMenu(scan);
            }
        }
    }
}
