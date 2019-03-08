package com.clybs.supbruh.commands;

abstract class Command {
    protected Load loadTask;
    protected Process processTask;

    protected Command(Load loadTask, Process processTask) {
        this.loadTask = loadTask;
        this.processTask = processTask;
    }

    abstract public void save();
}
