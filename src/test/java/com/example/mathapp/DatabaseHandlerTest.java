// DatabaseHandlerTest.java

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

    @Test
    void getAllEquations() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        // Assume that getAllEquations() returns a list of MathEquation objects
        List<MathEquation> allEquations = databaseHandler.getAllEquations();

        // Add assertions or checks on the returned list
        assertNotNull(allEquations);
        // Add more assertions as needed
    }
}
