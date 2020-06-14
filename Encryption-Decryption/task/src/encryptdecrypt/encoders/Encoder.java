package encryptdecrypt.encoders;

public abstract class Encoder {
    public String encode(String str, int key) {
        return convertString(str, key, true);
    }

    public String decode(String str, int key) {
        return convertString(str, key, false);
    }

    private String convertString(String str, int key, boolean isEncoding) {
        if (str.isEmpty()) {
            return str;
        }

        char[] inChars = str.toCharArray();
        char[] outChars = new char[inChars.length];
        int shift = calculateShift(key, isEncoding);

        for (int i = 0; i < inChars.length; i++) {
            outChars[i] = convertChar(inChars[i], shift);
        }

        return String.valueOf(outChars);
    }

    protected abstract int calculateShift(int key, boolean isEncoding);

    protected abstract char convertChar(char inChar, int shift);

}
