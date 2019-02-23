package pl.piesniak.kyu6.findmultiples;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindMultiples {

    public int solution(int number) {
        return IntStream.range(2, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }

    public int solutionFor(int number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                set.add(i);
            }
        }
        return set.stream()
                .mapToInt(n -> n)
                .sum();
    }
}

// 6kyu
// https://www.codewars.com/kata/multiples-of-3-or-5/train/java

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 * <p>
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 * <p>
 * Courtesy of ProjectEuler.net
 */