package com.bbank;

import com.bbank.dao.BBankDAO;
import com.bbank.dao.impl.BBankDAOImpl;
import com.bbank.exception.BusinessException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.bbank.model.Customer;
import com.bbank.services.BankServices;
import com.bbank.services.CustomerServices;
import com.bbank.services.EmployeeServices;
import org.apache.log4j.Logger;

public class MainBank extends BBankDAOImpl {

    static Logger log = Logger.getLogger(MainBank.class);
    public static void main(String[] args) throws BusinessException, SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        log.info("Welcome to BBank. How can we assist you?");
        int mMenu = 0;
        CustomerServices customerServices=new CustomerServices();
        EmployeeServices empServices = new EmployeeServices();
//        EmployeeServices employeeServices=new EmployeeServices();

        do {
            try {
                log.info("\n\nMain Menu. Please select an option: ");
                log.info("\n--------------------------------------");
                log.info("1. Accounts");
                log.info("2. Apply for new account");
                log.info("3. Employee Menu");
                log.info("4. Exit");
                mMenu = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                log.info("Invalid Entry!");
                mMenu = 0;
            }
            switch (mMenu) {
                case 1:
                    customerServices.customerAccountMenu(scan);
                    break;
                case 2:
                    customerServices.signUpNewCustomer(scan);
                    break;
                case 3:
                    boolean isSignedIn = true;
                    String username = "emp123";
                    String password = "emp123";
                    Customer customer = new Customer();
                    BBankDAOImpl bBankDAO = new BBankDAOImpl();
                    do {
                        log.info("Welcome. Please enter your Employee ID: ");
                        log.info("Or type exit to return to main menu.");
                        log.info("-------------------------------------");
                        username = scan.nextLine();
                        log.info("Please enter your password:");
                        log.info("---------------------------");
                        password = scan.nextLine();
                        if (username != "emp123" || password != "emp123") {
                            log.info("Invalid Entry. Please try again.");
                            int choice = 0;
                        } else {
                            int choice = 0;
                            do {

                                log.info("Employee Menu");
                                log.info("--------------------");
                                log.info("1)By Id");
                                log.info("2)By Name");
                                log.info("8)Get All Employees");
                                log.info("9)EXIT");
                                log.info("Enter your choice(1-9) : ");
                                choice = Integer.parseInt(scan.nextLine());
                                switch (choice) {
                                    case 1:
                                        log.info("Enter Employee Id to get Employee Details");
                                        try {
                                            int id = Integer.parseInt(scan.nextLine());
                                            bBankDAO.getCustomerByUserName(username);
                                            if (customer != null) {
                                                log.info("Employee with id " + id + " was found... See below for details");
                                                log.info(customer);
                                            }

                                        } catch (NumberFormatException e) {
                                            log.info("Id should be integer only");
                                        } catch (BusinessException e) {
                                            log.info(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
//                            log.info("Enter gender to get all employees of that gender category (M-Male,F-Female,O-Others) enter M or F or O");
//                            String gender=scan.nextLine();
//                            try {
//                                List<Employee> employeeList=employeeSearchService.getEmployeesByGender(gender);
//                                if(employeeList!=null && employeeList.size()>0){
//                                    log.info("We have total "+employeeList.size()+" no of employees in DB... Printing the details below for the gender "+gender);
//                                    for(Employee e:employeeList){
//                                        log.info(e);
//                                    }
//                                }
//                            } catch (BusinessException e) {
//                                log.info(e.getMessage());
//                            }
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        try {
                                            List<Customer> customerList = bBankDAO.getAllEmployees();
                                            if (customerList != null && customerList.size() > 0) {
                                                log.info("We have total " + customerList.size() + " no of employees in DB... Printing the details below");
                                                for (Customer c : customerList) {
                                                    log.info(c);
                                                }
                                            }
                                        } catch (BusinessException | SQLException | ClassNotFoundException e) {
                                            log.info(e.getMessage());
                                        }
                                        break;
                                    case 9:
                                        log.info("Thank you for using your bank :) ");
                                        break;
                                    default:
                                        log.info("Invalid Input! Please try again.");

                                }
                            } while (choice != 9);
                        }
                    } while(!isSignedIn);

                    break;
                default:
                    log.info("Thank you. Have a wonderful day.");
            }
        } while (mMenu != 4);
    }
}