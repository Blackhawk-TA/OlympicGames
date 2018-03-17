package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.core.Core;

public class InputHandler {
    private static final RegexHandler REG_CMD = new RegexHandler("command");
    private static final RegexHandler REG_ADMIN = new RegexHandler("addAcc");
    private static final RegexHandler REG_LOGIN = new RegexHandler("login");
    private static final Core CORE = new Core();
    private static boolean running = true;

    /**
     * Handles all console commands
     */
    public static void inputs() {
        while (running) {
            String input = Terminal.readLine();
            String[] groups = REG_CMD.createGroups(input);
            String[] groupsAdmin = REG_ADMIN.createGroups(input);
            String[] groupsLogin = REG_LOGIN.createGroups(input);
            String arg;

            //Set the regex type depending on input
            if (groups[1] == null && groupsAdmin[1] != null && groupsLogin[1] == null)
                arg = groupsAdmin[1];
            else if (groups[1] == null && groupsAdmin[1] == null && groupsLogin[1] != null)
                arg = groupsLogin[1];
            else
                arg = groups[1];

            if (arg != null && (REG_CMD.isValid(input) || REG_ADMIN.isValid(input) || REG_LOGIN.isValid(input))) {
                if (CORE.getSystem().adminActive()) {
                    inputsLogin(arg, groups);
                } else {
                    inputsNoLogin(arg, groups, groupsAdmin, groupsLogin);
                }
            }
            else {
                Terminal.printError("command does not fit pattern.");
            }
        }
    }

    //Handles inputs when an admin is logged in
    private static void inputsLogin(String arg, String[] groups) {
        if (arg.matches("quit") && REG_CMD.hasParam(groups, 0)) {
            running = false;
        } else if (arg.matches("reset") && REG_CMD.hasParam(groups, 0)) {
            running = false;
            Terminal.printLine("OK");
        } else if (arg.matches("logout-admin") && REG_CMD.hasParam(groups, 0)) {
            Terminal.printLine(CORE.getSystem().logout());
        } else if (arg.matches("add-sports-venue") && REG_CMD.hasParam(groups, 6)) {
            int param0 = REG_CMD.getNum(REG_CMD.getParam(groups, 0));
            int param4 = REG_CMD.getNum(REG_CMD.getParam(groups, 4));
            int param5 = REG_CMD.getNum(REG_CMD.getParam(groups, 5));

            if (param0 != -1 && param4 != -1 && param5 != -1) {
                Terminal.printLine(CORE.getVenueHandler().addSportsVenue(
                        param0,
                        REG_CMD.getParam(groups, 1),
                        REG_CMD.getParam(groups, 2),
                        REG_CMD.getParam(groups, 3),
                        param4,
                        param5));
            } else {
                Terminal.printError("invalid input parameters.");
            }
        } else if (arg.matches("list-sports-venue") && REG_CMD.hasParam(groups, 0)) {
            Terminal.printLine(CORE.getVenueHandler().listSportVenues(
                    REG_CMD.getParam(groups, 0)
            ));
        } else if (arg.matches("add-olympic-sport") && REG_CMD.hasParam(groups, 2)) {
            Terminal.printLine(CORE.getSportHandler().addDiscipline(
                    REG_CMD.getParam(groups, 0),
                    REG_CMD.getParam(groups, 1)
            ));
        } else if (arg.matches("list-olympic-sport") && REG_CMD.hasParam(groups, 0)) {
            Terminal.printLine(CORE.getSportHandler().listSports());
        } else if (arg.matches("add-ioc-code") && REG_CMD.hasParam(groups, 4)) {
            int param0 = REG_CMD.getNum(REG_CMD.getParam(groups, 0));
            int param3 = REG_CMD.getNum(REG_CMD.getParam(groups, 3));

            if (param0 != -1 && param3 != -1) {
                Terminal.printLine(CORE.getIocHandler().addIOC(
                        param0,
                        REG_CMD.getParam(groups, 1),
                        REG_CMD.getParam(groups, 2),
                        param3
                ));
            } else {
                Terminal.printError("invalid input parameters.");
            }
        } else if (arg.matches("list-ioc-codes") && REG_CMD.hasParam(groups, 0)) {
            Terminal.printLine(CORE.getIocHandler().listIOC());
        } else if (arg.matches("add-athlete") && REG_CMD.hasParam(groups, 6)) {
            int param0 = REG_CMD.getNum(REG_CMD.getParam(groups, 0));

            if (param0 != -1) {
                Terminal.printLine(CORE.getAthleteHandler().addAthlete(
                        param0,
                        REG_CMD.getParam(groups, 1),
                        REG_CMD.getParam(groups, 2),
                        REG_CMD.getParam(groups, 3),
                        REG_CMD.getParam(groups, 4),
                        REG_CMD.getParam(groups, 5)
                ));
            } else {
                Terminal.printError("invalid input parameters.");
            }
        } else if (arg.matches("summary-athletes") && REG_CMD.hasParam(groups, 2)) {
            Terminal.printLine(CORE.getAthleteHandler().summaryAthletes(
                    REG_CMD.getParam(groups, 0),
                    REG_CMD.getParam(groups, 1)
            ));
        } else {
            Terminal.printError("unknown command or the input parameters are invalid.");
        }
    }

    //Handles inputs when no admin is logged in
    private static void inputsNoLogin(String arg, String[] groups, String[] groupsAdmin, String[] groupsLogin) {
        if (arg.matches("quit") && REG_CMD.hasParam(groups, 0)) {
            running = false;
        } else if (arg.matches("login-admin") && REG_LOGIN.hasParam(groupsLogin, 2)) {
            Terminal.printLine(CORE.getSystem().login(
                    REG_LOGIN.getParam(groupsLogin, 0),
                    REG_LOGIN.getParam(groupsLogin, 1)
            ));
        } else if (arg.matches("add-admin") && REG_ADMIN.hasParam(groupsAdmin, 4)) {
            Terminal.printLine(CORE.getSystem().addAccount(
                    REG_ADMIN.getParam(groupsAdmin, 0),
                    REG_ADMIN.getParam(groupsAdmin, 1),
                    REG_ADMIN.getParam(groupsAdmin, 2),
                    REG_ADMIN.getParam(groupsAdmin, 3)
            ));
        } else {
            Terminal.printError("unknown command, invalid input parameters or not logged in.");
        }
    }
}
