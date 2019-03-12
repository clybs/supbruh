package com.clybs.supbruh.tasks;

public class TaskGroups {

    /**
     * Create tasks based on an XML file
     *
     * @param filename The xml file to use
     */
    public TaskGroups(String filename) {
        Load load = new Load(filename);
        Process process = new Process();

        Task commonTasks = new CommonTasks(load, process);
        commonTasks.save();
    }
}
