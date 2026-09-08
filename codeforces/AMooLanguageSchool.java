import java.util.Scanner;

public class AMooLanguageSchool {
    static Scanner sc=new Scanner(System.in);
    public static void solve(){
        int n=sc.nextInt();
        int k=sc.nextInt();
        int F=n/k;

        boolean[] ownbyJohn=new boolean[F];

        char[] s=sc.next().toCharArray();
        int res=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='0'){
                ownbyJohn[i/k]=true;
            }

        }
        for(int i=0;i<F;i++)if(!ownbyJohn[i]) res++;
        System.out.println(res);

    }
    public static void main(String[] args) {
        int n=sc.nextInt();
        
        while(n-->0){
            solve();
        }
        sc.close();
    }
}