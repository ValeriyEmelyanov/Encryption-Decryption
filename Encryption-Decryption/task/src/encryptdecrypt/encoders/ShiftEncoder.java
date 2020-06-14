package encryptdecrypt.encoders;

public class ShiftEncoder extends Encoder {
    private static final char SMALL_A = 'a';
    private static final char SMALL_Z = 'z';
    private static final char CAPITAL_A = 'A';
    private static final char CAPITAL_Z = 'Z';
    private static final int DEVIDER = SMALL_Z - SMALL_A + 1;

    @Override
    protected int calculateShift(int key, boolean isEncoding) {
        int shift = key % DEVIDER * (isEncoding ? 1 : -1);
        if (shift < 0) {
            shift = (DEVIDER + shift);
        }
        return shift;
    }

    @Override
    protected char convertChar(char inChar, int shift) {
        int basic = 0;
        if (inChar >= SMALL_A && inChar <= SMALL_Z) {
            basic = SMALL_A;
        } else if (inChar >= CAPITAL_A && inChar <= CAPITAL_Z) {
            basic = CAPITAL_A;
        } else {
            return inChar;
        }
        return (char) ((inChar - basic + shift) % DEVIDER + basic);
    }

}
