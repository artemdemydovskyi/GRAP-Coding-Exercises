package org.cern.firstExercise;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;

public class DuplicationFinder<T> {

    /**
     * This method is responsible for finding duplicates in the input list and adding them
     * to the output list in the order of their first occurrence as duplicated elements.
     * The logic works by adding/updating key-value pairs, where the key is the item itself, and the value
     * is the number of occurrences of that item. If it's the first occurrence of the item,
     * we return the default value of 0 for the following key, and for each subsequent occurrence,
     * the value is incremented by 1 and added back to the map.
     * After this process, the method identifies pairs where the occurrence count is more than 1,
     * and those items are added to the output list.
     *
     * @param inputList - the input list with all the elements
     * @return the list with the duplicates
     */
    public List<T> findDuplicates(List<T> inputList) {

        if(Objects.isNull(inputList) || inputList.isEmpty()){
            throw new IllegalArgumentException("The input list is empty or null");
        }

        Map<T, Integer> itemFrequencyMap = new HashMap<>();
        List<T> duplicates = new ArrayList<>();

        for (T item : inputList) {
            itemFrequencyMap.put(item, itemFrequencyMap.getOrDefault(item, 0) + 1);
        }

        for (T item : inputList) {
            if (itemFrequencyMap.get(item) > 1 && !duplicates.contains(item)) {
                duplicates.add(item);
            }
        }

        return duplicates;
    }
}
