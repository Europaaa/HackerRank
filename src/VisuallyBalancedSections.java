import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Link: https://www.hackerrank.com/contests/hackerrank-all-womens-codesprint-2019/challenges/visually-balanced-sections
public class VisuallyBalancedSections {

    private static int visuallyBalancedSections(List<Integer> colors) {
        // Consider only those visually balanced sections starting from the beginning of the array
        int counter = 0;

        int numOfColors = 0;
        Set<Integer> unbalancedColors = new HashSet<>();
        for (Integer color : colors) {
            if (unbalancedColors.contains(color)) {
                unbalancedColors.remove(color);
            } else {
                unbalancedColors.add(color);
            }
            numOfColors++;

            if (unbalancedColors.size() == numOfColors % 2) {
                counter++;
            }
        }

        // Recursively calculate other visually balanced sections
        if (colors.size() == 1) {
            return counter;
        }
        return counter + visuallyBalancedSections(colors.subList(1, colors.size()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        IntStream.range(0, t).forEach(tItr -> {
            int n = scanner.nextInt();

            List<Integer> colors = IntStream.range(0, n)
                    .mapToObj(i -> scanner.nextInt())
                    .collect(Collectors.toList());

            int result = visuallyBalancedSections(colors);
            System.out.println(result);
        });

        scanner.close();
    }
}
