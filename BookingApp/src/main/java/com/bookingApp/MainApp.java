package com.bookingApp;

import java.sql.Date;

public class MainApp {
    public static void main(String[] args) {
 
        UserDAO userDao = new UserDAO();
        userDao.addUser("Kiki", "kiki@gmail.com", "9876543210");
 
        TravelDAO travelDao = new TravelDAO();
        travelDao.addTravel("Paris", Date.valueOf("2025-12-20"), 75000);
    }
}