import java.util.Arrays;
import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] manipulations) {
        long[] array = initArray(n + 1);

        for (int i = 0; i < manipulations.length; i++) {
            int iStart = manipulations[i][0];
            int iEnd = manipulations[i][1];
            int delta = manipulations[i][2];

            array[iStart - 1] += delta;
            array[iEnd] -= delta;
        }
        return findMax(array);
    }

    private static long[] initArray(int n) {
        long[] array = new long[n];
        Arrays.fill(array, 0);
        return array;
    }

    private static long findMax(long[] array) {
        long current = 0;
        long max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            current += array[i];
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        scanner.close();

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
