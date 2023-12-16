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

        List<MathEquation> savedEquations = databaseHandler.getAllEquations();
        assertEquals(1, savedEquations.size());
        assertEquals(equation, savedEquations.get(0));
    }

    @Test
    void findEquationsByRoot() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        MathEquation equation = new MathEquation("2*x+5=17");
        databaseHandler.saveEquation(equation);

        List<MathEquation> equationsWithRoot = databaseHandler.findEquationsByRoot(2.0);

        assertEquals(1, equationsWithRoot.size());
        assertEquals(equation, equationsWithRoot.get(0));
    }
}
