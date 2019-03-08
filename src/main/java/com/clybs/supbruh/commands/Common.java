package com.clybs.supbruh.commands;

public class Common extends Command {
    public Common(Load loadTask, Process processTask) {
        super(loadTask, processTask);
    }

    @Override
    public void save() {
        System.out.print("Common ");
        loadTask.execute();
        processTask.execute();
    }
}
