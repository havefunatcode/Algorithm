package org.fastcampus.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {

    public static void main(String[] args) {
        int[][] inputs = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        solve(inputs, 30);
    }

    private static void solve(int[][] inputs, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        sortInputs(inputs);

        for (int idx = 0; idx < inputs.length; idx++) {
            if ((capacity - (double)inputs[idx][0]) > 0) {
                // 물건을 분할하지 않는 경우
                capacity -= inputs[idx][0];
                totalValue += inputs[idx][1];
                System.out.println("무게 : " + inputs[idx][0] + ", 가치 : " + inputs[idx][1]);
            } else {
                // 물건을 분할하는 경우
                fraction = capacity / inputs[idx][0];
                totalValue += inputs[idx][1] * fraction;
                System.out.println("무게 : " + inputs[idx][0] + ", 가치 : " + inputs[idx][1] + ", 비율 : " + fraction);
                break;
            }
        }

        System.out.println("최대 가치 : " + totalValue);
    }

    private static void sortInputs(int[][] inputs) {
        Arrays.sort(inputs, Comparator.comparingDouble((int[] o) -> {
            double weightPerValue = (double) o[1] / o[0];
            return Math.round(weightPerValue * 100.0) / 100.0;
        }).reversed());
    }

}
