package com.example.mathapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseHandlerTest {

    @Test
    public void testDatabaseConnection() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        assertNotNull(databaseHandler.getConnection(), "Connection should not be null");
    }

    // додати інші тести
}
