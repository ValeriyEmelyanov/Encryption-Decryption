import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();
        String[] words = line.split("\\s");

        String maxWord = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > maxWord.length()) {
                maxWord = words[i];
            }
        }

        System.out.println(maxWord);
    }
}