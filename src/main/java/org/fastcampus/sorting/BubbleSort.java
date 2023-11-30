package org.fastcampus.sorting;

import org.fastcampus.CreateIntArray;

import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> numsList = CreateIntArray.createIntArrayWithRandom(10);
        Integer[] numsArray = numsList.toArray(new Integer[numsList.size()]);

        bubbleSort(numsArray, numsArray.length);
        answer(numsList);

        System.out.println(numsList);
        for (Integer num : numsArray) {
            System.out.printf("%d ", num);
        }
    }

    private static void bubbleSort(Integer[] nums, int numSize) {
        int temp = 0;

        for (int i = 0; i < numSize; i++) {
            for (int j = 1; j < (numSize - i); j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    private static void answer(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            boolean isSwap = false;

            for (int j = 0; j < nums.size() - 1 - i; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    Collections.swap(nums, j, j + 1);
                    isSwap = true;
                }
            }

            if (!isSwap) break;
        }
    }

}
