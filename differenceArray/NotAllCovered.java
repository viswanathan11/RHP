/**
 * NotAllCovered
*/

import java.util.*;

public class NotAllCovered {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();//Number of castles walls
        int M=sc.nextInt();//Number of turrets

        int[] walls=new int[N+2];//because of 1's index and prefix sum we do +1 and +1;

        Arrays.fill(walls,0);

        for(int i=0;i<M;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();

            walls[l]++;
            walls[r+1]--;
        }

        int res=Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            walls[i]+=walls[i-1];
            res=Integer.min(res,walls[i]);
        }

        System.out.println(res);
    }
    
}
