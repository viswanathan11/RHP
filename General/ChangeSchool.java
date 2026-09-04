import java.io.*;
import java.util.*;

public class ChangeSchool {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] count = new int[K + 1];

        st = new StringTokenizer(br.readLine());

        // Count students in each class
        for (int i = 0; i < N; i++) {
            int classNo = Integer.parseInt(st.nextToken());
            count[classNo]++;
        }

        // Find maximum number of students in a class
        int max = 0;

        for (int i = 1; i <= K; i++) {
            max = Math.max(max, count[i]);
        }

        // Count classes having the maximum number of students
        int answer = 0;

        for (int i = 1; i <= K; i++) {
            if (count[i] == max) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
