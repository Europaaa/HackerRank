import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

// Link: https://www.hackerrank.com/challenges/sock-merchant/problem
public class SockMerchant {

    // Complete the sockMerchant function below.
    static long sockMerchant(int n, int[] colors) {
        // Group socks by colors
        Map<Integer, Long> colorCounts = Arrays.stream(colors).mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Sum pair counts by colors
        return colorCounts.values().stream().mapToLong(count -> count / 2).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        long result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
