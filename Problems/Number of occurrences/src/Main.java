import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String str = scanner.nextLine();
        final String sub = scanner.nextLine();


        int fromIndex = 0;
        int counter = 0;
        while (fromIndex > -1) {
            fromIndex = str.indexOf(sub, fromIndex);
            if (fromIndex > -1) {
                counter++;
                fromIndex += sub.length();
            }
        }

        System.out.println(counter);
    }
}