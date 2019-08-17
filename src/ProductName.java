import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Link: https://www.hackerrank.com/contests/hackerrank-all-womens-codesprint-2019/challenges/name-the-product
public class ProductName {

    private static String pickName(int length, String[] names) {
        String name = "";
        for (int i = 0; i < length; i++) {
            Character[] letters = new Character[names.length];
            for (int j = 0; j < names.length; j++) {
                letters[j] = names[j].charAt(i);
            }
            name = name + pickLetter(letters);
        }
        return name;
    }

    private static char pickLetter(Character[] letters) {
        Map<Character, Long> counters = Stream.of(letters)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char letterMin = 'z';
        for (char letter = 'z'; letter >= 'a'; letter--) {
            if (counters.containsKey(letter)) {
                if (counters.get(letter) < counters.get(letterMin)) {
                    letterMin = letter;
                }
            } else {
                return letter;
            }
        }
        return letterMin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        scanner.close();

        String result = pickName(5, names);
        System.out.println(result);
    }
}
