package com.exampledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlConnectionTest {
    public static void main(String[] args) {

        // ######################### creates three different Connection objects #########################

        Connection conn1 = null;

        // Connection conn2 = null;
        // Connection conn3 = null;

        try {
            // ######################### connect way #1 #########################

            String url1 = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "PASSWORD";
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

            // ######################### connect way #2 #########################

            // String url2 =
            // "jdbc:mysql://localhost:3306/testdb?user=root&password=PASSWORD";
            // conn2 = DriverManager.getConnection(url2);
            // if (conn2 != null) {
            // System.out.println("Connected to the database test2");
            // }

            // ######################### connect way #3 #########################

            // String url3 = "jdbc:mysql://localhost:3306/testdb";
            // Properties info = new Properties();
            // info.put("user", "root");
            // info.put("password", "PASSWORD");
            // conn3 = DriverManager.getConnection(url3, info);
            // if (conn3 != null) {
            // System.out.println("Connected to the database test3");
            // }

            String sql = "SELECT * FROM Employees";
            Statement statement = conn1.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {

                String name = result.getString("Name");
                int age = result.getInt("Age");
                String dept = result.getString("Dept");

                System.out.println(name + " " + age + " " + dept);
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

        // ######################### Insert employee into the employees database #########################

        try {
            String sql = "INSERT INTO Employees (idEmployees, name, age, dept) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn1.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, "Sahabdeep");
            statement.setInt(3, 27);
            statement.setString(4, "HR");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Nothig added");
        }

        // ######################### Update employee in the employees database #########################

        // try {

        // //     String sql = "UPDATE Employees SET name=?, age=?, dept=? WHERE idEmployees=2";

        // //     PreparedStatement statement = conn1.prepareStatement(sql);
        // //     statement.setString(1, "Armando");
        // //     statement.setInt(2, 63);
        // //     statement.setString(3, "Finance");

        // //     int rowsUpdated = statement.executeUpdate();
        // //     if (rowsUpdated > 0) {
        // //         System.out.println("An existing employee was updated successfully!");
        // //     }
        // // } catch (Exception e) {
        // //     System.out.println("Nothing Updated");
        // }

        // ######################### Delete #########################

        // try {

        //  String sql = "DELETE FROM Employees WHERE idEmployees=?";

        //  PreparedStatement statement = conn1.prepareStatement(sql);
        //  statement.setInt(1, 5);
         


        //  int del = statement.executeUpdate();

        // } catch (Exception e) {

        // System.out.println("??");
        //  }

        // ######################### Create #########################
        // Create
        // create database SampleDB;

        // use SampleDB;

        // CREATE TABLE `users` (
        // `user_id` int(11) NOT NULL AUTO_INCREMENT,
        // `username` varchar(45) NOT NULL,
        // `password` varchar(45) NOT NULL,
        // `fullname` varchar(45) NOT NULL,
        // `email` varchar(45) NOT NULL,
        // `age` int(3) NOT NULL,
        // `dept` varchar(45) NOT NULL,
        // PRIMARY KEY (`user_id`)
        // )
    }
}