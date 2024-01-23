package org.fastcampus.search;

import org.fastcampus.CreateIntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> numList = CreateIntArray.createIntArrayWithRandom(10);
        Collections.sort(numList);
        int target = (int) (Math.random() * 100);

        System.out.println("target : " + target);
        System.out.println(numList);
        if (binarySearch(numList, target)) {
            System.out.println("Target is in list");
        } else {
            System.out.println("Target is not in list");
        }
    }

    public static boolean binarySearch(List<Integer> numList, int target) {
        if (numList.size() == 1) {
            if (numList.get(0) == target) {
                return true;
            } else {
                return false;
            }
        }

        int middleIdx = numList.size() / 2;
        int middleValue = numList.get(middleIdx);
        List<Integer> left = numList.subList(0, middleIdx);
        List<Integer> right = numList.subList(middleIdx, numList.size());

        if (middleValue == target) {
            return true;
        } else if (middleValue < target){
            return binarySearch(right, target);
        } else {
            return binarySearch(left, target);
        }
    }

}
