import java.io.FileReader;
import java.util.Scanner;

/**
 * staticRangeSum
 */
public class staticRangeSum {
    // public static void main(String[] args) {
    //   Scanner sc=new Scanner(System.in);
      
    //   int n=sc.nextInt();
    //   int q=sc.nextInt();
    //   int[] arr=new int[n];
    
    //   for(int i=0;i<n;i++)arr[i]=sc.nextInt();

    //   while(q-->0){
    //     int prefix_sum=0;

    //     int st=sc.nextInt();
    //     int end=sc.nextInt();

    //     for(int i=st-1;i<end;i++){
    //         prefix_sum+=arr[i];
    //     }

    //     System.out.println(prefix_sum);
    //   }

    // }    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    
        int n=sc.nextInt();
        int q=sc.nextInt();

        int prefix_sum[]=new int[n+1];
        int[] arr=new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        for(int i=0;i<n;i++){
            prefix_sum[i+1]+=prefix_sum[i]+arr[i];
        }

        while(q-->0){
            int st=sc.nextInt();
            int end=sc.nextInt();

            System.out.println(prefix_sum[end]-prefix_sum[st-1]);
        }

    }
}