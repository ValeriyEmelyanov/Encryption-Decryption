import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int len = scanner.nextInt();
        final int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int num = scanner.nextInt();

        int sum = 0;
        for (int value : arr) {
            if (value > num) {
                sum += value;
            }
        }

        System.out.println(sum);
    }
}