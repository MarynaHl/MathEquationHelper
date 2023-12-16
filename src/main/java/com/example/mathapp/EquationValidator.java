package com.example.mathapp;

public class EquationValidator {
    private final DatabaseHandler databaseHandler;

    public EquationValidator(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public boolean validateAndSaveEquation(MathEquation equation) {
        // Validation logic

        // Save equation to the database
        databaseHandler.saveEquation(equation);

        return true; // Change this based
    }
}