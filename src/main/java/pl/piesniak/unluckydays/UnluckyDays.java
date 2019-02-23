package pl.piesniak.unluckydays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class UnluckyDays {

        public static int unluckyDays(int year) {
        return (int) IntStream.range(1,13)
                .mapToObj(i -> LocalDate.of(year,i,13))
                .filter(UnluckyDays::isFriday)
                .count();
    }

    public static int unluckyDaysFor(int year) {
        LocalDate date = LocalDate.of(year, 1,13);
        int result = 0;

        for (int i = 1; i <= 12; i++) {
            date = date.withMonth(i);
            if(isFriday(date)){
                result++;
            }
        }

        return result;
    }

    private static boolean isFriday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }
}

// 7kyu
// link: https://www.codewars.com/kata/unlucky-days/train/java
/**
 * Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.
 * <p>
 * Find the number of Friday 13th in the given year.
 * <p>
 * Input: Year as an integer.
 * <p>
 * Output: Number of Black Fridays in the year as an integer.
 * <p>
 * Examples:
 * <p>
 * unluckyDays(2015) == 3
 * unluckyDays(1986) == 1
 * Note: In Ruby years will start from 1593.
 */