import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KeyPadAdjacentCombinations {

    private static Set<String> generatePINVariations(String pin) {
        // Mapping of each digit to its possible adjacent digits
        String[][] keypad = {
                {"0", "8"}, // 0
                {"1", "2", "4"}, // 1
                {"1", "2", "3", "5"}, // 2
                {"2", "3", "6"}, // 3
                {"1", "4", "5", "7"}, // 4
                {"2", "4", "5", "6", "8"}, // 5
                {"3", "5", "6", "9"}, // 6
                {"4", "7", "8"}, // 7
                {"5", "7", "8", "9", "0"}, // 8
                {"6", "8", "9"}  // 9
        };

        return getCombinations(pin, keypad, 0, "");
    }

    private static Set<String> getCombinations(String pin, String[][] keypad, int index, String currentCombination) {
        if (index == pin.length()) {
            Set<String> result = new HashSet<>();
            result.add(currentCombination);
            return result;
        }

        int digit = Character.getNumericValue(pin.charAt(index));
        Set<String> combinations = new HashSet<>();
        for (String adj : keypad[digit]) {
            combinations.addAll(getCombinations(pin, keypad, index + 1, currentCombination + adj));
        }
        return combinations;
    }

    public static void main(String[] args) {
        String pin = "1357";
        Set<String> variations = generatePINVariations(pin);
        List<String> sortedVariations = new ArrayList<>(variations);
        Collections.sort(sortedVariations);
        System.out.println(sortedVariations);
    }
}

