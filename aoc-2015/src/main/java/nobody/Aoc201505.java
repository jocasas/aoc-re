package nobody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Aoc201505 {
    public static void main(String[] args) throws IOException {
        //params
        var str = new String(Files.readAllBytes(Paths.get("aoc-2015/strings.txt")));
        String[] lines = str.split("\\n");
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u'); // array list
        List<String> strings = Arrays.asList("ab", "cd", "pq", "xy"); // array list
        int niceStrings = 0;

        //code
        for (String line : lines) {

            //refactored methods
            int vowelCount = countLineVowels(line, vowels);
            int twiceInRow = checkTwiceInRow(line);
            int contains = checkPattern(line, strings);

            if (vowelCount >= 3 && twiceInRow == 1 && contains == 0) {
                niceStrings++;
            }
        }
        System.out.println("Nicestringgs First Method: " + niceStrings);
        System.out.println("Nicestringgs Second Method: " + niceStrings);
    }

    private static int countLineVowels(String line, List<Character> vowels) {
        int vowelCount = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (vowels.contains(ch)) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    private static int checkTwiceInRow(String line) {
        int twiceInRow = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            char ch = line.charAt(i);
            if (ch == line.charAt(i + 1)) {
                twiceInRow = 1;
                break;
            }
        }
        return twiceInRow;
    }

    private static int checkPattern(String line, List<String> strings) {
        int contains = 0;
        for (String string : strings) {
            if (line.contains(string)) {
                contains = 1;
                break;
            }
        }
        return contains;
    }
}
