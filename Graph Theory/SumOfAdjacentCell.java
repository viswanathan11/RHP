
import java.util.*;

public class SumOfAdjacentCell{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the i and j of the cell to calculate its adjacent cell sum");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        /*
        {1,2,3,4}
        {5,6,7,8}
        {9,10,11,12}
        {13,14,15,16}
        */
        int[][] diff={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        int sum=0;
        for(int i=0;i<diff.length;i++){
            int row=r+diff[i][0];
            int col=c+diff[i][1];
            if(row>=0 && col>=0 && row<arr.length && col<arr[0].length)
            sum+=arr[row][col];
        }

        System.out.println("The sum of Adjacent cell of ("+r+","+c+") is "+sum);
        sc.close();
    }
}