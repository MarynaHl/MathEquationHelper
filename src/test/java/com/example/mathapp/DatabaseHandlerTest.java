package com.example.mathapp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHandlerTest {
    @Test
    void saveEquation() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        MathEquation equation = new MathEquation("2*x+5=17");
        databaseHandler.saveEquation(equation);

        // Add assertions
    }

    @Test
    void findEquationsByRoot() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        MathEquation equation = new MathEquation("2*x+5=17");
        databaseHandler.saveEquation(equation);

        List<MathEquation> equationsWithRoot = databaseHandler.findEquationsByRoot(2.0);

        // Add assertions
}
