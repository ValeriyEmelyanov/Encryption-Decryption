import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        char[] chars = input.toCharArray();
        char[] doubleChars = new char[chars.length * 2];
        int index = 0;
        for (char c : chars) {
            doubleChars[index++] = c;
            doubleChars[index++] = c;
        }

        System.out.println(new String(doubleChars));
    }
}