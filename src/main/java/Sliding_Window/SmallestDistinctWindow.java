package Sliding_Window;

import java.util.Scanner;

public class SmallestDistinctWindow {
    public static int findSubString(String str) {
        if (str.isEmpty())
            return -1;

        int[] patFreq = new int[256];
        int distinctCount = 0;

        for (char ch : str.toCharArray()) {
            if (patFreq[ch] == 0) {
                patFreq[ch] = 1;
                distinctCount++;
            }
        }

        int[] windowFreq = new int[256];
        int left = 0, count = 0, lengthAnswer = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            windowFreq[ch]++;

            if (windowFreq[ch] == 1) {
                count++;
            }

            while (count == distinctCount) {
                lengthAnswer = Math.min(lengthAnswer, right - left + 1);

                char leftChar = str.charAt(left);
                windowFreq[leftChar]--;
                if (windowFreq[leftChar] == 0) {
                    count--;
                }
                left++;
            }
        }

        return lengthAnswer;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(findSubString(str));
    }
}
/*
Given a string str, your task is to find the length of the smallest window that contains
all the characters of the given string at least once.

Example:
Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.
Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.
Input: str = "geeksforgeeks"
Output: 7
Explanation: There are multiple substring with smallest length that contains all characters of str, "eksforg" and "ksforge".
Constraints:
1 ≤ str.size() ≤ 105
str contains only lower-case english alphabets.
* */
