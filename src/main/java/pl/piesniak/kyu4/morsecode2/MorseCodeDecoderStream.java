package pl.piesniak.kyu4.morsecode2;

import pl.piesniak.kyu6.morsecode.MorseCode;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseCodeDecoderStream {

    private static final int WORD_PAUSE = 7;
    private static final int CHAR_PAUSE = 3;
    private static final int SIGN_PAUSE = 1;

    private static int rate = 1;

    public static String decodeBits(String bits) {

        String bitsTrimmed = trimBits(bits);

        setRate(bitsTrimmed);

        return decodeBitString(bitsTrimmed);
    }

    static String decodeBitString(String bitString) {

        String wordSplitRegex = "0{" + (rate * WORD_PAUSE) + "}";

        return Arrays.stream(bitString.split(wordSplitRegex))
                .map(MorseCodeDecoderStream::decodeBitWord)
                .collect(Collectors.joining("   "));
    }

    static String decodeBitWord(String bitWord) {

        String charSplitRegex = "0{" + (rate * CHAR_PAUSE) + "}";

        return Arrays.stream(bitWord.split(charSplitRegex))
                .map(MorseCodeDecoderStream::decodeBitChar)
                .collect(Collectors.joining(" "));
    }

    static String decodeBitChar(String bitChar) {

        String signSplitRegex = "0{" + (rate * SIGN_PAUSE) + "}";

        return Arrays.stream(bitChar.split(signSplitRegex))
                .map(MorseCodeDecoderStream::getMorseChar)
                .collect(Collectors.joining());
    }

    static String getMorseChar(String bitSign) {

        int length = bitSign.length() / rate;

        switch (length) {
            case 1:
                return ".";
            case 3:
                return "-";
            default:
                return "***error***";
        }
    }

    private static void setRate(String bits) {
        rate = Integer.MAX_VALUE;
        Matcher matcher = Pattern.compile("1+|0+").matcher(bits);
        while (matcher.find()) {
            rate = Math.min(rate, matcher.group().length());
        }
    }

    static String trimBits(String bits) {
        return bits.replaceAll("(^0+)|(0+$)", "");
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoderStream::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" "))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }
}