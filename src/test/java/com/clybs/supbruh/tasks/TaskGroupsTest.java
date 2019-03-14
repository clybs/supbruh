package com.clybs.supbruh.tasks;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TaskGroupsTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void getTodoList() {
        TaskGroups taskGroups = new TaskGroups(DEFAULT_FILENAME, "test", "test");
        ArrayList<NodeTask> nodeTasks = new ArrayList<>();

        assertTrue(taskGroups.getTodoList().getClass() == nodeTasks.getClass());
        assertTrue(taskGroups.getTodoList().size() == 0);

        TaskGroups taskGroups2 = new TaskGroups(DEFAULT_FILENAME, "name 1", "");
        assertTrue(taskGroups2.getTodoList().size() == 1);

        TaskGroups taskGroups3 = new TaskGroups(DEFAULT_FILENAME, null, "TaskCommon");
        assertTrue(taskGroups3.getTodoList().size() == 5);

        TaskGroups taskGroups4 = new TaskGroups(DEFAULT_FILENAME, "", "TaskCommon");
        assertTrue(taskGroups4.getTodoList().size() == 5);

        TaskGroups taskGroups5 = new TaskGroups(DEFAULT_FILENAME, "name 4", "TaskCommon");
        assertTrue(taskGroups5.getTodoList().size() == 2);

        TaskGroups taskGroups6 = new TaskGroups(DEFAULT_FILENAME, "name 1", null);
        assertTrue(taskGroups6.getTodoList().size() == 1);
    }
}