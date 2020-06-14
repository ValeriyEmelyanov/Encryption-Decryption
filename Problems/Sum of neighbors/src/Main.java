import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        List<String> lines = readInput();
        int[][] arr = convertToIntArr(lines);
        int[][] result = calc(arr);
        print(result);
    }

    private static List<String> readInput() {
        final Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        String line;
        while (!"end".equals(line = scanner.nextLine())) {
            lines.add(line);
        }
        scanner.close();
        return lines;
    }

    private static int[][] convertToIntArr(List<String> lines) {
        int[][] arr = new int[lines.size()][];
        for (int i = 0; i < arr.length; i++) {
            String[] nums = lines.get(i).split("\\s");
            arr[i] = new int[nums.length];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return arr;
    }

    private static int[][] calc(int[][] arr) {
        final int height = arr.length;
        final int width = arr[0].length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = arr[i <= 0 ? height - 1 : i - 1][j]
                        + arr[i >= height - 1 ? 0 : i + 1][j]
                        + arr[i][j <= 0 ? width - 1 : j - 1]
                        + arr[i][j >= width - 1 ? 0 : j + 1];
            }
        }
        return result;
    }

    private static void print(int[][] result) {
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}