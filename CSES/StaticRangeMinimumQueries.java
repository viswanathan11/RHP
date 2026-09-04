import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeMinimumQueries {
    public static void main(String[] args) throws IOException {
        FastReader io = new FastReader();
        
        int n = io.nextInt();
        int q = io.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.nextInt();
        }
        
        // Compute the maximum power of 2 needed
        int maxLog = 31 - Integer.numberOfLeadingZeros(n);
        int[][] st = new int[n][maxLog + 1];
        
        // Base case: intervals of length 1 (2^0)
        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i];
        }
        
        // Build the Sparse Table
        for (int j = 1; j <= maxLog; j++) {
            int length = 1 << (j - 1);
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + length][j - 1]);
            }
        }
        
        // Precompute logs for O(1) query time efficiency
        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        // Process queries
        for (int i = 0; i < q; i++) {
            // CSES queries are 1-indexed
            int l = io.nextInt() - 1;
            int r = io.nextInt() - 1;
            
            int k = logTable[r - l + 1];
            int minimum = Math.min(st[l][k], st[r - (1 << k) + 1][k]);
            
            sb.append(minimum).append("\n");
        }
        
        System.out.print(sb);
    }
    
    // Fast I/O Utility
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
