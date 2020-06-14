import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String input;
        while (!"0".equals(input = scanner.nextLine())) {
            try {
                int num = Integer.parseInt(input);
                stringBuilder.append(num * 10).append(";");
            } catch (NumberFormatException e) {
                stringBuilder.append(String.format("Invalid user input: %s;", input));
            }
        }

        String[] lines = stringBuilder.toString().split(";");
        Arrays.stream(lines).filter(s -> !s.isEmpty()).forEach(System.out::println);
    }
}