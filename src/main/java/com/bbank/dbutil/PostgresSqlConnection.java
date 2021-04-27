package com.bbank.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {


    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";
        Connection connection;
        return connection = DriverManager.getConnection(url, username, password);
    }







//    {
//        try{
//        //Step 1 - Load Driver
//        Class.forName("org.postgresql.Driver");
//        log.info("Driver Loaded");
//
//        //Step2 - Open Connection
//        String url="jdbc:postgresql://localhost:5432/postgres";
//        String username="postgres";
//        String password="password";
//        connection= DriverManager.getConnection(url,username,password);
//        log.info("Connection/Ping Success");
//
//        //Step 3- Create Statement
//        String sql="INSERT INTO employee_schema.employee\n" +
//                "(\"name\", age, contact, city, gender, deptid)\n" +
//                "VALUES(?, ?, ?, ?, ?, ?);\n";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "ajay");
//        preparedStatement.setInt(2, 25);
//        preparedStatement.setLong(3, 9234567899L);
//        preparedStatement.setString(4, "Chennai");
//        preparedStatement.setString(5, "M");
//        preparedStatement.setInt(6, 9002);
//
//        //Step 4 - Execute Query
//        int c=preparedStatement.executeUpdate();
//
//        //Step 5- Process
//        log.info("Query executed - "+c+" no of row/s inserted successfullyyyy");
//
//    } catch (ClassNotFoundException | SQLException e) {
//        log.info(e);
//    } finally {
//        try {
//            //Step 6 - Close Connection
//            connection.close();
//            log.info("Connection closed");
//        } catch (SQLException e) {
//            log.info(e);
//        }
//    }
//}
//
//
//
//


//    private void PostgresSqlConnection() {
//    }
//

    }

