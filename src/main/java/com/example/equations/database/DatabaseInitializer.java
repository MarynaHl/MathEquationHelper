package com.example.equations.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private DatabaseInitializer() {

    }

    public static void createTables() throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();
                Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS equations ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "equation VARCHAR(255) NOT NULL UNIQUE ,"
                    + "roots VARCHAR(255) NOT NULL);";
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            throw new SQLException("Failed to create tables.");
        }
    }
}

/**
 * Клас DatabaseInitializer відповідає за ініціалізацію бази даних для
 * зберігання інформації про рівняння.
 * У цьому класі використовується шаблон "Singleton" (приватний конструктор та
 * публічний статичний метод),
 * щоб гарантувати, що екземпляр класу буде створений лише один раз.
 * 
 * Метод createTables викликається для створення таблиці "equations" у базі
 * даних, якщо така таблиця ще не існує.
 * Використовується автоматичне управління ресурсами (try-with-resources) для
 * забезпечення безпечного закриття
 * з'єднання та оператора Statement після виконання запиту.
 * 
 * Запит для створення таблиці містить колонки id (ідентифікатор), equation
 * (рівняння) та roots (корені рівняння).
 * Колонка id є первинним ключем та автоматично збільшується при додаванні
 * нового запису.
 * Колонки equation та roots призначені для зберігання рядків з відповідними
 * даними.
 * 
 * У випадку помилки створення таблиці, виникає SQLException, і викликаються
 * відповідні обробники винятків,
 * які викидають новий виняток з підходящим повідомленням про невдалу
 * ініціалізацію бази даних.
 */
