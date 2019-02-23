package pl.piesniak.kyu6.findoddint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindOddInt {

    public static int findItXOR(int[] a) {
        int odd = 0;

        for (int i : a) {
            odd ^= i;
        }

        return odd;
    }

    public static int findIt(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int i : a) {
            s.add(i);
        }
        for (int v : s) {
            long count = Arrays.stream(a)
                    .filter(value -> value == v)
                    .count();
            if (count % 2 != 0) {
                return v;
            }
        }
        return 0;
    }
}

// 6kyu
// https://www.codewars.com/kata/find-the-odd-int/train/java

/**
 * Given an array, find the int that appears an odd number of times.
 * <p>
 * There will always be only one integer that appears an odd number of times.
 */