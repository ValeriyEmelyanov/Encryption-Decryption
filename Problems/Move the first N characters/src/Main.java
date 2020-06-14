import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split("\\s");
        String str = words[0];
        int num = Integer.parseInt(words[1]);

        String result;
        if (num >= str.length()) {
            result = str;
        } else {
            result = str.substring(num) + str.substring(0, num);
        }

        System.out.println(result);
    }
}