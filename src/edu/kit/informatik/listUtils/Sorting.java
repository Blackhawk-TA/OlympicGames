package edu.kit.informatik.listUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting<T> {

    public List<Integer> sortNum(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    /**
     * Returns all items which are equal in a sorted list
     * @param list The list to check
     * @return A list of equal items
     */
    public List<String> getEquals(List<String> list) {
        List<String> equals = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    equals.add(list.get(j));
                }
            }
        }

        return equals;
    }

}
