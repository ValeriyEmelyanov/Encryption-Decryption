import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        final String[] elements = input.split("-");

        System.out.println(String.format("%s/%s/%s", elements[1], elements[2], elements[0]));
    }
}