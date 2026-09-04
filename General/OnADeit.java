import java.io.*;
import java.util.*;

public class OnADeit {
    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int[] L = new int[N];
        int total = 0;

        // Read lengths and find total length
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            total += L[i];
        }

        int left = 0;
        int answer = Integer.MAX_VALUE;

        // Try every notch
        for (int i = 0; i < N - 1; i++) {

            left += L[i];

            int right = total - left;

            int difference = Math.abs(left - right);

            answer = Math.min(answer, difference);
        }

        System.out.println(answer);
    }
}