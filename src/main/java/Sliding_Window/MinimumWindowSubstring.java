package Sliding_Window;

import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        int[] t_freq = new int[256];
        for (int i = 0; i < t.length(); i++)
            t_freq[t.charAt(i)]++;

        int[] window_freq = new int[256];
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window_freq[c]++;

            if (t_freq[c] > 0 && window_freq[c] <= t_freq[c])
                count++;

            while (count == t.length()) {
                if ((right - left + 1) < minLen) {
                    minLen = (right - left + 1);
                    start = left;
                }

                char leftChar = s.charAt(left);
                window_freq[leftChar]--;
                if (t_freq[leftChar] > 0 && window_freq[leftChar] < t_freq[leftChar]) {
                    count--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        String t=scanner.next();
        System.out.println(minWindow(s,t));
    }
}
/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
character in t (including duplicates) is included in the window. If there is no such substring,
return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
* */
