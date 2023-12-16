// MathEquationParserTest.java
package com.example.mathapp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MathEquationParserTest {
    @Test
    public void testParseEquation() {
        MathEquationParser parser = new MathEquationParser();

        // тести для методу parseEquation
        // ...

        assertTrue(parser.parseEquation("2*x+5=17"));
    }
}
