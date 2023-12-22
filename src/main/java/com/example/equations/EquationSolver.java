package com.example.equations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;

public class EquationSolver {

    private EquationSolver() {

    }

    private static String convertEquation(String originalEquation) {
        String pattern = "([^=]+)=(.*)";
        Matcher matcher = Pattern.compile(pattern).matcher(originalEquation);

        if (matcher.find()) {
            String leftPart = matcher.group(1).trim();
            String rightPart = matcher.group(2).trim();

            return leftPart + "-1*(" + rightPart + ")";
        } else {
            throw new IllegalArgumentException(
                "Некоректне рівняння: " + originalEquation);
        }
    }

    public static double calculateEquationValue(String equation,
        double xValue) {
        License.iConfirmNonCommercialUse("Maryna Hlushak");
        Argument argument = new Argument("x = " + xValue);
        Expression expression =
            new Expression(convertEquation(equation), argument);
        return expression.calculate();
    }

}

/**
 * Клас EquationSolver містить методи для обчислення значення математичного
 * рівняння за заданим значенням x.
 * У класі використовується бібліотека mxparser для парсингу та обчислення
 * математичних виразів.
 * 
 * Метод convertEquation приймає оригінальне рівняння та конвертує його до
 * формату, зручного для обчислень.
 * Розділяє рівняння на ліву та праву частини та повертає вираз, в якому права
 * частина помножена на -1.
 * 
 * Метод calculateEquationValue обчислює значення рівняння за допомогою
 * бібліотеки mxparser.
 * Переводить оригінальне рівняння у внутрішній формат, вставляє значення x, та
 * обчислює результат.
 * 
 * Клас має приватний конструктор, так як не передбачено створення екземплярів
 * класу EquationSolver,
 * а методи обчислення реалізовані статичними для використання без створення
 * об'єктів.
 */
