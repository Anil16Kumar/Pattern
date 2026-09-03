package Sliding_Window;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LongestSubstringWithKUniques {
    public static int longestKSubstr(String s, int k) {

        if(s.isEmpty() || s.length()<k)
            return -1;

        int left=0;
        int answerSubstringLength=Integer.MIN_VALUE;
        Map<Character, Integer> mp=new TreeMap<>();

        for(int right=0;right<s.length(); right++){
            char ch=s.charAt(right);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

            while(mp.size()>k){
                char leftChar=s.charAt(left);
                mp.put(leftChar, mp.get(leftChar)-1);
                if(mp.get(leftChar)==0)
                    mp.remove(leftChar);
                left++;
            }
            if(mp.size()==k)
                answerSubstringLength=Math.max(answerSubstringLength, (right-left+1));
        }
        return answerSubstringLength==Integer.MIN_VALUE?-1:answerSubstringLength;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int k=scanner.nextInt();
        System.out.println(longestKSubstr(str,k));
    }
}
