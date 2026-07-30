import java.util.*;

public class EWrappingChocolate {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int A[] =new int[N+1];
        int B[] =new int[N+1];
        int C[] =new int[M+1];
        int D[] =new int[M+1];

        for(int i=0;i<N;i++) A[i]=sc.nextInt();
        
        for(int i=0;i<N;i++) B[i]=sc.nextInt();
        
        for(int i=0;i<M;i++) C[i]=sc.nextInt();
        
        for(int i=0;i<M;i++) D[i]=sc.nextInt();

        if (N > M) {
            System.out.println("No");
            return;
        }


        int[][] items = new int[N + M][3];
        for (int i = 0; i < N; i++) {
            items[i][0] = A[i];
            items[i][1] = B[i];
            items[i][2] = 1; 
        }
        for (int i = 0; i < M; i++) {
            items[N + i][0] = C[i];
            items[N + i][1] = D[i];
            items[N + i][2] = 0; 
        }
        Arrays.sort(items, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(y[0], x[0]);
            }
            return Integer.compare(x[2], y[2]);
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] item : items) {
            int h = item[1];
            int type = item[2];

            if (type == 0) {
                map.put(h, map.getOrDefault(h, 0) + 1);
            } else {
                Integer key = map.ceilingKey(h);
                if (key == null) {
                    System.out.println("No");
                    return;
                }
                int count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }
        System.out.println("Yes");
    }
}


