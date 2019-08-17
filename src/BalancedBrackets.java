import java.util.Scanner;
import java.util.Stack;

// Link: https://www.hackerrank.com/challenges/balanced-brackets/problem
public class BalancedBrackets {

    // Complete the isBalanced function below.
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        char[] letters = s.toCharArray();
        for (char letter : letters) {
            if (isOpenBracket(letter)) {
                stack.push(letter);
            } else {
                if (stack.isEmpty() || !matches(stack.pop(), letter)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char letter) {
        switch (letter) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private static boolean matches(char openBracket, char closedBracket) {
        switch (openBracket) {
            case '(':
                return closedBracket == ')';
            case '{':
                return closedBracket == '}';
            case '[':
                return closedBracket == ']';
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            boolean result = isBalanced(s);
            System.out.println(result ? "YES" : "NO");
        }
        scanner.close();
    }
}
