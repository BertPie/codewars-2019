package pl.piesniak.kyu6.morsecode;

public class MorseCode {

    public static String get(String s) {
        switch (s) {
            case "....":
                return "H";
            case ".":
                return "E";
            case "-.--":
                return "Y";
            case ".---":
                return "J";
            case "..-":
                return "U";
            case "-..":
                return "D";
            default:
                return "--THIS SHOULD NOT BE RETURNED--";
        }
    }
}
