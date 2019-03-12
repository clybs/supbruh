package com.clybs.supbruh.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Process.class})
public class ProcessTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void getDocument() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process();
        process.setDocument(document);

        assertTrue(process.getDocument().getClass() == document.getClass());
    }

    @Test
    public void getNodeTasks() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process();
        process.setDocument(document);
    }

    @Test
    public void parse() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process();
        process.setDocument(document);

        Method method = Whitebox.getMethod(Process.class, "parse");
        method.invoke(process, null);

        assertTrue(process.getNodeTasks().size() == 5);
    }

    @Test
    public void setDocument() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process();
        process.setDocument(document);

        assertTrue(process.getDocument().getClass() == document.getClass());
    }
}