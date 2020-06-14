class AsciiCharSequence implements CharSequence {
    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));
    }

    @Override
    public String toString() {
        char[] chars = new char[bytes.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) bytes[i];
        }
        return String.valueOf(chars);
    }
}