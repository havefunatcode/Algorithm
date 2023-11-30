package org.fastcampus;

import java.util.ArrayList;
import java.util.List;

public class CreateIntArray {

    public static List<Integer> createIntArrayWithRandom(int size) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            res.add((int) (Math.random() * 100));
        }

        return res;
    }

}
