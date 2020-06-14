import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int len = scanner.nextInt();
        final int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(check(arr, num1, num2));
    }

    private static boolean check(int[] arr, int num1, int num2) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == num1 && arr[i + 1] == num2
                    || arr[i] == num2 && arr[i + 1] == num1) {
                return false;
            }
        }
        return true;
    }
}