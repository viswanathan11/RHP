import java.io.*;
import java.util.*;

public class program6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        // Store indices whose value is greater than 0
        ArrayList<Integer> positive = new ArrayList<>();

        int ans = 0;

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken()) - 1;

                // If A[x] is 0, it becomes positive
                if (A[x] == 0) {
                    positive.add(x);
                }

                // Remove old value from XOR
                ans ^= A[x];

                // Increase
                A[x]++;

                // Add new value to XOR
                ans ^= A[x];

            } else {
                ArrayList<Integer> newPositive = new ArrayList<>();

                for (int x : positive) {

                    // Remove old value
                    ans ^= A[x];

                    // Decrease
                    A[x]--;

                    // Add new value
                    ans ^= A[x];

                    // Still positive
                    if (A[x] > 0) {
                        newPositive.add(x);
                    }
                }

                positive = newPositive;
            }

            System.out.println(ans);
        }
    }
}