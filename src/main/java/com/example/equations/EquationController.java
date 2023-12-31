package com.example.equations;

import java.sql.SQLException;
import java.util.List;

import com.example.equations.database.EquationDAO;
import com.example.equations.utils.AlertManager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EquationController {

    private static final double DELTA = 1e-9;
    @FXML
    private TextField equationTextField;
    @FXML
    private TextField rootsTextField;
    @FXML
    private TextField rootSearchTextField;
    @FXML
    private ListView<String> equationListView;

    @FXML
    public void onCheckButtonClick() {
        String equation = equationTextField.getText();
        String roots = rootsTextField.getText();

        if (!validateEquation(equation)) {
            return;
        }

        String[] rootsArray = roots.split(",");
        for (String root : rootsArray) {
            if (!validateRoot(root)) {
                return;
            }

            double rootValue = Double.parseDouble(root.trim());

            if (!isRootValidForEquation(equation, rootValue)) {
                return;
            }

            if (EquationDAO.equationExists(equation)) {
                AlertManager.showErrorAlert(
                    "Рівняння з таким виразом вже існує.");
                return;
            }

            try {
                EquationDAO.insertEquationAndRoots(equation, roots);
                AlertManager.showInfoAlert("Успіх",
                    "Вираз був успішно доданий.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    public void onSearchByRootButtonClick() {
        String rootText = rootSearchTextField.getText();

        if (!validateRoot(rootText)) {
            return;
        }

        double root = Double.parseDouble(rootText.trim());

        List<String> equations = EquationDAO.findEquationsByRoot(root, DELTA);

        equationListView.getItems().clear();
        equationListView.getItems().addAll(equations);
    }

    private boolean validateEquation(String equation) {
        if (!EquationValidator.isParenthesesValid(equation)) {
            AlertManager.showErrorAlert(
                "Некоректне розміщення дужок у рівнянні.");
            return false;
        }

        if (!EquationValidator.isExpressionValid(equation)) {
            AlertManager.showErrorAlert("Некоректний вираз у рівнянні.");
            return false;
        }

        return true;
    }

    private boolean validateRoot(String root) {
        if (!EquationValidator.isRootValid(root)) {
            AlertManager.showErrorAlert("Некоректний корінь у рівнянні.");
            return false;
        }

        return true;
    }

    private boolean isRootValidForEquation(String equation, double root) {
        if (Math.abs(EquationSolver.calculateEquationValue(equation, root))
            > DELTA) {
            AlertManager.showErrorAlert(
                "Число " + root + " не є коренем для цього рівняння.");
            return false;
        }
        return true;
    }
}

/**
 * Клас EquationController відповідає за обробку подій та взаємодію з графічним
 * інтерфейсом програми.
 * У класі визначено методи, які викликаються при натисканні на кнопки у
 * графічному інтерфейсі.
 * 
 * Метод onCheckButtonClick викликається при натисканні на кнопку перевірки та
 * додавання рівняння.
 * Перевіряється валідність рівняння, коренів та їхню придатність для рівняння.
 * Якщо рівняння існує в базі даних, виводиться повідомлення про помилку, інакше
 * рівняння додається до бази даних.
 * 
 * Метод onSearchByRootButtonClick викликається при натисканні на кнопку пошуку
 * рівнянь за коренем.
 * Валідує корінь та шукає рівняння в базі даних, що мають заданий корінь.
 * Знайдені рівняння виводяться у ListView на графічному інтерфейсі.
 * 
 * Методи validateEquation, validateRoot та isRootValidForEquation
 * використовуються для перевірки валідності
 * рівнянь, коренів та валідності кореня для конкретного рівняння відповідно.
 * 
 * При невдачі валідації виводяться повідомлення про помилку з допомогою класу
 * AlertManager.
 */
