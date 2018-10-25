import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Link: https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {

    // Complete the twoStrings function below.
    static boolean twoStrings(String s1, String s2) {
        Set<Character> letters1 = initSet(s1);
        Set<Character> letters2 = initSet(s2);

        Set<Character> commonLetters = new HashSet<>(letters1);
        commonLetters.retainAll(letters2);
        return !commonLetters.isEmpty();
    }

    private static Set<Character> initSet(String s) {
        char[] chars = s.toCharArray();

        HashSet<Character> letters = new HashSet<>();
        for (char letter: chars) {
            letters.add(letter);
        }
        return letters;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2) ? "YES" : "NO";

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
