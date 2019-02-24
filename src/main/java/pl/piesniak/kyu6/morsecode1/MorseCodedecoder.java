package pl.piesniak.kyu6.morsecode1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodedecoder {
    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodedecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" "))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }

    public static String decodeLoop(String morseCode) {
        StringBuilder sb = new StringBuilder();
        for (String word : morseCode.trim().split("   ")) {
            for (String letter : word.trim().split(" ")) {
                sb.append(MorseCode.get(letter));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

// 6kyu
// https://www.codewars.com/kata/decode-the-morse-code/train/java

/**
 * In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superceded by voice and digital data communication channels, it still has its use in some applications around the world.
 * The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 * <p>
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 * <p>
 * In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated as single special characters, and usually are transmitted as separate words.
 * <p>
 * Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
 * <p>
 * For example:
 * <p>
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
 * //should return "HEY JUDE"
 * NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.
 * <p>
 * The Morse code table is preloaded for you as a dictionary, feel free to use it:
 * <p>
 * Coffeescript/C++/Go/JavaScript/PHP/Python/Ruby/TypeScript: MORSE_CODE['.--']
 * C#: MorseCode.Get(".--") (returns string)
 * Elixir: morse_codes variable
 * Elm: MorseCodes.get : Dict String String
 * Haskell: morseCodes ! ".--" (Codes are in a Map String String)
 * Java: MorseCode.get(".--")
 * Kotlin: MorseCode[".--"] ?: "" or MorseCode.getOrDefault(".--", "")
 * Rust: self.morse_code
 * Scala: morseCodes(".--")
 * All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.
 * <p>
 * Good luck!
 */