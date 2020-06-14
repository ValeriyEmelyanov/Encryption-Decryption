import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int len = scanner.nextInt();
        final int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int counter = 1;
        int maxSeqLen = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] <= arr[i]) {
                counter++;
            } else {
                maxSeqLen = Math.max(counter, maxSeqLen);
                counter = 1;
            }
        }
        maxSeqLen = Math.max(counter, maxSeqLen);

        System.out.println(maxSeqLen);
    }
}