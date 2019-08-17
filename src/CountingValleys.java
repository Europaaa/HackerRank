import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String path) {
        char[] steps = path.toCharArray();

        int count = 0;
        for (int i = 0, elevation = 0; i < steps.length; i++) {
            int elevationNew = elevation + elevationChange(steps[i]);
            // We are entering a valley only when the current elevation is 0 and new elevation is below 0
            if (elevation == 0 && elevationNew < 0) {
                count++;
            }
            elevation = elevationNew;
        }
        return count;
    }

    private static int elevationChange(char step) {
        switch (step) {
            case 'U':
                return 1;
            case 'D':
                return -1;
            default:
                throw new IllegalArgumentException("Unknown step type.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        scanner.close();

        int result = countingValleys(n, s);
        System.out.println(result);
    }
}
