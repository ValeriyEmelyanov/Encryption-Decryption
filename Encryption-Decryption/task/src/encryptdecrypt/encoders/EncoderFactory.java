package encryptdecrypt.encoders;

public class EncoderFactory {
    public static Encoder newInstance(String algorithm) {
        if (algorithm == null || algorithm.isEmpty()) {
            return new ShiftEncoder();
        }
        switch (algorithm.toLowerCase()) {
            case "shift":
                return new ShiftEncoder();
            case "unicode":
                return new UnicodeEncoder();
            default:
                throw new IllegalArgumentException("Invalid algorithm!");
        }
    }
}
