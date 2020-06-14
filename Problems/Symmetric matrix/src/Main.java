import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[][] arr = inputArray();
        System.out.println(check(arr) ? "YES" : "NO");
    }

    private static int[][] inputArray() {
        final Scanner scanner = new Scanner(System.in);
        final int len = scanner.nextInt();
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    private static boolean check(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}