package com.clybs.supbruh.commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoadTest {

    @Test
    public void execute() {
    }

    @Test
    public void getFilename() {
        String filename = "burn.xml";
        Load loadNull = new Load(null);
        Load loadNotNull = new Load(filename);

        assertTrue(loadNull.getFilename() == Load.DEFAULT_FILENAME);
        assertTrue(loadNotNull.getFilename() == filename);
    }
}