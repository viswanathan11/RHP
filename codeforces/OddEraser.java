import java.util.Scanner;

public class OddEraser{
    static Scanner sc=new Scanner(System.in);

    public static int gcd(int a,int b){
        return b==0?a:gcd(b,b%a);
    }
    public static void solve(){
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(gcd(arr[0],arr[n-1]));
        }
    public static void main(String[] args) {
        int n=sc.nextInt();

        while (n-->0) {
            solve();
        }
    }
}