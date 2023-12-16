package com.example.mathapp;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private List<MathEquation> equations = new ArrayList<>();

    public void saveEquation(MathEquation equation) {
        equations.add(equation);
        System.out.println("Equation saved to the database: " + equation.getEquation());
    }

    public List<MathEquation> findEquationsByRoot(double root) {
        List<MathEquation> equationsWithRoot = new ArrayList<>();

        // logic for finding equations by root

        return equationsWithRoot;
    }
}
