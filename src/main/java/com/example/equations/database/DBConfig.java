package com.example.equations.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConfig {

    private static final String PROPERTIES_FILE = "database.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = DBConfig.class.getClassLoader()
            .getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            Logger.getLogger(DBConfig.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private DBConfig() {

    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}

// /**
//  * Клас DBConfig відповідає за зчитування конфігураційних даних для бази даних з
//  * файла database.properties.
//  * 
//  * У класі використовується шаблон "Singleton" (приватний конструктор та
//  * статичний об'єкт),
//  * щоб гарантувати, що конфігураційні дані будуть зчитані лише один раз.
//  * 
//  * Зчитування конфігураційних даних відбувається в статичному блоку коду (static
//  * initializer),
//  * який викликається при завантаженні класу. Відкривається потік вводу з файлу
//  * database.properties,
//  * і конфігураційні дані завантажуються в об'єкт типу Properties.
//  * 
//  * Конструктор класу є приватним, що унеможливлює створення нових екземплярів
//  * класу.
//  * 
//  * Клас надає статичні методи getDbUrl, getDbUsername та getDbPassword, які
//  * повертають відповідні значення
//  * конфігураційних параметрів для підключення до бази даних.
//  * 
//  * В разі невдачі зчитування конфігураційних даних, відбувається запис в лог
//  * інформації про помилку.
//  */