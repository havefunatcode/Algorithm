package org.fastcampus.sorting;

import org.fastcampus.CreateIntArray;

import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> numList = CreateIntArray.createIntArrayWithRandom(10000);
        Queue<Integer> numQueue = new LinkedList<>();
        numQueue.addAll(numList);

        long startTime = System.currentTimeMillis();
        List<Integer> result = quickSort(numList);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        long st = System.currentTimeMillis();
        Queue<Integer> resultWithQueue = quickSortWithQueue(numQueue);
        long et = System.currentTimeMillis();
        long elt = et - st;

        System.out.println("Using ArrayList : " + elapsedTime);
        System.out.println("Using LinkedList : " + elt);
    }

    private static List<Integer> quickSort(List<Integer> numList) {
        if (numList.size() <= 1) {
            return numList;
        }

        int pivot = numList.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int idx = 1; idx < numList.size(); idx++) {
            int currentNum = numList.get(idx);

            if (currentNum < pivot) {
                left.add(currentNum);
            } else {
                right.add(currentNum);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(quickSort(left));
        result.addAll(Arrays.asList(pivot));
        result.addAll(quickSort(right));

        return result;
    }

    private static Queue<Integer> quickSortWithQueue(Queue<Integer> numQueue) {
        if (numQueue.size() <= 1) {
            return numQueue;
        }

        int pivot = numQueue.poll();
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();

        for (int num : numQueue) {
            if (num > pivot) {
                right.add(num);
            } else {
                left.add(num);
            }
        }

        Queue<Integer> result = new LinkedList<>();
        result.addAll(quickSortWithQueue(left));
        result.add(pivot);
        result.addAll(quickSortWithQueue(right));

        return result;
    }

    /**
     * ArrayList를 사용한 구현방식과 LinkedList를 사용한 구현방식 중 어떤 것이 더 효율적일까?
     * 효율적 : 공간 복잡도 및 시간 복잡도가 더 낮다.
     * ArrayList는 탐색에 있어 LinkedList보다 더 효율적이다.
     * LinkedList는 요소의 추가/제거에 있어 ArrayList보다 더 효율적이다.
     *
     * 위의 코드에서는 List.add()를 호출하는 작업이 더 많기 때문에 LinkedList로 구현한 것이 속도가 더 빠르지 않을까? 라는 생각을 갖고 elapse Time을 출력해 보았다.
     *
     * quickSortWithQueue()가 quickSort()보다 속도가 더 빠를것이라고 생각했지만 50번 중 2번 꼴로 quickSort()가 더 빨랐다.
     * 왜일까?
     * 디버그를 찍어서 확인해본 결과 정렬해야 할 List의 요소가 많아지면 많아질 수록 탐색에 걸리는 시간이 quickSort()가 더 빠르기 때문이었다.
     * 1000개의 요소를 갖는 경우 quickSort()가 quickSortWithQueue()보다 느린 경우가 발생하였지만, 대부분의 경우 크게 차이가 나지 않았다.
     * (차이가 나도 1ms)
     *
     * 10000개의 요소를 갖는 경우 quickSort()가 quickSortWithQueue()보다 대부분의 경우에서 2ms 이상 빨랐다.
     * 탐색이 많은 경우 ArrayList를 사용하고, 탐색보다 요소의 추가/제거가 많은 경우 LinkedList를 사용해야겠다.
     */

}
