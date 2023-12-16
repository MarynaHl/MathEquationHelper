package com.example.mathapp;

import java.util.List;

public class MathApp {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        EquationValidator equationValidator = new EquationValidator(databaseHandler);

        // Create and validate an equation
        MathEquation mathEquation = new MathEquation("2*x+5=17");
        if (equationValidator.validateAndSaveEquation(mathEquation)) {
            System.out.println("Equation is valid and saved.");
        } else {
            System.out.println("Equation is not valid.");
        }

        // Search for equations by root
        List<MathEquation> equationsWithRoot = databaseHandler.findEquationsByRoot(2.0);
        System.out.println("Equations with root 2.0: " + equationsWithRoot);
    }
}
