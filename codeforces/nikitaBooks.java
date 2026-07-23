import java.util.*;
public class nikitaBooks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        while(T-->0){
            int n=sc.nextInt();

            int[] arr=new int[n+1];

            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
            }

            int balance=0;
            boolean okay=true;
            for(int i=1;i<=n;i++){
                if(arr[i]>=i){
                    balance+=arr[i]-i;
                }else{
                    int needed=i-arr[i];
                    if(balance<needed){
                        okay=false;
                        break;
                    }
                    balance-=needed;
                }
            }

            System.out.println(okay?"YES":"NO");
        }
    }
}
