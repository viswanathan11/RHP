import java.util.Scanner;

public class  MaximumSumWIthConcitonOnColumn{

    public static int getSpecialMax(int[][] arr,int row,int ignore){

        int max=Integer.MIN_VALUE;
        for(int col=0;col<arr[0].length;col++){
            if(col==ignore){
                continue;
            }
            else{
                max=Integer.max(arr[row][col],max);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] arr=new int[n][m];
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int j=0;j<m;j++){
            dp[0][j]=arr[0][j];
        }
        for(int i=1;i<n;i++){

            //This loop is used to find the max1 and max2 of previous row
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            int idx1=-1;
            for(int j=0;j<m;j++){
                int val=dp[i-1][j];
                if(val>max1){
                    max2=max1;
                    max1=val;
                    idx1=j;
                }else if(val>max2){
                    max2=val;
                }
            }
            for(int j=0;j<m;j++){

                if(j==idx1){
                    dp[i][j]=arr[i][j] + max2;
                }else{
                    dp[i][j]=arr[i][j]+max1;
                }
                }
            }

        sc.close();

        int result=Integer.MIN_VALUE;
        for(int col=0;col<m;col++){
            result=Integer.max(result,dp[n-1][col]);
        }

        System.out.print("The maximum Special sum: "+ result);
    }
}
