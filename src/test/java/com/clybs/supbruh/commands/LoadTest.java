package com.clybs.supbruh.commands;

import org.apache.commons.cli.Options;
import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Load.class})
public class LoadTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void execute() {
        String filename = DEFAULT_FILENAME;
        Load load = new Load(filename);
        load.execute();

        assertTrue(load.getFilename() != Load.DEFAULT_FILENAME);
        assertTrue(load.getOptions().hasOption("a"));
        assertTrue(load.getOptions().hasLongOption("bbb"));
    }

    @Test
    public void getFilename() {
        String filename = "test.xml";
        Load loadNull = new Load(null);
        Load loadNotNull = new Load(filename);

        assertTrue(loadNull.getFilename() == Load.DEFAULT_FILENAME);
        assertTrue(loadNotNull.getFilename() == filename);
    }

    @Test
    public void getOptions() {
        String filename = DEFAULT_FILENAME;
        Load load = new Load(filename);
        Options options = new Options();
        load.execute();

        assertTrue(load.getOptions().getClass() == options.getClass());
    }

    @Test
    public void setFilename() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Load load = new Load(null);

        assertTrue(load.getFilename() == "commands.xml");

        Method method = Whitebox.getMethod(Load.class, "setFilename", String.class);
        method.invoke(load, "test.xml");

        assertNotNull(method);
        assertTrue(load.getFilename() == "test.xml");
    }
}