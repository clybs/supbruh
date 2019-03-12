package com.clybs.supbruh.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Load.class})
public class LoadTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void execute() throws ParserConfigurationException, IOException, SAXException {
        Load load = new Load(DEFAULT_FILENAME);
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);
        load.execute();

        assertTrue(load.getFilename() != Load.DEFAULT_FILENAME);
        assertTrue(load.getDocument().getClass() == document.getClass());
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
    public void setFilename() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Load load = new Load(null);

        assertTrue(load.getFilename() == "tasks.xml");

        Method method = Whitebox.getMethod(Load.class, "setFilename", String.class);
        method.invoke(load, "test.xml");

        assertNotNull(method);
        assertTrue(load.getFilename() == "test.xml");
    }
}