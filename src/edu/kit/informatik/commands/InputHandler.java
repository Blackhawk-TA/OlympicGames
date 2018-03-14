package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.admin.AccountSystem;

public class InputHandler {

    /**
     * Handles all console commands
     */
    public static void inputs() {
        RegexHandler regexCmd = new RegexHandler("command"); //TODO adapt
        RegexHandler regexAddAdmin = new RegexHandler("addAcc");
        RegexHandler regexLogin = new RegexHandler("login");
        AccountSystem system = new AccountSystem();
        boolean running = true;

        while (running) {
            String input = Terminal.readLine();
            String[] groups = regexCmd.createGroups(input);
            String[] groupsAdmin = regexAddAdmin.createGroups(input);
            String[] groupsLogin = regexLogin.createGroups(input);
            String arg;

            //Set the regex type depending on input
            if (groups[1] == null && groupsAdmin[1] != null && groupsLogin[1] == null)
                arg = groupsAdmin[1];
            else if (groups[1] == null && groupsAdmin[1] == null && groupsLogin[1] != null)
                arg = groupsLogin[1];
            else
                arg = groups[1];

            if (arg != null && (regexCmd.isValid(input) || regexAddAdmin.isValid(input) || regexLogin.isValid(input))) {
                if (system.adminActive()) {
                    if (arg.matches("quit") && regexCmd.hasParam(groups, 0)) {
                        running = false;
                    } else if (arg.matches("reset") && regexCmd.hasParam(groups, 0)) {
                        running = false;
                        Terminal.printLine("OK");
                    } else if (arg.matches("logout-admin") && regexCmd.hasParam(groups, 0)) {
                        Terminal.printLine(system.logout());
                    } else {
                        Terminal.printError("unknown command or the input parameters are invalid.");
                    }
                } else {
                    if (arg.matches("quit") && regexCmd.hasParam(groups, 0)) {
                        running = false;
                    } else if (arg.matches("login-admin") && regexLogin.hasParam(groupsLogin, 2)) {
                        Terminal.printLine(system.login(
                                regexLogin.getParam(groupsLogin, 0),
                                regexLogin.getParam(groupsLogin, 1)
                                )
                        );
                    } else if (arg.matches("add-admin") && regexAddAdmin.hasParam(groupsAdmin, 4)) {
                        Terminal.printLine(system.addAccount(
                                regexAddAdmin.getParam(groupsAdmin, 0),
                                regexAddAdmin.getParam(groupsAdmin, 1),
                                regexAddAdmin.getParam(groupsAdmin, 2),
                                regexAddAdmin.getParam(groupsAdmin, 3)
                                )
                        );
                    } else {
                        Terminal.printError("unknown command, invalid input parameters or not logged in.");
                    }
                }
            }
            else {
                Terminal.printError("command does not fit pattern.");
            }
        }
    }
}
