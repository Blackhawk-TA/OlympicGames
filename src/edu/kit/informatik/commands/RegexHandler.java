package edu.kit.informatik.commands;

import java.util.regex.*;

public class RegexHandler {
    private int groupMod; //Group modifier for input parameters
    private int groupNum; //Amount of expected groups in a regex
    private Pattern pattern;

    /**
     * Regex Constructor
     */
    RegexHandler() {
        pattern = Pattern.compile("^([a-z-]+)(\\s)?((\\w+);){0,7}(\\w+)?$");
        groupMod = 1; //when input is for game init, params start at index 1
        groupNum = 6;
    }

    /**
     * Check if a command has n amount of parameters
     * @param groups the regex groups of the command
     * @param n amount of parameters the command should have
     * @return true if amount of parameters is n
     */
    boolean hasParam(String[] groups, int n) {
        int counter = 0;

        if (n == 0 && groups[2] != null)
            return false;
        else if (n > 0 && groups[2] == null)
            return false;

        for (int i = groupMod; i < groups.length; i++) {
            if (counter == n && !groups[i].isEmpty())
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
        if (!groups[index + groupMod].isEmpty())
            return groups[index + groupMod];
        else
            return "";
    }

    /**
     * Check if input is valid
     * @param arg input arguments
     * @return true if input is valid
     */
    boolean isValid(String arg) {
        //check if arg matches pattern + last char is not ";"
        return pattern.matcher(arg).find() && !arg.substring(arg.length() - 1).equals(";");
    }
}