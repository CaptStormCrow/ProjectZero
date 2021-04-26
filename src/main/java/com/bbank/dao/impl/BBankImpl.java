package com.bbank.dao.impl;

import com.bbank.dao.BBankDAO;
import com.bbank.dbutil.PostgresSqlConnection;
import com.bbank.exception.BusinessException;
import com.bbank.model.Customer;

import java.sql.*;

public class BBankImpl  implements BBankDAO {
    public Customer createNewCustomer (Long id,  String firstName, String lastName, String password, String username, int accountid) throws SQLExceptions, BusinessException, SQLException, ClassNotFoundException {
        log.info("Not implemented");
        Customer customer = new Customer (id, username, firstName, lastName, password, accountid);
        return customer;


        Connection connection = PostgresSqlConnection.getConnection();
        String sql="INSERT INTO public.customer\n" +
                "(first_name, last_name, username, password, acctid)\n" +
                "VALUES(?, ?, ?, ?, ?);\n";
        PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,customer.getFirstname());
        preparedStatement.setString(1,customer.getLastname());
        preparedStatement.setString(1,customer.getUsername());
        preparedStatement.setString(1,customer.getPassword());
        preparedStatement.setInt(5,customer.getAccountID());

        int c=preparedStatement.executeUpdate();
        if(c==1){
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                customer.setId(resultSet.getInt(1));
            }else {
                throw new BusinessException("Failed to Register. Please Retry.");
            }
        }

    }
}
