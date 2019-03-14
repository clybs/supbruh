package com.clybs.supbruh.tasks;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskGroups {
    private String taskName;
    private String taskGroupName;
    private ArrayList<NodeTask> todoList;

    /**
     * Create tasks based on an XML file
     *
     * @param filename The xml file to use
     * @param taskName The taskName to use
     */
    public TaskGroups(String filename, String taskName, String taskGroupName) {
        Load load = new Load(filename);
        Process process = new Process();
        todoList = new ArrayList<>();

        // Set the properties
        this.taskName = taskName;
        this.taskGroupName = taskGroupName;

        Task commonTasks = new TaskCommon(load, process);
        commonTasks.save();

        // Add all common tasks to the main tasks
        todoList.addAll(commonTasks.getTasks());
    }

    /**
     * todoList will return filtered/unfiltered results
     *
     * @return NodeTask
     */
    public ArrayList<NodeTask> getTodoList() {
        // Get the properties availability
        boolean taskNameAvailable = taskName != null && !taskName.isEmpty();
        boolean taskGroupNameAvailable = taskGroupName != null && !taskGroupName.isEmpty();
        boolean taskNameAvailableOnly = taskNameAvailable && !taskGroupNameAvailable;
        boolean taskGroupNameAvailableOnly = !taskNameAvailable && taskGroupNameAvailable;
        boolean bothTaskNameAndGroupAvailable = taskNameAvailable && taskGroupNameAvailable;

        System.out.println("Applying filters to tasks: taskName = " + taskName + " taskGroupName = " + taskGroupName);

        // Check if both taskName and taskGroupName are available
        if (bothTaskNameAndGroupAvailable) {
            return todoList.stream()
                    .filter(n -> n.getName().equals(taskName) && n.getTaskGroupName().equals(taskGroupName))
                    .sequential()
                    .map(n -> new NodeTask(
                                    n.getName(),
                                    n.getDescription(),
                                    n.getTaskGroupName()
                            )
                    )
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        // Check if only taskName is available
        if (taskNameAvailableOnly) {
            return todoList.stream()
                    .filter(n -> n.getName().equals(taskName))
                    .sequential()
                    .map(n -> new NodeTask(
                                    n.getName(),
                                    n.getDescription(),
                                    n.getTaskGroupName()
                            )
                    )
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        // Check if only taskGroupName is available
        if (taskGroupNameAvailableOnly) {
            return todoList.stream()
                    .filter(n -> n.getTaskGroupName().equals(taskGroupName))
                    .sequential()
                    .map(n -> new NodeTask(
                                    n.getName(),
                                    n.getDescription(),
                                    n.getTaskGroupName()
                            )
                    )
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        System.out.println("default");
        return todoList;
    }
}
