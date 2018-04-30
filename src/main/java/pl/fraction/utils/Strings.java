package pl.fraction.utils;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Strings {

    private Strings() {
        // This should be a utility class.
    }

    public static boolean isSimpleNumeric(@NotNull String string) {
        for (char character : string.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isZeroed(@NotNull String string) {
        for (char character : string.toCharArray()) {
            if (character != '0') {
                return false;
            }
        }

        return true;
    }

    @Contract(pure = true) public static char[] getArray(int length, char initializer) {
        char[] variable = new char[length];

        for (int i = 0; i < variable.length; i++) {
            variable[i] = initializer;
        }

        return variable;
    }

    @NotNull public static String getString(int length, char initializer) {
        return new String(getArray(length, initializer));
    }

    public static int getIndexOfLastLeadingZero(@NotNull String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            if (!Character.isDigit(string.toCharArray()[i]) || string.toCharArray()[i] != '0') {
                break;
            }

            if (string.toCharArray()[i] == '0' && string.toCharArray()[i + 1] != '0') {
                return i;
            }
        }

        return -1;
    }

    @NotNull public static String getWithoutLeadingZeroes(@NotNull String string) {
        if (isZeroed(string)) {
            return "";
        }

        return string.substring(getIndexOfLastLeadingZero(string) + 1);
    }

    public static List<String> getShortenedNumbers(@NotNull List<StringBuilder> digitsOnlyList) {
        List<String> shortenedList = new ArrayList<>();

        for (StringBuilder builder : digitsOnlyList) {
            shortenedList.add(getWithoutLeadingZeroes(builder.toString()));
        }

        return shortenedList;
    }

}
