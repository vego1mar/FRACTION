package pl.fraction.utils;

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

    @Contract(pure = true)
    public static char[] get(int length, char initializer) {
        char[] variable = new char[length];

        for (int i = 0; i < variable.length; i++) {
            variable[i] = initializer;
        }

        return variable;
    }

}
