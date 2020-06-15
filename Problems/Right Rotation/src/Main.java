import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] array = Stream.of(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int numberOfRotations = scanner.nextInt();
        scanner.close();

        int[] roteted = rotate(array, numberOfRotations);

        Arrays.stream(roteted).forEach(i -> System.out.print(i + " "));
    }

    private static int[] rotate(int[] array, int numberOfRotations) {
        final int len = array.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[(i + numberOfRotations) % len] = array[i];
        }
        return result;
    }
}