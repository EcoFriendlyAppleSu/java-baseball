package baseball.infrastructure.util;

import baseball.domain.ConsoleInString;
import baseball.infrastructure.message.ConsoleOut;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GamerInputNumberGenerator {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static List<Integer> generator(ConsoleInString consoleInString) {
        System.out.print(ConsoleOut.INPUT_NUMBER_MESSAGE);
        String generatedString = consoleInString.inputString();
        if (!stringValidation(generatedString)) {
            throw new IllegalArgumentException();
        }

        String[] stringArray = splitString(generatedString);

        return stringToListNumber(stringArray);
    }

    private static List<Integer> stringToListNumber(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).boxed()
            .collect(Collectors.toList());
    }

    private static boolean stringValidation(String stringNumbers) {
        if (stringNumbers == null) {
            return false;
        }
        return pattern.matcher(stringNumbers).matches();
    }

    private static String[] splitString(String stringNumber) {
        return stringNumber.split("");
    }
}
