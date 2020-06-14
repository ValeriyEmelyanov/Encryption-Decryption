package encryptdecrypt.encoders;

public class UnicodeEncoder extends Encoder {

    @Override
    protected int calculateShift(int key, boolean isEncoding) {
        return key * (isEncoding ? 1 : -1);
    }

    @Override
    protected char convertChar(char inChar, int key) {
        return (char) (inChar + key);
    }

}
