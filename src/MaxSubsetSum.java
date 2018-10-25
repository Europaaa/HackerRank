import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/max-array-sum/problem
public class MaxSubsetSum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] array) {
        int[] sums = subsetSums(array);
        return sums[sums.length - 1];
    }

    private static int[] subsetSums(int[] array) {
        int[] sums = new int[array.length];
        sums[0] = array[0];
        sums[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            int sum1 = array[i];
            int sum2 = sums[i - 2] + array[i];
            int sum3 = sums[i - 1];

            sums[i] = Math.max(Math.max(sum1, sum2), sum3);
        }
        return sums;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
