package calculator;

public class CheckErrors {
    static boolean check(String text) {
        if (text.charAt(text.length() - 1) == '\u002B' ||
                text.charAt(text.length() - 1) == '-' ||
                text.charAt(text.length() - 1) == '\u00D7' ||
                text.charAt(text.length() - 1) == '\u00F7') {
            return true;
        }
        if (text.contains("\u00F70") && !text.contains("\u00F70.")) {
            return true;
        }
        return false;
    }
}
