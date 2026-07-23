import java.util.*;

public class TwoDigitString {

    public static int lcs(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // Performs one reduction
    public static String reduce(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            int sum = ((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10;
            sb.append((char) (sum + '0'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] digits = new String[n][2];

        for (int i = 0; i < n; i++) {
            digits[i][0] = sc.next();
            digits[i][1] = sc.next();
        }

        // Reduce each string once
        for (int i = 0; i < n; i++) {
            digits[i][0] = reduce(digits[i][0]);
            digits[i][1] = reduce(digits[i][1]);
        }

        for (int i = 0; i < n; i++) {

            if (digits[i][0].charAt(digits[i][0].length() - 1)
                    == digits[i][1].charAt(digits[i][1].length() - 1)) {

                int res = lcs(digits[i][0], digits[i][1]);
                System.out.println(res);

            } else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}