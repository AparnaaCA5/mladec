package com.bookingApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.bookingApp.DBConnection;
public class TravelDAO {
    public void addTravel(String destination, Date travelDate, double price) {
        String sql =
            "INSERT INTO travel(destination, travel_date, price) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, destination);
            ps.setDate(2, travelDate);
            ps.setDouble(3, price);
            ps.executeUpdate();
            System.out.println("Travel added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}