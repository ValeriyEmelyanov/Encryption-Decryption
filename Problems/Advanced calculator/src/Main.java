import java.util.Arrays;
import java.util.stream.IntStream;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
            int[] array = Arrays.stream(args, 1, args.length).mapToInt(Integer::parseInt).toArray();

        int result;
        switch (operator) {
            case "MAX":
                result = IntStream.of(array).max().orElseThrow();
                break;
            case "MIN":
                result = IntStream.of(array).min().orElseThrow();
                break;
            case "SUM":
                result = IntStream.of(array).sum();
                break;
            default:
                System.out.println("Unknown operator!");
                return;
        }

        System.out.println(result);
    }
}