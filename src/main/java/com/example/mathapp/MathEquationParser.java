package com.example.mathapp;

public class MathEquationParser {
    public MathEquation parseEquation(String equationString) {
        // Логіка розбору рядка рівняння і створення об'єкта MathEquation
        return new MathEquation(equationString);
    }
}
