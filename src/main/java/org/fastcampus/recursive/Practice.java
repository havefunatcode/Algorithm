package org.fastcampus.recursive;

public class Practice {
    public static void main(String[] args) {
        System.out.println(practice(6));
    }

    public static int practice(int number) {
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        } else if (number == 3) {
            return 4;
        }

        return practice(number - 1) + practice(number - 2) + practice(number - 3);
    }

}
