package com.bbank.dao.impl;

import com.bbank.MainBank;
import com.bbank.dao.BBankDAO;
import com.bbank.dao.dbutil.PostgresSqlConnection;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class BBankImpl{

    static Logger log = Logger.getLogger(BBankImpl.class.getName());

    public Customer getCustomerByFirstName(int id, String firstName) throws BusinessException {
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

}













//
//
//
//
//
//
//
//
//
//
//    public Customer createNewCustomer (int id, String firstName, String lastName, String password, String username, int accountid) throws BusinessException, SQLException {
//        log.info.println("Not implemented");
//        Customer customer = new Customer (id, username, firstName, lastName, password, accountid);
//        return customer;
//
//
//        PreparedStatement preparedStatement;
//        try (Connection connection = PostgresSqlConnection.getConnection) {
//            String sql = "INSERT INTO public.customer\n" +
//                    "(first_name, last_name, username, password, acctid)\n" +
//                    "VALUES(?, ?, ?, ?, ?);\n";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,customer.getFirstname());
//            preparedStatement.setString(1,customer.getLastname());
//            preparedStatement.setString(1,customer.getUsername());
//            preparedStatement.setString(1,customer.getPassword());
//            preparedStatement.setInt(5,customer.getAccountID());
//
//        }
//
//
//        int c=preparedStatement.executeUpdate();
//        if(c==1){
//            ResultSet resultSet=preparedStatement.getGeneratedKeys();
//            if(resultSet.next()){
//                customer.setId(resultSet.getInt(1));
//            }else {
//                throw new BusinessException("Failed to Register. Please Retry.");
//            }
//        }
//
//    }
//}
