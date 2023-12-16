// DatabaseHandlerTest.java
package com.example.mathapp;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DatabaseHandlerTest {
    @Test
    public void testFindEquationsByRoot() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        //тести для методу findEquationsByRoot
        // ...

        assertNotNull(databaseHandler.findEquationsByRoot(2.0));
    }
}
