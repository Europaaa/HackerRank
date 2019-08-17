import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] array, int rotation) {
        int length = array.length;

        int[] arrayRotated = new int[length];
        for (int i = 0; i < length; i++) {
            arrayRotated[i] = array[(rotation + i) % length];
        }
        return arrayRotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
