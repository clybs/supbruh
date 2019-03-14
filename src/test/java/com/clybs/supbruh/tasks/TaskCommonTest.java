package com.clybs.supbruh.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskCommonTest {

    public static final String DEFAULT_FILENAME = "src/test/resources/xmls/test.xml";

    @Test
    public void save() {
        Load load = new Load(DEFAULT_FILENAME);
        Process process = new Process();
        TaskCommon taskCommon = new TaskCommon(load, process);
        assertNull(taskCommon.getTasks());

        taskCommon.save();

        assertNotNull(taskCommon.getTasks());
        assertTrue(taskCommon.getTasks().size() == 5);
    }

    @Test
    public void getTasks() {
        Load load = new Load(DEFAULT_FILENAME);
        Process process = new Process();
        TaskCommon taskCommon = new TaskCommon(load, process);
        taskCommon.save();

        assertNotNull(taskCommon.getTasks());
        assertTrue(taskCommon.getTasks().size() == 5);
    }
}