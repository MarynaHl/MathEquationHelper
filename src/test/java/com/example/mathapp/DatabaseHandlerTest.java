package com.example.mathapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String JDBC_URL = "jdbc:mysql://your_database_url";
    private static final String JDBC_USER = "your_database_user";
    private static final String JDBC_PASSWORD = "your_database_password";

    public void saveEquation(MathEquation equation) {
        // реалізація для збереження рівняння в БД
    }

    public List<MathEquation> findEquationsByRoot(double root) {
        // реалізація для пошуку рівнянь за коренем в БД
        return new ArrayList<>();
    }

    public List<MathEquation> getAllEquations() {
        List<MathEquation> equations = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM equations")) {

            while (resultSet.next()) {
                String equationString = resultSet.getString("equation");
                MathEquation equation = new MathEquation(equationString);
                equations.add(equation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equations;
    }
}
