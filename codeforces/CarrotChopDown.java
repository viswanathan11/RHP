import java.util.Scanner;

public class CarrotChopDown {
    //k = 1 number of slice allowed one time
    //count : no of carrot of same sizes
    //psum: prefix sum
    //x: total number of slices of size x=1,2,3,4..M

    static Scanner sc=new Scanner(System.in);
    public static void solve(){
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[n];
        int[] prefixSum=new int[m+1];
        int[] count=new int[m+1];
        int x[] =new int[m+1];

        for(int i=0;i<n;i++){
            int t=sc.nextInt();
            arr[i]=t;
            count[t]++;
        }

        for(int i=1;i<=m;i++){
            prefixSum[i]=prefixSum[i-1]+count[i];
        }
        int res=Integer.MIN_VALUE;

        for(int i=1;i<=m;i++){
            int extra=0;
            if(2*i <=m) extra=count[2*i];
            x[i]=count[i]+(n-prefixSum[i])+extra;
            res=Math.max(res,x[i]);
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        int n=sc.nextInt();
        while(n-->0){
            solve();
        }
    }
}
