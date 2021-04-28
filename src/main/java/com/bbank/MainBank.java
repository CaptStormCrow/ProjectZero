package com.bbank;

import com.bbank.dao.impl.BBankImpl;
import com.bbank.exception.BusinessException;
import java.util.Scanner;
import com.bbank.services.CustomerServices;
import com.bbank.services.EmployeeServices;
import org.apache.log4j.Logger;

public class MainBank extends BBankImpl {

    static Logger log = Logger.getLogger(MainBank.class);
    public static void main(String[] args) throws BusinessException {
        Scanner scan = new Scanner(System.in);
        log.info("Welcome to BBank. How can we assist you?");
        int mMenu = 0;
        CustomerServices customerServices = new CustomerServices();
        EmployeeServices employeeServices = new EmployeeServices();
        do {
            try {
                log.info("\n\nMain Menu. Please select an option: ");
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
                    customerServices.signInCustomer();
                    break;
                case 2:
                    customerServices.signUpNewCustomer(scan);
                    break;
                case 3:
                    employeeServices.employeeSignIn(scan);
                    break;
                default:
                    log.info("Thank you. Have a wonderful day.");
            }
        } while (mMenu != 4);
    }
}