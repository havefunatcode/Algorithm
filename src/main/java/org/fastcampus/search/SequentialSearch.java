package org.fastcampus.search;

import org.fastcampus.CreateIntArray;

import javax.xml.transform.stax.StAXResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequentialSearch {

    public static void main(String[] args) {
        List<Integer> numsList = CreateIntArray.createIntArrayWithRandom(10);
        int target = (int) (Math.random() * 100);
        Map<String, Integer> result = sequentialSearch(numsList, target);

        if (result.size() == 0) {
            System.out.println(numsList);
            System.out.println("target : " + target);
            System.out.println("No target in list.");
        } else {
            System.out.println(numsList);
            System.out.println("target : " + target);
            System.out.println(result);
        }

    }

    public static Map<String, Integer> sequentialSearch(List<Integer> numList, int target) {
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == target) {
                result.put("target", numList.get(i));
                result.put("index", i + 1);
            }
        }

        return result;
    }

}
