import java.io.*;
import java.util.*;

public class CoefficientChair {

    static int N, K;
    static int[] A;
    static StringBuilder out = new StringBuilder();

    static void dfs(int pos, int remaining) {

        // Last element
        if (pos == N) {
            if (remaining % N == 0) {
                A[pos - 1] = remaining / N;
                print();
            }
            return;
        }

        // Try smaller values first
        for (int x = 0; pos * x <= remaining; x++) {
            A[pos - 1] = x;

            dfs(pos + 1, remaining - pos * x);
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            if (i > 0) out.append(' ');
            out.append(A[i]);
        }
        out.append('\n');
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];

        dfs(1, K);

        System.out.print(out);
    }
}