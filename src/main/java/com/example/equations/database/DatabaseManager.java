package com.example.equations.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private DatabaseManager() {
    }

    private static Connection connection;
    private static final String DB_URL = DBConfig.getDbUrl();
    private static final String DB_USER = DBConfig.getDbUsername();
    private static final String DB_PASSWORD = DBConfig.getDbPassword();

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

// /**
//  * Клас DatabaseManager відповідає за управління підключенням до бази даних.
//  * У класі використовується шаблон "Singleton" (приватний конструктор та
//  * приватний статичний об'єкт),
//  * щоб гарантувати, що підключення до бази даних буде відкрито лише один раз та
//  * буде використовуватися
//  * для всіх операцій взаємодії з базою даних.
//  * 
//  * Конструктор та методи визначені як приватні, що унеможливлює створення нових
//  * екземплярів класу
//  * і забезпечує доступ до підключення лише через статичні методи класу.
//  * 
//  * Клас містить статичні поля для URL бази даних, імені користувача та пароля,
//  * які отримуються з класу
//  * DBConfig, що, ймовірно, містить конфігураційні дані для бази даних.
//  * 
//  * Метод getConnection повертає з'єднання до бази даних. Якщо з'єднання ще не
//  * створено або закрито, воно
//  * створюється за допомогою DriverManager.getConnection з використанням
//  * параметрів DB_URL, DB_USER та DB_PASSWORD.
//  * 
//  * Метод closeConnection закриває з'єднання до бази даних, якщо воно відкрите.
//  * Викликається, наприклад, при завершенні роботи
//  * з базою даних для звільнення ресурсів.
//  */

