package com.example.mathapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathEquationParserTest {

    @Test
    public void testParseValidEquation() {
        MathEquationParser parser = new MathEquationParser();
        MathEquation equation = parser.parseEquation("2*x+5=17");
        assertNotNull(equation, "Parsed equation should not be null");
    }

    @Test
    public void testParseInvalidEquation() {
        MathEquationParser parser = new MathEquationParser();
        MathEquation equation = parser.parseEquation("2*x+5=17*");
        assertNull(equation, "Parsing invalid equation should return null");
    }

    // інші тести для розбору рівнянь
}
