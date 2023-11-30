package org.fastcampus.recursive;

import org.fastcampus.CreateIntArray;

import java.util.ArrayList;
import java.util.List;

public class Factorial {
    public static void main(String[] args) {
        CreateIntArray createIntArray = new CreateIntArray();
        System.out.println(factorialWellKnown1(5));
        System.out.println(factorialWellKnown2(5));
        System.out.println(practice(createIntArray.createIntArrayWithRandom(5)));
    }

    public static int factorialWellKnown1(int number) {
        if (number > 1) {
            return number * factorialWellKnown1(number - 1);
        }
        return 1;
    }

    public static int factorialWellKnown2(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorialWellKnown2(number - 1);
    }

    public static int practice(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        }
        return numbers.get(0) + practice(numbers.subList(1, numbers.size()));
    }

}
