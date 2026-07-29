//Top H problem

import java.util.HashMap;
import java.util.Scanner;

public class UnblievableArray {

    static HashMap<Integer,Integer> lvm=new HashMap<>();
    static HashMap<Integer,Integer> vlm=new HashMap<>();
    int find(int[] ldr,int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr, ldr[node]);
        }

        return ldr[node];
    }

    void join(int[] ldr,int lt,int rt){
        int leader1=find(ldr,lt);
        int leader2=find(ldr,rt);

        if(leader1!=leader2){
            ldr[leader2]=leader1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        int[] ldr=new int[N+1];
        int[] grp=new int[N+1];
        int Q=sc.nextInt();
        while(Q-->0){
            int op=sc.nextInt();
            int r1=sc.nextInt();
            int r2=sc.nextInt();

            
        }
    }
}
