package com.clybs.supbruh.commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoadTest {

    @Test
    public void execute() {
        String filename = "src/test/java/com/clybs/supbruh/commands/test.xml";
        Load load = new Load(filename);

        load.execute();
        assertTrue(load.getFilename() != Load.DEFAULT_FILENAME);
    }

    @Test
    public void getFilename() {
        String filename = "test.xml";
        Load loadNull = new Load(null);
        Load loadNotNull = new Load(filename);

        assertTrue(loadNull.getFilename() == Load.DEFAULT_FILENAME);
        assertTrue(loadNotNull.getFilename() == filename);
    }
}