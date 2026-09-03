package Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int left = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int answerLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while ((right - left + 1) > mp.size()) {
                char leftChar = s.charAt(left);
                mp.put(leftChar, mp.get(leftChar) - 1);
                if (mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }
                left++;
            }

            answerLength = Math.max(answerLength, right - left + 1);
        }
        return answerLength;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
