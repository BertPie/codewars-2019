package pl.piesniak.kyu4.morsecode2;


import pl.piesniak.kyu6.morsecode1.MorseCode;

import java.util.*;
import java.util.stream.Collectors;

public class MorseCodeDecoder {

    public static String decodeBits(String bits) {
        String bitsTrimmed = trimZeroes(bits);
        List<Integer> list = bitsToIntList(bitsTrimmed);

        int divider = findHighestCommonDenominator(list);
        List<Integer> dividedList = divideAllByCommonDenominator(list, divider);

        return listToMorse(dividedList);
    }

    private static String trimZeroes(String bits){

        int start = bits.indexOf('1');
        int end = bits.lastIndexOf('1') + 1;
        if(start == 0 && end == bits.length()) {
            return bits;
        }
        return bits.substring(start, end);
    }

    private static List<Integer> divideAllByCommonDenominator(List<Integer> list, int divider) {
        if(divider == 1){
            return list;
        }
        List<Integer> dividedList = new LinkedList<>();
        for (int i : list) {
            dividedList.add(i / divider);
        }
        return dividedList;
    }

    static int findHighestCommonDenominator(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        int highestCommonDenominator = 1;
        int max = set.stream()
                .mapToInt(i -> i)
                .max().getAsInt();
        for (int i = 2; i <= max; i++) {
            boolean isCommon = true;
            for(int number : set){
                if(number % i != 0){
                    isCommon = false;
                    break;
                }
            }
            if(isCommon){
                highestCommonDenominator = i;
            }
        }
        return highestCommonDenominator;
    }

    static List<Integer> bitsToIntList(String bits) {
        int cursor = 0;
        List<Integer> list = new LinkedList<>();
        while (true) {
            int number = getNextNumber(bits, cursor);
            list.add(number);
            cursor += number;
            if (cursor >= bits.length()) {
                break;
            }
        }
        return list;
    }

    static int getNextNumber(String bits, int cursor) {
        int length = 1;
        String currentBit = bits.substring(cursor, cursor + 1);
        while (true) {
            if (cursor + length + 1 > bits.length()) {
                break;
            }
            String nextBit = getNextBit(bits, cursor, length);
            if (!currentBit.equals(nextBit)) {
                break;
            }
            length++;
        }
        return length;
    }

    static String getNextBit(String bits, int cursor, int offset) {
        return bits.substring(cursor + offset, cursor + offset + 1);
    }

    static String listToMorse(List<Integer> list) {
        boolean onOne = true;
        StringBuilder sb = new StringBuilder();

        for (int number : list) {
            sb.append(getMorseCode(number, onOne));
            onOne ^= true;
        }
        return sb.toString();
    }

    static String getMorseCode(int number, boolean isOne) {
        if (isOne) {
            return getOneMorseCode(number);
        }
        return getZeroMorseCode(number);
    }

    static String getZeroMorseCode(int number) {
        switch (number) {
            case 1:
                return "";
            case 3:
                return " ";
            case 7:
                return "   ";
        }
        return "***error-0***";
    }

    static String getOneMorseCode(int number) {
        switch (number) {
            case 1:
                return ".";
            case 3:
                return "-";
        }
        return "***error-1***";
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" "))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }
}

// 4kyu
// https://www.codewars.com/kata/decode-the-morse-code-advanced/train/java

/**
 * In this kata you have to write a Morse code decoder for wired electrical telegraph.
 * Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots" (short presses on the key) and "dashes" (long presses on the key).
 * <p>
 * When transmitting the Morse code, the international standard specifies that:
 * <p>
 * "Dot" – is 1 time unit long.
 * "Dash" – is 3 time units long.
 * Pause between dots and dashes in a character – is 1 time unit long.
 * Pause between characters inside a word – is 3 time units long.
 * Pause between words – is 7 time units long.
 * However, the standard does not specify how long that "time unit" is. And in fact different operators would transmit at different speed. An amateur person may need a few seconds to transmit a single character, a skilled professional can transmit 60 words per minute, and robotic transmitters may go way faster.
 * <p>
 * For this kata we assume the message receiving is performed automatically by the hardware that checks the line periodically, and if the line is connected (the key at the remote station is down), 1 is recorded, and if the line is not connected (remote key is up), 0 is recorded. After the message is fully received, it gets to you for decoding as a string containing only symbols 0 and 1.
 * <p>
 * For example, the message HEY JUDE, that is ···· · −·−− ·−−− ··− −·· · may be received as follows:
 * <p>
 * 1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011
 * <p>
 * As you may see, this transmission is perfectly accurate according to the standard, and the hardware sampled the line exactly two times per "dot".
 * <p>
 * That said, your task is to implement two functions:
 * <p>
 * Function decodeBits(bits), that should find out the transmission rate of the message, correctly decode the message to dots ., dashes - and spaces (one between characters, three between words) and return those as a string. Note that some extra 0's may naturally occur at the beginning and the end of a message, make sure to ignore them. Also if you have trouble discerning if the particular sequence of 1's is a dot or a dash, assume it's a dot.
 * <p>
 * Function decodeMorse(morseCode), that would take the output of the previous function and return a human-readable string.
 * <p>
 * NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.
 * <p>
 * The Morse code table is preloaded for you as MORSE_CODE dictionary; in Java MorseCode class is provided; in Haskell the codes are in a Map String String and can be accessed like this: morseCodes ! ".--" - feel free to use it.
 * <p>
 * All the test strings would be valid to the point that they could be reliably decoded as described above, so you may skip checking for errors and exceptions, just do your best in figuring out what the message is!
 * <p>
 * Good luck!
 */