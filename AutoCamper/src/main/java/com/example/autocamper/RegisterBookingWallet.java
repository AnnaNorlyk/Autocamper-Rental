
package com.example.autocamper;

import java.sql.*;



public class RegisterBookingWallet {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234";
    private static Connection connection;

    // Method to establish a connection to the SQL Server database
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Load the JDBC driver class
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: SQL Server JDBC Driver not found.");
            e.printStackTrace();
        }
        return connection;
    }









    public static void rentRV(String name, String address, String email, int autocamperType, Date startDate, Date endDate, boolean basicInsurance, boolean superCoverPlus) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // establish database connection
            connection = getConnection();

            // insert customer information
            String insertCustomerQuery = "INSERT INTO tblCustomer (fldCustomerName, fldCustomerAddress, fldCustomerEmail) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(insertCustomerQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.executeUpdate();

            // get the generated customer ID
            int customerId;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customerId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }

            // Insert autocamper information
            String insertAutoCamperQuery = "INSERT INTO tblAutoCamper (fldAutoCamperType) VALUES (?)";
            statement = connection.prepareStatement(insertAutoCamperQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, autocamperType);
            statement.executeUpdate();

            // Get the generated autocamper ID
            int autoCamperId;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    autoCamperId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating autocamper failed, no ID obtained.");
                }
            }

            // Insert rental information
            String insertRentalQuery = "INSERT INTO tblRental (fldCustomerId, fldAutoCamperId, fldStartDate, fldEndDate) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(insertRentalQuery);
            statement.setInt(1, customerId);
            statement.setInt(2, autoCamperId);
            statement.setDate(3, new java.sql.Date(startDate.getTime())); // Convert java.util.Date to java.sql.Date
            statement.setDate(4, new java.sql.Date(endDate.getTime()));   // Convert java.util.Date to java.sql.Date
            statement.executeUpdate();

            // commit the transaction
            connection.commit();

        } catch (SQLException e) {
            // handle any database errors
            e.printStackTrace();
        } finally {
            // close resources
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}





