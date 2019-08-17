import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/contests/hackerrank-all-womens-codesprint-2019/challenges/alpha-and-beta
public class AlphaBeta {

    private static int alphaBeta(int[] piles) {
        int maxCoin = 0;
        int secondMaxCoin = 1;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxCoin) {
                secondMaxCoin = maxCoin;
                maxCoin = piles[i];
            } else if (piles[i] != maxCoin && piles[i] > secondMaxCoin) {
                secondMaxCoin = piles[i];
            }
        }

        return secondMaxCoin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }

        scanner.close();

        int result = alphaBeta(piles);
        System.out.println(result);
    }
}
