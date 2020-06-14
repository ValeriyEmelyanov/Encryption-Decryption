import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        final int lf = 10;
        int data;
        while ((data = inputStream.read()) > 0 && data != lf) {
            System.out.print(data);
        }
        inputStream.close();
    }
}