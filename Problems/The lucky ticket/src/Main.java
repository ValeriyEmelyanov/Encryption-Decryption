import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        char[] chars = input.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < 3) {
                left += Character.getNumericValue(chars[i]);
            } else {
                right += Character.getNumericValue(chars[i]);
            }
        }

        System.out.println(left == right ? "Lucky" : "Regular");
    }
}