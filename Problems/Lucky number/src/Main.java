import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        if (isNumber(input)) {
            System.out.println(isLucky(input) ? "YES" : "NO");
        } else {
            System.out.println("Invalid input");
        }
    }

    private static boolean isNumber(String input) {
        final char[] digits = "1234567890".toCharArray();
        Arrays.sort(digits);

        final char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Arrays.binarySearch(digits, c) < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLucky(String input) {
        int len = input.length();
        String left = input.substring(0, len / 2);
        String right = input.substring(len / 2, len);
        return sum(left) == sum(right);
    }

    private static int sum(String digitsSeq) {
        String[] digits = digitsSeq.split("");
        int sum = 0;
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }
}