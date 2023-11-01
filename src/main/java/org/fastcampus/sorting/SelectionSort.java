package org.fastcampus.sorting;

import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> nums = CreateIntArray.createIntArrayWithRandom(10);
        selectionSort(nums);
//        System.out.println(answer(nums));
    }

    private static void selectionSort(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int minIdx = findMinIdx(nums.subList(i, nums.size())) + i;
            Collections.swap(nums, i, minIdx);
        }

        System.out.println(nums);
    }

    private static int findMinIdx(List<Integer> partialNums) {
        int minIdx = 0;
        int partialNumsSize = partialNums.size();

        for (int currentIdx = 0; currentIdx < partialNumsSize; currentIdx++) {
            int currentValue = partialNums.get(currentIdx);
            if (partialNums.get(minIdx) > currentValue) {
                minIdx = currentIdx;
            }
        }

        return minIdx;
    }

    private static List<Integer> answer(List<Integer> nums) {
        int minValueIndex;
        for (int i = 0; i < nums.size() - 1; i++) {
            minValueIndex = i;

            for (int idx = i + 1; idx < nums.size(); idx++) {
                if (nums.get(minValueIndex) > nums.get(idx)) {
                    minValueIndex = idx;
                }
            }

            Collections.swap(nums, minValueIndex, i);
        }

        return nums;
    }

}
