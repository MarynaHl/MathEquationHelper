package com.example.equations;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Клас для тестування валідатора математичних рівнянь.
 */
class EquationValidatorTest {

    /**
     * Постачальник правильних виразів із дужками.
     */
    static Stream<String> validParenthesesProvider() {
        return Stream.of(
                "2*(x+5)",
                "(2*x+5)",
                "(2*5)+(x+5)",
                "2*(x+5)-5+(x+5)",
                "2*((x+5)-5)+(x+5)");
    }

    /**
     * Постачальник неправильних виразів із дужками.
     */
    static Stream<String> invalidParenthesesProvider() {
        return Stream.of(
                "2*(x+5",
                "(2*)x+5)",
                "2*(x+5))",
                "2*(((x+5))(x+2)",
                "(2*((x+5))",
                "2*(x+5))(x+2)");
    }

    /**
     * Постачальник правильних математичних виразів.
     */
    static Stream<String> validExpressionProvider() {
        return Stream.of(
                "2*x+5=10",
                "-1.3*5/x=1.2",
                "2*x=10",
                "2*x+5+x+5=10",
                "17=2*x+5");
    }

    /**
     * Постачальник неправильних математичних виразів.
     */
    static Stream<String> invalidExpressionProvider() {
        return Stream.of(
                "2*x+*5=10",
                "2*x+=",
                "2*x+5+x+5=10+",
                "17=2*x+5/0",
                "2*x+5++x=10",
                "x*3-(2+5)=",
                "2*x+5-(x=10)");
    }

    /**
     * Тест для перевірки правильності дужок у виразі.
     *
     * @param equation Математичний вираз
     */
    @ParameterizedTest
    @MethodSource("validParenthesesProvider")
    void testValidParentheses(String equation) {
        assertTrue(EquationValidator.isParenthesesValid(equation));
    }

    /**
     * Тест для перевірки неправильності дужок у виразі.
     *
     * @param equation Математичний вираз
     */
    @ParameterizedTest
    @MethodSource("invalidParenthesesProvider")
    void testInvalidParentheses(String equation) {
        assertFalse(EquationValidator.isParenthesesValid(equation));
    }

    /**
     * Тест для перевірки правильності математичного виразу.
     *
     * @param equation Математичний вираз
     */
    @ParameterizedTest
    @MethodSource("validExpressionProvider")
    void testValidExpression(String equation) {
        assertTrue(EquationValidator.isExpressionValid(equation));
    }

    /**
     * Тест для перевірки неправильності математичного виразу.
     *
     * @param equation Математичний вираз
     */
    @ParameterizedTest
    @MethodSource("invalidExpressionProvider")
    void testInvalidExpression(String equation) {
        assertFalse(EquationValidator.isExpressionValid(equation));
    }
}

/**
 * У цьому коді:
 * 
 * Клас EquationValidatorTest є класом для тестування функціоналу класу
 * EquationValidator,
 * який, ймовірно, містить методи для валідації математичних виразів.
 * 
 * Кожен метод validParenthesesProvider, invalidParenthesesProvider,
 * validExpressionProvider і invalidExpressionProvider є постачальником даних
 * для параметризованих тестів. Вони надають різні математичні вирази,
 * які повинні бути правильно або неправильно валідовані.
 * 
 * Кожен параметризований тест використовує анотації @ParameterizedTest
 * та @MethodSource
 * для вказівки постачальника даних і методу, який надає ці дані.
 * 
 * У тестах використовуються методи assertTrue та assertFalse для перевірки
 * правильності
 * або неправильності валідації математичних виразів.
 * 
 * Кожен тест викликає відповідні методи з класу EquationValidator для перевірки
 * валідності
 * дужок або математичного виразу.
 */
