import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/2d-array/problem
public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] array) {
        Integer maxSum = null;
        for (int y = 0; y < array.length - 2; y++) {
            for (int x = 0; x < array[y].length - 2; x++) {
                int sum = hourglassSum(array, x, y);
                if (maxSum == null || maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    private static int hourglassSum(int[][] array, int x, int y) {
        return array[y][x] + array[y][x + 1] + array[y][x + 2]
                + array[y + 1][x + 1]
                + array[y + 2][x] + array[y + 2][x + 1] + array[y + 2][x + 2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
