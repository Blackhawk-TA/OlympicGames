package edu.kit.informatik.utils;

import java.util.List;

public class ListUtils {
    /**
     * Get the index of an item by its name
     * @param list The list to check in
     * @param name The name of the item
     * @return Index in the list, -1 when not found
     */
    public static int getIndexByName(List<String> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
