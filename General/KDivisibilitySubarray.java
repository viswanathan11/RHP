import java.io.*;
import java.util.*;

public class KDivisibilitySubarray{
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Long, Long> map = new HashMap<>();

        long prefix = 0;
        long answer = 0;

        // Empty prefix
        map.put(0L, 1L);

        for (int i = 0; i < N; i++) {

            long x = Long.parseLong(st.nextToken());

            prefix += x;

            long remainder = prefix % K;

            // Handle negative values
            if (remainder < 0) {
                remainder += K;
            }

            // Previous prefix sums with same remainder
            if (map.containsKey(remainder)) {
                answer += map.get(remainder);
            }

            // Add current prefix
            map.put(remainder,
                    map.getOrDefault(remainder, 0L) + 1);
        }

        System.out.println(answer);
    }
}