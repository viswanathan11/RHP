import java.io.*;
import java.util.*;

/**
 * coffeeWIthKaren
 * Codeforces: Karen and Coffee
 * Find admissible temperatures (recommended by at least k recipes) in given ranges
 */
public class coffeeWIthKaren {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        // Difference array to count recipes recommending each temperature
        int[] diff = new int[200002];
        
        // Read recipes and update difference array
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            diff[l]++;
            diff[r + 1]--;
        }
        
        // Convert difference array to actual counts using prefix sum
        int[] count = new int[200001];
        int current = 0;
        for (int i = 1; i <= 200000; i++) {
            current += diff[i];
            count[i] = current;
        }
        
        // Create prefix sum array of admissible temperatures
        int[] prefix = new int[200001];
        for (int i = 1; i <= 200000; i++) {
            prefix[i] = prefix[i - 1];
            if (count[i] >= k) {
                prefix[i]++;
            }
        }
        
        // Answer queries
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = prefix[b] - prefix[a - 1];
            System.out.println(answer);
        }
    }
}