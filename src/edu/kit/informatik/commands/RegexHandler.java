package edu.kit.informatik.commands;

import java.util.regex.*;

class RegexHandler {
    private int groupMod; //Group modifier for input parameters
    private int groupNum; //Amount of expected groups in a regex
    private Pattern pattern;

    /**
     * Regex Constructor
     * @param mode This defines which regex pattern should be used
     */
    RegexHandler(String mode) {
        switch (mode) {
            case "command":
                pattern = Pattern.compile("^([a-z-]+)(\\s)?(.[^;]*)?;?(.[^;]*)?;?(.[^;]*)?;?(.[^;]*)?;?(.[^;]*)?;?"
                                            + "(.[^;]*)?;?(.[^;]*)?;?(.[^;]*)?$"); //80 char max width is fun
                groupMod = 3; //when input is for game init, params start at index 1
                groupNum = 11;
                break;
            case "addAcc":
                pattern = Pattern.compile("^(add-admin)\\s(.[^;]*);(.[^;]*);(.[^;]{3,7});(.[^;]{7,11})$");
                groupMod = 2; //when input is for game init, params start at index 1
                groupNum = 6;
                break;
            case "login":
                pattern = Pattern.compile("^(login-admin)\\s(.[^;]{3,7});(.[^;]{7,11})$");
                groupMod = 2; //when input is for game init, params start at index 1
                groupNum = 4;
                break;
            default:
                break;
        }
    }

    /**
     * Check if a command has n amount of parameters
     * @param groups the regex groups of the command
     * @param n amount of parameters the command should have
     * @return true if amount of parameters is n
     */
    boolean hasParam(String[] groups, int n) {
        int counter = 0;

        //If space is wrong return false
        if (n == 0 && groups[2] != null)
            return false;
        else if (n > 0 && groups[2] == null)
            return false;

        for (int i = groupMod; i < groups.length; i++) {
            if (counter == n && groups[i] != null && !groups[i].isEmpty())
                return false;

            if (groups[i] != null && !groups[i].isEmpty())
                counter++;
        }

        return counter == n;
    }

    /**
     * Get groups from the chat command
     * @param arg input command
     * @return array of groups
     */
    String[] createGroups(String arg) {
        String[] groups = new String[groupNum];
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                groups[i] = matcher.group(i);
            }
        }
        return groups;
    }

    /**
     * Gets the parameters from the command and converts it to int
     * @param groups the entered command split up in groups
     * @param index index of the param
     * @return array of parameters
     */
    String getParam(String[] groups, int index) {
        String groupItem = groups[index + groupMod];
        if (!groupItem.isEmpty()) {
            //On first param, remove space in front of it if necessary
            if (index == 0 & groupItem.startsWith(" ")) {
                groupItem = groupItem.substring(1);
            }
            return groupItem;
        }
        else {
            return "";
        }
    }

    /**
     * Check if string is a number
     * @param arg The String to check
     * @return The int the String contains or -1 is String is not a number
     */
    int getNum(String arg) {
        Pattern p = Pattern.compile("\\d");
        if (p.matcher(arg).find()) {
            return Integer.parseInt(arg);
        } else {
            return -1;
        }
    }

    /**
     * Check if input is valid
     * @param arg input arguments
     * @return true if input is valid
     */
    boolean isValid(String arg) {
        //check if arg matches pattern and last char is not ";" and no new line char exists
        return pattern.matcher(arg).find() && !arg.substring(arg.length() - 1).equals(";")
                && !arg.contains("\\n") && !arg.contains("\\r");
    }
}
