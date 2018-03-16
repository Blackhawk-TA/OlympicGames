package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.core.Core;

public class InputHandler {
    private static RegexHandler regexCmd = new RegexHandler("command");
    private static RegexHandler regexAddAdmin = new RegexHandler("addAcc");
    private static RegexHandler regexLogin = new RegexHandler("login");
    private static Core core = new Core();
    private static boolean running = true;

    /**
     * Handles all console commands
     */
    public static void inputs() {
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
                if (core.getSystem().adminActive()) {
                    inputsLogin(arg, groups, groupsAdmin, groupsLogin);
                } else {
                    inputsNoLogin(arg, groups, groupsAdmin, groupsLogin);
                }
            }
            else
                Terminal.printError("command does not fit pattern.");
        }
    }

    //Handles inputs when an admin is logged in
    private static void inputsLogin(String arg, String[] groups, String[] groupsAdmin, String[] groupsLogin) {
        if (arg.matches("quit") && regexCmd.hasParam(groups, 0)) {
            running = false;
        } else if (arg.matches("reset") && regexCmd.hasParam(groups, 0)) {
            running = false;
            Terminal.printLine("OK");
        } else if (arg.matches("logout-admin") && regexCmd.hasParam(groups, 0)) {
            Terminal.printLine(core.getSystem().logout());
        } else if (arg.matches("add-sports-venue") && regexCmd.hasParam(groups, 6)) {
            int param0 = regexCmd.getNum(regexCmd.getParam(groups, 0));
            int param4 = regexCmd.getNum(regexCmd.getParam(groups, 4));
            int param5 = regexCmd.getNum(regexCmd.getParam(groups, 5));

            if (param0 != -1 && param4 != -1 && param5 != -1) {
                Terminal.printLine(core.getVenueHandler().addSportsVenue(
                        param0,
                        regexCmd.getParam(groups, 1),
                        regexCmd.getParam(groups, 2),
                        regexCmd.getParam(groups, 3),
                        param4,
                        param5));
            } else
                Terminal.printError("invalid input parameters.");
        } else if (arg.matches("list-sports-venue") && regexCmd.hasParam(groups, 0)) {
            Terminal.printLine(core.getVenueHandler().listSportVenues(
                    regexCmd.getParam(groups, 0)
            ));
        } else if (arg.matches("add-olympic-sport") && regexCmd.hasParam(groups, 2)) {
            Terminal.printLine(core.getSportHandler().addDiscipline(
                    regexCmd.getParam(groups, 0),
                    regexCmd.getParam(groups, 1)
            ));
        } else if (arg.matches("list-olympic-sport") && regexCmd.hasParam(groups, 0)) {
            Terminal.printLine(core.getSportHandler().listSports());
        } else if (arg.matches("add-ioc-code") && regexCmd.hasParam(groups, 4)) {
            int param0 = regexCmd.getNum(regexCmd.getParam(groups, 0));
            int param3 = regexCmd.getNum(regexCmd.getParam(groups, 3));

            if (param0 != -1 && param3 != -1) {
                Terminal.printLine(core.getIocHandler().addIOC(
                        param0,
                        regexCmd.getParam(groups, 1),
                        regexCmd.getParam(groups, 2),
                        param3
                ));
            } else
                Terminal.printError("invalid input parameters.");
        } else if (arg.matches("list-ioc-codes") && regexCmd.hasParam(groups, 0)) {
            Terminal.printLine(core.getIocHandler().listIOC());
        } else if (arg.matches("add-athlete") && regexCmd.hasParam(groups, 6)) {
            int param0 = regexCmd.getNum(regexCmd.getParam(groups, 0));

            if (param0 != -1) {
                Terminal.printLine(core.getAthleteHandler().addAthlete(
                        param0,
                        regexCmd.getParam(groups, 1),
                        regexCmd.getParam(groups, 2),
                        regexCmd.getParam(groups, 3),
                        regexCmd.getParam(groups, 4),
                        regexCmd.getParam(groups, 5)
                ));
            } else {
                Terminal.printError("invalid input parameters.");
            }
        } else if (arg.matches("summary-athletes") && regexCmd.hasParam(groups, 6)) {
            Terminal.printLine(core.getAthleteHandler().summaryAthletes(
                    regexCmd.getParam(groups, 0),
                    regexCmd.getParam(groups, 1)
            ));
        } else {
            Terminal.printError("unknown command or the input parameters are invalid.");
        }
    }

    //Handles inputs when no admin is logged in
    private static void inputsNoLogin(String arg, String[] groups, String[] groupsAdmin, String[] groupsLogin) {
        if (arg.matches("quit") && regexCmd.hasParam(groups, 0)) {
            running = false;
        } else if (arg.matches("login-admin") && regexLogin.hasParam(groupsLogin, 2)) {
            Terminal.printLine(core.getSystem().login(
                    regexLogin.getParam(groupsLogin, 0),
                    regexLogin.getParam(groupsLogin, 1)
            ));
        } else if (arg.matches("add-admin") && regexAddAdmin.hasParam(groupsAdmin, 4)) {
            Terminal.printLine(core.getSystem().addAccount(
                    regexAddAdmin.getParam(groupsAdmin, 0),
                    regexAddAdmin.getParam(groupsAdmin, 1),
                    regexAddAdmin.getParam(groupsAdmin, 2),
                    regexAddAdmin.getParam(groupsAdmin, 3)
            ));
        } else {
            Terminal.printError("unknown command, invalid input parameters or not logged in.");
        }
    }
}
