package com.clybs.supbruh.tasks;

public class CommonTasks extends Task {
    /**
     * CommonTasks are tasks that are common
     *
     * @param loadTask    The {@link Load} object
     * @param processTask The {@link Process} object
     */
    public CommonTasks(Load loadTask, Process processTask) {
        super(loadTask, processTask);
    }

    @Override
    /**
     * save will save the tasks for future calling
     */
    public void save() {
        loadTask.execute();
        processTask.setDocument(loadTask.getDocument());
        processTask.execute();
    }
}
