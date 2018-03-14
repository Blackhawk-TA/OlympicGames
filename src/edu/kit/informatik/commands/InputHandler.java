package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;

public class InputHandler {

    /**
     * Handles all console commands
     */
    public static void inputs() {
        RegexHandler regex = new RegexHandler();
        boolean running = true;

        while (running) {
            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String arg = groups[1]; //The main command of the argument (such as "reset", "quit")

            if (regex.isValid(input)) {
                if (arg.matches("quit") && regex.hasParam(groups, 0)) {
                    running = false;
                }
                else if (arg.matches("reset") && regex.hasParam(groups, 0)) {
                    running = false;
                    Terminal.printLine("OK");
                }
                else {
                    Terminal.printError("unknown command or the input parameters are invalid.");
                }
            }
            else {
                Terminal.printError("command does not fit pattern.");
            }
        }
    }
}
