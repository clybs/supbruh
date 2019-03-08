package com.clybs.supbruh;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Unit test for App
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({App.class})
public class AppTest {

    @Test
    public void shouldReturnCorrectDefinitions() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Whitebox.getMethod(App.class, "getDefinitions");
        Options options = (Options) method.invoke(null, null);

        assertTrue(options.hasOption("x"));
        assertTrue(options.hasOption("y"));
        assertFalse(options.hasOption("z"));
    }
}
