import java.util.*;
public class Main {
    public static int lowerBound(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int res=arr.length;
        while(left<=right){
            int mid=left+((right-left)/2);

            if(arr[mid]>=target){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return res;
    }

    public static int upperBound(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int res=arr.length;
        while(left<=right){
            int mid=left+((right-left)/2);

            if(arr[mid]>target){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
    

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    int n=sc.nextInt();
    int[] xi=new int[n];
    int[] pi=new int[n];
    long[] prefix_sum=new long[n+1];

    for(int i=0;i<n;i++)xi[i]=sc.nextInt();
    for(int i=0;i<n;i++)pi[i]=sc.nextInt();

    for(int i=0;i<n;i++){
        prefix_sum[i+1]+=pi[i]+prefix_sum[i];
    }
    
    int q=sc.nextInt();
    
    while(q-->0){
      int li=sc.nextInt();
      int ri=sc.nextInt();
      
      int lb=lowerBound(xi,li);
      int wb=upperBound(xi,ri);
      
      System.out.println(prefix_sum[wb+1]-prefix_sum[lb-1]);
      sc.close();
    }
    }
}
