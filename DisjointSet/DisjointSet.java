import java.util.*;
public class DisjointSet {

    static int find(int[] ldr,int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr,ldr[node]);
        }

        return ldr[node];
    }

    static void join(int[] ldr,int lt,int rt){

        int leader1=find(ldr,lt);
        int leader2=find(ldr,rt);

        if(leader1!=leader2){
            ldr[leader2]=leader1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ldr=new int[n+1];

        for(int i=1;i<=n;i++) ldr[i]=i;

        for(int i=1;i<=n;i++){
            int lt=sc.nextInt();
            int rt=sc.nextInt();

            join(ldr,lt,rt);
    }

    HashSet<Integer> set=new HashSet<>();
    for(int i=1;i<=n;i++){
        set.add(find(ldr,i));
    }

    System.out.println(set);
    System.out.println("Number of connected components = " + set.size());

    }
}
