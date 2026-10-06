package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
//        s=s.toLowerCase();
        Map<Character, Integer> map=new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int palindromicLength=0;
        boolean hasOdd = false;
        for(Integer val: map.values()){
            if(val%2==0){
                palindromicLength += val;
            } else {
                palindromicLength += val - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? palindromicLength + 1 : palindromicLength;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(longestPalindrome(str));
    }
}
