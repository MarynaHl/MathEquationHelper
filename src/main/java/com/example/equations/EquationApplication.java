package com.example.equations;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.equations.database.DatabaseInitializer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EquationApplication extends Application {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.createTables();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseInitializer.class.getName()).log(Level.SEVERE, null, e);
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            EquationApplication.class.getResource("equation-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Equations helper :)");
        stage.setScene(scene);
        stage.show();
    }
}

/**
 * Клас EquationApplication є точкою входу для запуску графічного інтерфейсу
 * JavaFX додатку.
 * У методі main викликається статичний метод createTables класу
 * DatabaseInitializer для ініціалізації бази даних,
 * якщо таблиці ще не існують. В разі виникнення SQLException логується
 * інформація про помилку.
 * Після цього викликається метод launch, який запускає JavaFX додаток.
 * 
 * У перевизначеному методі start створюється об'єкт FXMLLoader для завантаження
 * графічного інтерфейсу з файлу
 * "equation-view.fxml". Завантажений інтерфейс установлюється як сцена для
 * вікна програми з заданими розмірами.
 * Націнюється заголовок вікна ("Equations helper :)") та виводиться на екран.
 */
