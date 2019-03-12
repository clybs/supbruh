package com.clybs.supbruh.commands;

import org.apache.commons.cli.Options;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ProcessTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void execute() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process(document);
        process.execute();

        assertTrue(process.getOptions().hasOption("a"));
        assertTrue(process.getOptions().hasLongOption("bbb"));
    }

    @Test
    public void getOptions() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(DEFAULT_FILENAME);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        Process process = new Process(document);
        Options options = new Options();

        assertTrue(process.getOptions().getClass() == options.getClass());
    }
}