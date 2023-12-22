package com.example.equations;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationValidator {

    private EquationValidator() {

    }

    public static boolean isParenthesesValid(String equation) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char character : equation.toCharArray()) {
            if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isExpressionValid(String equation) {
        String pattern =
            "^(?=.*[0-9xX])(?!.*[-+*/()=]{2})(?!.*\\/\\s*0\\s*(?![0-9xX]))[-+*/()0-9xX=\\.\\s]+(?<=[0-9xX)])$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(equation);

        return matcher.matches();
    }

    public static boolean isRootValid(String root) {
        try {
            double value = Double.parseDouble(root.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

/**
 * Клас EquationValidator містить методи для перевірки валідності математичних
 * виразів та коренів.
 * 
 * Метод isParenthesesValid перевіряє правильність розташування дужок у
 * математичному виразі.
 * Використовує стек для зберігання відкритих дужок і перевіряє, чи кожна
 * закрита дужка має відповідну відкриту.
 * 
 * Метод isExpressionValid визначає валідність математичного виразу за допомогою
 * регулярного виразу.
 * Перевіряє, чи вираз містить правильні числа, оператори та інші символи, і
 * виключає недопустимі комбінації.
 * 
 * Метод isRootValid перевіряє, чи рядок може бути конвертований у валідне
 * числове значення (корінь).
 * 
 * Клас має приватний конструктор, оскільки не передбачено створення екземплярів
 * класу EquationValidator,
 * а методи перевірки реалізовані статичними для використання без створення
 * об'єктів.
 */
