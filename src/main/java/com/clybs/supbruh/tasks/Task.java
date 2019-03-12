package com.clybs.supbruh.tasks;

abstract class Task {
    protected Load loadTask;
    protected Process processTask;

    protected Task(Load loadTask, Process processTask) {
        this.loadTask = loadTask;
        this.processTask = processTask;
    }

    abstract public void save();
}
