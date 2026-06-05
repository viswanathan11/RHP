import java.util.Scanner;

public class SmallCharacters {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        int flag=0;
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z')
            flag=flag | (1<<(c-'a'));
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