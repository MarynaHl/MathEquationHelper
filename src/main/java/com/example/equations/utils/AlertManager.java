package com.example.equations.utils;

import javafx.scene.control.Alert;

public class AlertManager {
    private AlertManager() {

    }

    public static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Помилка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showInfoAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

/**
 * Клас AlertManager надає методи для виведення сповіщень (Alert) в графічному
 * інтерфейсі JavaFX.
 * У класі визначено два статичних методи showErrorAlert та showInfoAlert для
 * відображення повідомлень про помилки
 * та інформаційні повідомлення відповідно.
 * 
 * Метод showErrorAlert створює Alert типу ERROR з вказаним текстом помилки та
 * виводить його для користувача.
 * 
 * Метод showInfoAlert призначений для відображення Alert типу INFORMATION з
 * вказаним заголовком та текстом повідомлення.
 * 
 * Клас використовує JavaFX Alert для виведення сповіщень і забезпечує
 * уніфікований спосіб взаємодії з користувачем
 * для відображення повідомлень у вікнах програми.
 */
