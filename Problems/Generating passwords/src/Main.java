import java.util.*;

public class Main {
    private static final Random RND = new Random();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int uppersLen = scanner.nextInt();
        final int lowersLen = scanner.nextInt();
        final int digitsLen = scanner.nextInt();
        final int pwdLen = scanner.nextInt();

        System.out.println(getPassword(uppersLen, lowersLen, digitsLen, pwdLen));
    }

    private static String getPassword(int uppersLen, int lowersLen, int digitsLen, int pwdLen) {
        final char[] uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] digits = "1234567890".toCharArray();

        char[] pwd = new char[pwdLen];
        char[] currentSeq;
        int pwdCounter = 0;

        while (pwdCounter < pwdLen) {
            if (pwdCounter < uppersLen) {
                currentSeq = uppers;
            } else if (pwdCounter < uppersLen + lowersLen) {
                currentSeq = lowers;
            } else if (pwdCounter < uppersLen + lowersLen + digitsLen) {
                currentSeq = digits;
            } else {
                currentSeq = uppers;
            }
            if (nextChar(pwd, pwdCounter, currentSeq)) {
                pwdCounter++;
            }
        }

        return String.valueOf(pwd);
    }

    private static boolean nextChar(char[] pwd, int pwdInd, char[] charsSeq) {
        pwd[pwdInd] = charsSeq[RND.nextInt(charsSeq.length)];
        return !((pwdInd > 0 && pwd[pwdInd - 1] == pwd[pwdInd]));
    }
}