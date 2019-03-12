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
    public static void main(String[] args) throws ParseException {
        // Get the arguments
        CommandLine cmd = getArguments(getDefinitions(), args);

        // Execute the command
        executeLoadFile(cmd, args);
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

        // Add option "-f"
        options.addOption("f", false, "XML file to load");
        options.addOption("c", true, "The command to execute");

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("supbruh", options);

        return options;
    }

    /**
     * executeLoadFile will load the requested file
     *
     * @param cmd  The {@link CommandLine} object
     * @param args The arguments passed
     */
    private static void executeLoadFile(@NotNull CommandLine cmd, String[] args) throws ParseException {
        // Check which option was selected
        if (cmd.hasOption("f") && args.length > 1) {
            // Get the arguments
            String filename = args[1];

            // Load TaskGroups
            taskGroups = new TaskGroups(filename);

//            System.out.println(Arrays.toString(cmd.getOptions()));
////            System.out.println(options.toString());
////            System.out.println(tasks.getOptions());
//            System.out.println(tasks.getOptions().toString());
//            CommandLine cmd2 = getArguments(tasks.getOptions(), args);
//            System.out.println("1 "+cmd2.hasOption("f"));
//            System.out.println("2 "+cmd2.hasOption("c"));
        } else {
            // Load default TaskGroups
            taskGroups = new TaskGroups(null);
        }
    }
}
