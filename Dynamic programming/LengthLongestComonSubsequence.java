import java.util.Scanner;

public class LengthLongestComonSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] str1="morning".toCharArray();
        char[] str2="evening".toCharArray();

        int dp[][]=new int[str1.length+1][str2.length+1];


        for(int i=0;i<str1.length;i++){
            for(int j=0;j<str2.length;j++){
                if(str1[i]==str2[j]){
                    dp[i+1][j+1]= 1+dp[i][j];
                }else{
                    dp[i+1][j+1]=Integer.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        System.out.print(dp[str1.length][str2.length]);
        sc.close();
    }
}
