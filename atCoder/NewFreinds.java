import java.util.*;
public class NewFreinds {

    public static long getCombinationCount(int n, int r) {
    if (r < 0 || r > n) return 0;
    if (r == 0 || r == n) return 1;
    
    // Optimize using symmetry: nCr(n, r) == nCr(n, n - r)
    if (r > n - r) {
        r = n - r;
    }
    long result = 1;
    for (int i = 1; i <= r; i++) {
        result *= (n - r + i);
        result /= i;
    }
    return result;
}
    static int find(int[] leaders,int node){
        if(leaders[node]!=node){
            leaders[node]=find(leaders, leaders[node]);
        }

        return leaders[node];
    }

    static void join(int[] leaders,int lt,int rt){
        int leader1=find(leaders, lt);
        int leader2=find(leaders, rt);

        if(leader1!=leader2){
            leaders[leader2]=leader1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int R=sc.nextInt();
        int[] leaders=new int[N+1];
        int[] groupCount=new int[N+1];
        int[] edgeCount=new int[N+1];
        int[][] relation=new int[R][2];
        for(int i=1;i<=N;i++)leaders[i]=i;

        for(int i=0;i<R;i++){
            int lt=sc.nextInt();
            relation[i][0]=lt;
            int rt=sc.nextInt();
            join(leaders,lt,rt);
            relation[i][1]=rt;
        }

        for(int i=1;i<=N;i++){
            groupCount[find(leaders,i)]++;
        }

        for(int i=0;i<R;i++){
            edgeCount[find(leaders,relation[i][0])]++;
        }

        long count=0;
        long t1=0;
        for(int i=1;i<=N;i++){
            if(groupCount[i]!=0){
            t1=getCombinationCount(groupCount[i],2);
            count+=t1-edgeCount[i];
            }
        }


        System.out.println(count);
        sc.close();
    }
}
