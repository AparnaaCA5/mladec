package com.bookingApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
public class UserDAO {
    public void addUser(String name, String email, String phone) {
        String sql = "INSERT INTO user(name, email, phone) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.executeUpdate();
            System.out.println("User added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUsers() {
        String sql = "SELECT * FROM user";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(
                    rs.getInt("user_id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUserEmail(int userId, String email) {
        String sql = "UPDATE user SET email=? WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setInt(2, userId);
            ps.executeUpdate();
            System.out.println("User updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            System.out.println("User deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}