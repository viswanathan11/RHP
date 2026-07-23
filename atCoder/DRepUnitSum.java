package atCoder;

/**
 * DRepUnitSum
 */

import java.util.*;
import java.util.*;

public class DRepUnitSum {

    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            max = Math.max(max, A[i]);
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        long carry = 0;

        for (int pos = 0; pos < max; pos++) {

            int idx = lowerBound(A, pos + 1);
            long cnt = N - idx;

            long cur = cnt + carry;

            sb.append(cur % 10);

            carry = cur / 10;
        }

        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;
        }

        System.out.println(sb.reverse());
    }
}