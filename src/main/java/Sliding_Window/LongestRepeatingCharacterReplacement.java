package Sliding_Window;

import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLengthAnswer = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;

            maxCount = Math.max(maxCount, freq[c - 'A']);

            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLengthAnswer = Math.max(maxLengthAnswer, right - left + 1);
        }

        return maxLengthAnswer;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int k=scanner.nextInt();
        System.out.println(characterReplacement(str, k));
    }
}




/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other
uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
* */
