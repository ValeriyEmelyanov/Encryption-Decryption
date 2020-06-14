import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine().trim();
        reader.close();

        int result = 0;
        if (!data.isEmpty()) {
            result = data.split("\\s+").length;
        }

        System.out.println(result);
    }
}