package com.clybs.supbruh.tasks;

import java.util.ArrayList;

public class TaskCommon extends Task {

    /**
     * TaskCommon are tasks that are common
     *
     * @param loadTask    The {@link Load} object
     * @param processTask The {@link Process} object
     */
    public TaskCommon(Load loadTask, Process processTask) {
        super(loadTask, processTask);
    }

    @Override
    /**
     * save will save the tasks for future calling
     */
    public void save() {
        // Execute loading
        loadTask.execute();

        // Set properties
        processTask.setDocument(loadTask.getDocument());
        processTask.setTaskGroupName(this.getClass().getSimpleName());

        // Execute processing
        processTask.execute();
    }

    @Override
    /**
     * getTasks will return tasks list
     */
    public ArrayList<NodeTask> getTasks() {
        return processTask.getNodeTasks();
    }
}
