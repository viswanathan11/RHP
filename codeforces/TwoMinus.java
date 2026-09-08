import java.util.Scanner;

public class TwoMinus {
    static Scanner sc=new Scanner(System.in);
    public static void solve(){
        int N=sc.nextInt();

        int odd=0;

        int eoq=0;
        int eeq=0;

        for(int ctr=1;ctr<=N;ctr++){
            int curr=sc.nextInt();
            if(curr % 2!=0){
                odd++;
            }else{
                int q=curr/2;
                if(q%2!=0) eoq++;
                else eeq++;
            }
        }
        System.out.println(Math.max(odd,Math.max(eoq,eeq)));
    }
    public static void main(String[] args) {
        int n=sc.nextInt();
        while(n-->0){
            solve();
        }
    }
}
