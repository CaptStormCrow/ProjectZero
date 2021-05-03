package com.bbank.dao.impl;

import com.bbank.dao.dbutil.PostgresSqlConnection;
import com.bbank.exception.BusinessException;
import com.bbank.model.Accounts;
import com.bbank.model.Customer;
import com.bbank.model.Employee;
import com.bbank.services.CustomerServices;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BBankDAOImpl {



    static Logger log = Logger.getLogger(BBankDAOImpl.class);

    public Customer getCustomerByName(String name) throws BusinessException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "select u.id,u.name,u.username,u.password, u.account, u.balance from bbank.users u where u.name=(?)";
            ResultSet resultSet;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                resultSet = preparedStatement.executeQuery();
            }
            if (resultSet.next()) {
                customer = new Customer();
                customer.setAccountID(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setAccount(resultSet.getString("account"));
                customer.setBalance(resultSet.getInt("balance"));
            } else {
                throw new BusinessException("No customer found with first name: " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customer;
    }

    public List<Customer> getCustomerByUserName(String username) throws BusinessException {
        Customer customer = null;
        CustomerServices customerServices = new CustomerServices();
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "select u.id,u.name,u.username,u.password, u.account, u.balance from bbank.users u where u.username=(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setAccountID(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setAccount(resultSet.getString("account"));
                customer.setBalance(resultSet.getInt("balance"));
            } else {
                throw new BusinessException("No customer found with username: " + username);
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }finally {

        }
        return customerList;
    }

    public List<Customer> addCustomer(String name, String username, String password, String account, int balance) throws BusinessException {
        Customer customer = null;
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "INSERT INTO bbank.customer\n" +
                    "(name, username, password, account, balance)\n" +
                    "VALUES(?, ?, ?, ?, ?);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, account);
            preparedStatement.setInt(5, balance);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setAccountID(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setAccount(resultSet.getString("account"));
                customer.setBalance(resultSet.getInt("balance"));
            } else {
                throw new BusinessException("No customer found with username: " + username);
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }

    public List<Customer> addAccount(String typeofaccount, Integer amount) throws BusinessException {
        Accounts accounts = null;
        List<Customer> accountList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "INSERT INTO bbank.accounts\n" +
                    "(typeofaccount, amount)\n" +
                    "VALUES(?, ?);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, typeofaccount);
            preparedStatement.setInt(2, amount);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setAccountID(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setAccount(resultSet.getString("account"));
                customer.setBalance(resultSet.getInt("balance"));
            } else {
                throw new BusinessException("No account found");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
        }
        return accountList;
    }

    public List<Customer> getEmployeeByEmpName(String empname) throws BusinessException {
        Employee employee = null;
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "select em.empname, em.username, em.password from bbank.employee em where em.empname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setAccountID(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setAccount(resultSet.getString("account"));
                customer.setBalance(resultSet.getInt("balance"));
            } else {
                throw new BusinessException("No Employee found with Name: " + empname);
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
            throw new BusinessException("Internal error occurred. Contact SystemAdmin.");
        }
        return customerList;
    }


    public List<Customer> getAllEmployees() throws BusinessException, SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "select u.id,u.name,u.username,u.password, u.account, u.balance from bbank.users u";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setName(resultSet.getString("name"));
                    customer.setUsername(resultSet.getString("username"));
                    customer.setAccount(resultSet.getString("account"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setBalance(resultSet.getInt("balance"));
                }
                if (customerList.size() == 0) {
                    throw new BusinessException("No employee exist in DB as of now");
                }
            } catch (SQLException e) {
//                log.info(e);
//                throw new BusinessException("Internal error occurred. Contact sysadmin");
            }
            return customerList;
        }
    }
}
