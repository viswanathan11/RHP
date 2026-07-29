//Top H problem

import java.util.HashMap;
import java.util.Scanner;

public class UnblievableArray {

    static HashMap<Integer,Integer> lvm=new HashMap<>();
    static HashMap<Integer,Integer> vlm=new HashMap<>();
    static int find(int[] ldr,int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr, ldr[node]);
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
        int N=sc.nextInt();
        int[] arr=new int[N+1];
        int[] ldr=new int[N+1];
        int[] grp=new int[N+1];
        int Q=sc.nextInt();
        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
            ldr[i]=i;

            if(!vlm.containsKey(arr[i])){
                vlm.put(arr[i], i);
                lvm.put(i, arr[i]);
            } else {
                int leader1=vlm.get(arr[i]);
                join(ldr, leader1, i);
            }
        }
        while(Q-->0){
            int op=sc.nextInt();
            int r1=sc.nextInt();
            if(op==1){
                int r2=sc.nextInt();
                if(r1!=r2 && vlm.containsKey(r1)){
                    int leaderX=vlm.get(r1);
                    vlm.remove(r1);
                    if(!vlm.containsKey(r2)){
                        vlm.put(r2, leaderX);
                        lvm.put(leaderX, r2);
                    } else {
                        int leaderY=vlm.get(r2);
                        join(ldr, leaderY, leaderX);
                        lvm.remove(leaderX);
                    }
                }
            } else if(op==2){
                int root=find(ldr, r1);
                System.out.println(lvm.get(root));
            }
        }

        sc.close();
    }
}

