package org.fastcampus.sorting;

import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        List<Integer> nums = CreateIntArray.createIntArrayWithRandom(10);
        insertionSort(nums);
        System.out.println(nums);
    }

    private static void insertionSort(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int curIdx = i;
            int curNum = nums.get(i);
            for (int j = i; j >= 0; j--) {
                if (nums.get(j) > curNum) {
                    curIdx = j;
                } else {
                    break;
                }
            }

            /*
            하기 알고리즘보다 느린 이유
            1. List의 Element를 삭제하고 지우는 연산 => 메모리 오버헤드가 ↑
            2. 별도의 연산이 필요한 lastIndexOf(curNum)
            */
            nums.add(curIdx, curNum);
            nums.remove(nums.lastIndexOf(curNum));
        }
    }

    private static void answer(List<Integer> nums) {
        for(int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums.get(j) < nums.get(j - 1)) {
                    Collections.swap(nums, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

}
