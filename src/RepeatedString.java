import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Link: https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long repetition = n / s.length();
        long length = n % s.length();
        return countLowerA(s.substring(0, (int) length)) + countLowerA(s) * repetition;
    }

    private static long countLowerA(String s) {
        char[] letters = s.toCharArray();

        long count = 0;
        for (char letter : letters) {
            if (letter == 'a') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        long result = repeatedString(s, n);
        System.out.println(result);
    }
}
