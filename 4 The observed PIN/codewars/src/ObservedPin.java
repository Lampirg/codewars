import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static final Map<Character, List<String>> ADJACENT =
            Map.of(
                    '1', Arrays.asList("1", "2", "4"),
                    '2', Arrays.asList("2", "1", "3", "5"),
                    '3', Arrays.asList("3", "2", "6"),
                    '4', Arrays.asList("4", "1", "5", "7"),
                    '5', Arrays.asList("5", "2", "4", "6", "8"),
                    '6', Arrays.asList("6", "3", "5", "9"),
                    '7', Arrays.asList("7", "4", "8"),
                    '8', Arrays.asList("8", "5", "7", "9", "0"),
                    '9', Arrays.asList("9", "6", "8"),
                    '0', Arrays.asList("0", "8")
            );

    public static List<String> getPINs(String observed) {
        List<List<String>> possible = getAllPossible(observed);
        return getCombinations(possible);
    }

    private static List<String> getCombinations(List<List<String>> possible) {
        if (possible.size() == 1) {
            return possible.get(0);
        }
        List<String> combinations = new ArrayList<>();
        for (String mainCombination : possible.get(0)) {
            for (String subCombination : getCombinations(possible.subList(1, possible.size()))) {
                combinations.add(mainCombination + subCombination);
            }
        }
        return combinations;
    }

    private static List<List<String>> getAllPossible(String observed) {
        List<List<String>> possible = new ArrayList<>();
        for (int i = 0; i < observed.length(); i++) {
            possible.add(ADJACENT.get(observed.charAt(i)));
        }
        return possible;
    }
}