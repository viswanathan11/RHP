import java.util.Scanner;

public class c101 {
    static Scanner sc=new Scanner(System.in);
    public static void solve(){
        int N=sc.nextInt();

        int[] arr=new int[N];

        for(int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }

        int lt=0;
        int rt=N-1;
        while(lt<N && arr[lt]==0) lt++;
        while(rt>=0 && arr[rt]==0)rt--;
        
        if (lt == N) {
       arr[0] = 1;
       arr[N - 1] = 1;
    }
        else {
            
            arr[rt]=1;
            arr[lt]=1;
            for(int i=lt+1;i<rt;i++){
                if(arr[i]==-1){
                    arr[i]=0;
                }
            }
        }


        for(int i=0;i<N;i++){
            if(i!=0)System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n=sc.nextInt();

        while(n-->0){
            solve();
        }
    }

}
