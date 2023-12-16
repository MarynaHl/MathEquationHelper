package com.example.mathapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    private Connection connection;

    public DatabaseHandler() {
        // Ініціалізація з'єднання з базою даних
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "admin", "secret");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // потрібно ще додати методи для взаємодії з базою даних
}
