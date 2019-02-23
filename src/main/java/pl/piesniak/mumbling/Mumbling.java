package pl.piesniak.mumbling;

public class Mumbling {

    public static String accum(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String ch = s.substring(i, i + 1);
            sb.append(ch.toUpperCase());

            for (int j = 0; j < i; j++) {
                sb.append(ch.toLowerCase());
            }

            if (i < length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}

// 7kyu
// https://www.codewars.com/kata/mumbling/train/java

/**
 * This time no story, no theory. The examples below show you how to write function accum:
 * <p>
 * Examples:
 * <p>
 * accum("abcd") -> "A-Bb-Ccc-Dddd"
 * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
 * accum("cwAt") -> "C-Ww-Aaa-Tttt"
 * The parameter of accum is a string which includes only letters from a..z and A..Z.
 */