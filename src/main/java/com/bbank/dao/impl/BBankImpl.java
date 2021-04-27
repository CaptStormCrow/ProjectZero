package com.bbank.dao.impl;

import com.bbank.MainBank;
import com.bbank.dao.BBankDAO;
import com.bbank.dbutil.PostgresSqlConnection;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.sql.*;
import org.apache.log4j.Logger;


public class BBankImpl implements BBankDAO {

    static Logger log = Logger.getLogger(MainBank.class.getName());

    public Customer getCustomerByFirstName(int id, String firstName, String lastName, String username, String password, int accountID) throws BusinessException {
        Customer customer=null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql="select c.first_name, c.last_name, c.accountID from public.customer c where c.first_name=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);

            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = new Customer();
                customer.setId(id);
                customer.setFirstname("firstName");
                customer.setLastname("lastName");
                customer.setUsername("username");
                customer.setPassword("password");
            }else{
                throw new BusinessException("No customer found with id: "+id);
            }
        }catch (SQLException | ClassNotFoundException e){
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customer;
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
