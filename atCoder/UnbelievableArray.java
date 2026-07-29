import java.io.*;
import java.util.*;

public class UnbelievableArray {

    static HashMap<Integer, Integer> vlm = new HashMap<>(); // value -> leader index currently holding it
    static HashMap<Integer, Integer> lvm = new HashMap<>(); // leader index -> value it currently represents

    static int find(int[] ldr, int node) {
        int root = node;
        while (ldr[root] != root) root = ldr[root];
        while (ldr[node] != root) {
            int next = ldr[node];
            ldr[node] = root;
            node = next;
        }
        return root;
    }

    static void join(int[] ldr, int lt, int rt) {
        int leader1 = find(ldr, lt);
        int leader2 = find(ldr, rt);
        if (leader1 != leader2) {
            ldr[leader2] = leader1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        StringBuilder sb = new StringBuilder();

        st.nextToken();
        int T = (int) st.nval;

        for (int tc = 1; tc <= T; tc++) {
            vlm.clear();
            lvm.clear();

            st.nextToken(); int N = (int) st.nval;
            st.nextToken(); int Q = (int) st.nval;

            int[] arr = new int[N + 1];
            int[] ldr = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st.nextToken();
                arr[i] = (int) st.nval;
                ldr[i] = i;

                if (!vlm.containsKey(arr[i])) {
                    vlm.put(arr[i], i);
                    lvm.put(i, arr[i]);
                } else {
                    int leader1 = vlm.get(arr[i]);
                    join(ldr, leader1, i);
                }
            }

            sb.append("Case ").append(tc).append(":\n");

            for (int i = 0; i < Q; i++) {
                st.nextToken();
                int op = (int) st.nval;
                st.nextToken();
                int r1 = (int) st.nval;

                if (op == 1) {
                    st.nextToken();
                    int r2 = (int) st.nval;

                    if (r1 != r2 && vlm.containsKey(r1)) {
                        int leaderX = vlm.get(r1);
                        vlm.remove(r1);

                        if (!vlm.containsKey(r2)) {
                            vlm.put(r2, leaderX);
                            lvm.put(leaderX, r2);
                        } else {
                            int leaderY = vlm.get(r2);
                            join(ldr, leaderY, leaderX);
                            lvm.remove(leaderX);
                        }
                    }
                } else {
                    int root = find(ldr, r1);
                    sb.append(lvm.get(root)).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}