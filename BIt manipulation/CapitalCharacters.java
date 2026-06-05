import java.util.Scanner;

public class CapitalCharacters {
    public static void main(String[] args) {
          Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        int flag=0;
        for(char c:s.toCharArray()){
            if(c>='A' && c<='Z')
            flag=flag | (1<<(c-'A'));
        }

        int all = (1<<26)-1;
        if(flag==all){
            System.out.print("Valid String");
        }else{
            System.out.print("Invalid");
        }

        sc.close();
    }
}
