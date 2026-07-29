import java.util.Scanner;

public class CRotation {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Q=sc.nextInt();
        StringBuilder sb=new StringBuilder(sc.next());

        // while(Q-->0){
        //     int op=sc.nextInt();
        //     int x=sc.nextInt();

        //     if(op==2){
        //         System.out.println(sb.charAt(x-1));
        //     }else if(op==1){
        //         sb.append(sb.substring(0,N-x));
        //         sb.delete(0,N-x);
        //     }
        // }

        // sc.close();

        //Optimal Approach

        int pos=N-1;

        while(Q-->0){
            int op=sc.nextInt();
            int x=sc.nextInt();
            x=x%N;
            if(op==2){
                System.out.println(sb.charAt((x+pos)%N));
            }else if(op==1){
                pos=pos-x;

                if(pos<x){
                    pos+=N;

                }
            }
        }
        sc.close();
        
    }
}
