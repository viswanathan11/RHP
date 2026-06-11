import java.util.HashMap;

public class LongestSubstringWithEqual0and1 {
    public static void main(String[] args) {
        String str="00110";
        HashMap<Integer,Integer> map=new HashMap<>();
        int s=0;
        map.put(s,-1);

        int len=0;
        int count=0;

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);

            if(c=='0'){
                count--;
            }else{
                count++;
            }

            if(map.containsKey(count)){
                len=Math.max(len,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        
        System.out.println("The maximum Substring length with equal 0s and 1s is: "+len);
    }
}