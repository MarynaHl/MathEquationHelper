package com.example.mathapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathEquation {
    private String equation;

    public MathEquation(String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public double[] getRoots() {
        String[] parts = equation.split("=");

        if (parts.length != 2) {
            return new double[0];
        }

        String left = parts[0].trim();
        String right = parts[1].trim();

        // Assume x is on the left side
        String expression = left;
        String sideWithX = "left";

        if (!left.contains("x")) {
            // If x is on the right side
            expression = right;
            sideWithX = "right";
        }

        // logic for solving the equation and finding roots

        return new double[0];
    }
}
