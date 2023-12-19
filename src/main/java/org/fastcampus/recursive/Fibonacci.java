package org.fastcampus.recursive;

public class Fibonacci {

    public static void main(String[] args) {
//        System.out.println(recursiveCall(10));
        System.out.println(dp(9));
    }

    private static Integer recursiveCall(int num) {
        if (num <= 1) {
            return num;
        }

        return recursiveCall(num - 1) + recursiveCall(num - 2);
    }

    private static Integer dp(int num) {
        Integer[] cache = new Integer[num + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int idx = 2; idx < num + 1; idx ++) {
            cache[idx] = cache[idx - 1] + cache[idx - 2];
        }

        return cache[num];
    }

}
