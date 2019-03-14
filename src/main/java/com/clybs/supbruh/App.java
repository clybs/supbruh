package com.clybs.supbruh;

import com.clybs.supbruh.tasks.TaskGroups;
import org.apache.commons.cli.*;
import org.jetbrains.annotations.NotNull;

/**
 * Entry point
 */
public class App {
    private static TaskGroups taskGroups;
    private static Options options;

    /**
     * main method of
     *
     * @param args The string of arguments passed
     * @throws ParseException
     */
    public static void main(String[] args) {
        try {
            // Get the arguments
            CommandLine cmd = getArguments(getDefinitions(), args);

            // Execute the command
            executeLoadAndParseFile(cmd);

            // Check if tasks were found
            executeTasks();
        } catch (ParseException pe) {
            System.out.println(pe.getLocalizedMessage());
        }
    }

    /**
     * getArguments will get the arguments passed in the commandline
     *
     * @param options The {@link Options} object
     * @param args    The arguments passed
     * @return CommandLine object
     * @throws ParseException
     */
    private static CommandLine getArguments(Options options, String[] args) throws ParseException {
        // Create a parser
        CommandLineParser parser = new DefaultParser();

        // Parse the options passed as command line arguments
        CommandLine cmd = parser.parse(options, args);

        return cmd;
    }

    /**
     * getDefinitions will get the definitions that will be used
     *
     * @return Options object
     */
    private static Options getDefinitions() {
        // Create Options object
        options = new Options();

        // Add user options
        options.addOption("f", "filename", true, "XML file to load. Default file if not specified is tasks.xml.");
        options.addOption("n", "name", true, "The task name to execute.");
        options.addOption("g", "groupname", true, "The task group name to execute.");
        options.addOption("h", "help", false, "Help manual.");

        return options;
    }

    /**
     * executeLoadAndParseFile will load the requested file
     *
     * @param cmd The {@link CommandLine} object
     */
    private static void executeLoadAndParseFile(@NotNull CommandLine cmd) {
        // Get the values
        String filename = null;
        String taskName = null;
        String taskGroupName = null;

        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("supbruh", options);

            return;
        }

        if (cmd.hasOption("f")) {
            filename = cmd.getOptionValue("f");
        }

        if (cmd.hasOption("n")) {
            taskName = cmd.getOptionValue("n");
        }

        if (cmd.hasOption("g")) {
            taskGroupName = cmd.getOptionValue("g");
        }

        // Load TaskGroups
        taskGroups = new TaskGroups(filename, taskName, taskGroupName);
    }

    private static void executeTasks() {
        // Check if there are tasks to execute
        if (taskGroups.getTodoList().isEmpty()) {
            System.out.println("No task to execute");
            return;
        }

        System.out.println("Execute task");
        taskGroups.getTodoList().forEach(System.out::println);
    }
}
