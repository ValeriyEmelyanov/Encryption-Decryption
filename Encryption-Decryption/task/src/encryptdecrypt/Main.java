package encryptdecrypt;

import encryptdecrypt.encoders.Encoder;
import encryptdecrypt.encoders.EncoderFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    private static final String KEY_MODE = "-mode";
    private static final String KEY_KEY = "-key";
    private static final String KEY_DATA = "-data";
    private static final String KEY_IN = "-in";
    private static final String KEY_OUT = "-out";
    private static final String KEY_ALG = "-alg";
    private static final String[] keys = {KEY_MODE, KEY_KEY, KEY_DATA, KEY_IN, KEY_OUT, KEY_ALG};
    private static final String OPERATOR_ENC = "enc";
    private static final String OPERATOR_DEC = "dec";
    private static final String ALG_SHIFT = "shift";
    private static final String ALG_UNICODE = "unicode";

    private static String operator = OPERATOR_ENC;
    private static String algorithm = ALG_SHIFT;
    private static int key = 0;
    private static String data = "";
    private static String in = null;
    private static String out = null;

    public static void main(String[] args) {

        if (!processArgs(args) || !processData()) {
            return;
        }

        String encoded = processOperator();

        if (out != null) {
            writeToFile(encoded);
        } else {
            System.out.println(encoded);
        }
    }

    private static boolean processArgs(String[] args) {
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case KEY_MODE:
                    if (nextArgIsValue(args, i)) {
                        operator = args[++i];
                        if (!OPERATOR_ENC.equals(operator) && !OPERATOR_DEC.equals(operator)) {
                            System.out.println("Error: invalid operator!");
                            return false;
                        }
                    }
                    break;
                case KEY_KEY:
                    if (nextArgIsValue(args, i)) {
                        if (isNumber(args[++i])) {
                            key = Integer.parseInt(args[i]);
                        } else {
                            System.out.println("Error: key is not integer number!");
                            return false;
                        }
                    }
                    break;
                case KEY_DATA:
                    if (nextArgIsValue(args, i)) {
                        data = args[++i];
                    }
                    break;
                case KEY_IN:
                    if (nextArgIsValue(args, i)) {
                        in = args[++i];
                    }
                    break;
                case KEY_OUT:
                    if (nextArgIsValue(args, i)) {
                        out = args[++i];
                    }
                    break;
                case KEY_ALG:
                    if (nextArgIsValue(args, i)) {
                        algorithm = args[++i];
                    }
                    break;
                default:
                    System.out.println("Error: unknown situation!");
                    return false;
            }
            i++;
        }
        return true;
    }

    private static boolean nextArgIsValue(String[] args, int i) {
        if (i + 1 >= args.length) {
            return false;
        }
        for (String s : keys) {
            if (s.equals(args[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(String arg) {
        if (arg == null || arg.isEmpty()) {
            return false;
        }

        final char[] digits = "0123456789".toCharArray();
        for (char c : arg.toCharArray()) {
            if (Arrays.binarySearch(digits, c) < 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean processData() {
        if (data.isEmpty() && in != null) {
            try {
                data = new String(Files.readAllBytes(Paths.get(in)));
            } catch (IOException e) {
                System.out.println("Error: file reading error!");
                return false;
            }
        }
        return true;
    }

    private static String processOperator() {
        Encoder encoder = EncoderFactory.newInstance(algorithm);
        if (OPERATOR_ENC.equals(operator)) {
            return encoder.encode(data, key);
        } else {
            return encoder.decode(data, key);
        }
    }

    private static void writeToFile(String text) {
        File file = new File(out);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
