package com.clybs.supbruh.commands;

public class Common extends Command {
    /**
     * Common are commands that are common
     *
     * @param loadTask    The {@link Load} object
     * @param processTask The {@link Process} object
     */
    public Common(Load loadTask, Process processTask) {
        super(loadTask, processTask);
    }

    @Override
    /**
     * save will save the commands for future calling
     */
    public void save() {
        loadTask.execute();
        processTask.execute();
    }
}
