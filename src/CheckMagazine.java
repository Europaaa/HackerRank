import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

// Link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class CheckMagazine {

    // Complete the checkMagazine function below.
    static boolean checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> magazineWords = countWords(magazine);
        Map<String, Long> noteWords = countWords(note);

        return noteWords.entrySet().stream()
                .allMatch(noteWord -> magazineWords.getOrDefault(noteWord.getKey(), 0l) >= noteWord.getValue());
    }

    private static Map<String, Long> countWords(String[] magazine) {
        return Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        if (checkMagazine(magazine, note)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
