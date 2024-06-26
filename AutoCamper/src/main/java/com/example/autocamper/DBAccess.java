package com.example.autocamper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.autocamper.RegisterBookingWallet.getConnection;

public class DBAccess
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void saveRentalToDatabase(String name, String email, String rvType, LocalDate startDate) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO rentals (name, email, rv_type, start_date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, rvType);
            statement.setDate(4, java.sql.Date.valueOf(startDate));
            statement.executeUpdate();
            System.out.println("Rental information saved to database.");
        } catch (SQLException e) {
            System.err.println("Error saving rental information: " + e.getMessage());
        }
    }

    // Method to retrieve a list of autocamper IDs based on the type ID
    public static List<Integer> getAutoCampersByType(int typeId) throws SQLException {
        List<Integer> autocamperIDs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT fldAutoCamperId FROM tblAutoCampers WHERE fldAutoCamperType = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, typeId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                autocamperIDs.add(resultSet.getInt("fldAutoCamperId"));
            }

        } catch (SQLException e) {
            System.out.println("Error getting campers by type: " + e.getMessage());
        }
        return autocamperIDs;
    }

}