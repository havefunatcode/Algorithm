package org.fastcampus.sorting;

import org.fastcampus.CreateIntArray;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        List<Integer> numList = CreateIntArray.createIntArrayWithRandom(10);
        List<Integer> mergedList = mergeSort(numList);
        System.out.println(mergedList);
    }

    private static List<Integer> mergeSort(List<Integer> numList) {
        int numListSize = numList.size();
        if (numListSize <= 1) {
            return numList;
        }

        int centerIdx = numListSize / 2;
        List<Integer> left = mergeSort(new ArrayList<>(numList.subList(0, centerIdx)));
        List<Integer> right = mergeSort(new ArrayList<>(numList.subList(centerIdx, numListSize)));

        return mergeLeftAndRightLists(left, right);
    }

    private static List<Integer> mergeLeftAndRightLists(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftPoint = 0;
        int leftSize = left.size();
        int rightPoint = 0;
        int rightSize = right.size();

        while (leftPoint < leftSize && rightPoint < rightSize) {
            if (left.get(leftPoint) > right.get(rightPoint)) {
                result.add(right.get(rightPoint++));
            } else {
                result.add(left.get(leftPoint++));
            }
        }

        if (leftPoint < leftSize) {
            result.addAll(left.subList(leftPoint, leftSize));
        } else {
            result.addAll(right.subList(rightPoint, rightSize));
        }

        return result;
    }

    private static List<Integer> mergeLeftAndRightLists2(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftPoint = 0;
        int leftSize = left.size();
        int rightPoint = 0;
        int rightSize = right.size();

        while (leftPoint < leftSize && rightPoint < rightSize) {
            if (left.get(leftPoint) > right.get(rightPoint)) {
                result.add(right.get(rightPoint));
                rightPoint += 1;
            } else {
                result.add(left.get(leftPoint));
                leftPoint += 1;
            }
        }

        while (leftPoint < leftSize) {
            result.add(left.get(leftPoint));
            leftPoint += 1;
        }

        while (rightPoint < rightSize) {
            result.add(right.get(rightPoint));
            rightPoint += 1;
        }

        return result;
    }

}
