import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] clouds) {
        int count = 0;
        for (int i = 0; i < clouds.length - 1; ) {
            if (safe(clouds, i + 2)) {
                i += 2;
            } else if (safe(clouds, i + 1)) {
                i += 1;
            } else {
                throw new IllegalStateException("It is not possible to win the game.");
            }
            count++;
        }
        return count;
    }

    private static boolean safe(int[] clouds, int i) {
        return i < clouds.length && clouds[i] == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);
    }
}
