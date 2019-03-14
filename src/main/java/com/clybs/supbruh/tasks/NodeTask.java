package com.clybs.supbruh.tasks;

public class NodeTask {
    private String description;
    private String name;
    private String taskGroupName;

    public NodeTask(String name, String description, String taskGroupName) {
        this.name = name;
        this.description = description;
        this.taskGroupName = taskGroupName;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getTaskGroupName() {
        return taskGroupName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskGroupName(String taskGroupName) {
        this.taskGroupName = taskGroupName;
    }

    @Override
    public String toString() {
        return "NodeTask{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", taskGroupName='" + taskGroupName + '\'' +
                '}';
    }
}
