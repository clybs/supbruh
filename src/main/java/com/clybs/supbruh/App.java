package com.clybs.supbruh;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.jetbrains.annotations.NotNull;
import com.clybs.supbruh.commands.Commands;

/**
 * Entry point
 */
public class App {
    private static Commands commands;

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
        execute(cmd, args);
    }

    /**
     * getArguments will get the arguments passed in the commandline
     *
     * @param options The options object
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
        Options options = new Options();

        // Add option "-f"
        options.addOption("f", false, "XML file to load");

        return options;
    }

    /**
     * execute will do the requested command
     *
     * @param cmd  The CommandLine object
     * @param args the arguments passed
     */
    private static void execute(@NotNull CommandLine cmd, String[] args) {
        // Check which option was selected
        if (cmd.hasOption("f") && args.length > 1) {
            // Load Commands
            commands = new Commands(args[1]);
        } else {
            // Load default Commands
            commands = new Commands(null);
        }
    }
}
