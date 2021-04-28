package com.bbank.dao.impl;

import com.bbank.dao.dbutil.PostgresSqlConnection;
import com.bbank.exception.BusinessException;
import com.bbank.model.Accounts;
import com.bbank.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bbank.model.Employee;
import com.bbank.services.CustomerServices;
import org.apache.log4j.Logger;

public class BBankImpl{

    static Logger log = Logger.getLogger(BBankImpl.class.getName());

    public Customer getCustomerByFirstName(String firstName) throws BusinessException {
        Customer customer=null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="select c.id, c.firstname, c.lastname, c.accountID from bbank.customer c where c.firstname=?";
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, firstName);
                resultSet = preparedStatement.executeQuery();
            }
            if(resultSet.next()){
                customer = new Customer();
                customer.setFirstname("firstName");
                customer.setLastname("lastName");
                customer.setUsername("username");
                customer.setPassword("password");
            }else{
                throw new BusinessException("No customer found with first name: "+firstName);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customer;
    }

    public List<Customer> getCustomerByLastName(int id, String firstName, String lastName, String username, String password, int accountID) throws BusinessException {
        List<Customer> customerList=new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="select c.firstname, c.lastname, c.accountID from bbank.customer c where c.lastname=?";
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, lastName);
                resultSet = preparedStatement.executeQuery();
            }
            if(resultSet.next()){
                Customer customer = new Customer();
                customer.setFirstname("firstName");
                customer.setLastname("lastName");
                customer.setUsername("username");
                customer.setPassword("password");
            }else{
                throw new BusinessException("No customer found with last name: "+lastName);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }

    public List<Customer> getCustomerByUserName(String username) throws BusinessException {
        Customer customer=null;
        CustomerServices customerServices=new CustomerServices();
        List<Customer> customerList=new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="select c.firstname, c.lastname, c.accountID from bbank.customer c where c.username=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = new Customer();
                customer.setFirstname("firstName");
                customer.setLastname("lastName");
                customer.setUsername("username");
                customer.setPassword("password");
            }else{
                throw new BusinessException("No customer found with username: "+username);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }

    public List<Customer> addCustomer(String firstname, String lastname, String username, String password) throws BusinessException {
        Customer customer=null;
        List<Customer> customerList=new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="INSERT INTO bbank.customer\n" +
                "(firstname, lastname, username, password)\n" +
                "VALUES(?, ?, ?, ?);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = new Customer();
                customer.setFirstname("firstName");
                customer.setLastname("lastName");
                customer.setUsername("username");
                customer.setPassword("password");
            }else{
                throw new BusinessException("No customer found with username: "+username);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }

    public List<Customer> addAccount(String typeofaccount, Integer amount) throws BusinessException {
        Accounts accounts= null;
        List<Customer> accountList=new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="INSERT INTO bbank.accounts\n" +
                    "(typeofaccount, amount)\n" +
                    "VALUES(?, ?);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, typeofaccount);
            preparedStatement.setInt(2, amount);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                accounts = new Accounts();
                accounts.setTypeOfAccount("typeofaccount");
                accounts.setAmount(amount);
            }else{
                throw new BusinessException("No account found");
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
        }
        return accountList;
    }

    public List<Customer> getEmployeeByEmpName(String empname) throws BusinessException {
        Employee employee=null;
        List<Customer> customerList=new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="select em.empname, em.username, em.password from bbank.employee em where em.empname=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, empname);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                employee = new Employee();
                employee.setEmpname("empname");
            }else{
                throw new BusinessException("No Employee found with Name: "+empname);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }
}