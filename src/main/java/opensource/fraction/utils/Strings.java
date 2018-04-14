package opensource.fraction.utils;

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

}
