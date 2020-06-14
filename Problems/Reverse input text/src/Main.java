import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int len = 50;
        char[] data = new char[len];
        int realLen = reader.read(data);
        realLen = data[realLen - 1] == '\n' ? realLen - 1 : realLen;
        reader.close();

        char[] reversed = new char[realLen];
        for (int i = 0; i < realLen; i++) {
            reversed[realLen - 1 - i] = data[i];
        }

        for (char c : reversed) {
            System.out.print(c);
        }
    }
}