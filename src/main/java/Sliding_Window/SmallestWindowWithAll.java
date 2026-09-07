package Sliding_Window;

import java.util.Scanner;

public class SmallestWindowWithAll {

    public static String minWindow(String s, String p) {

        if (s.isEmpty() || p.isEmpty() || p.length() > s.length())
            return "";

        int left = 0;
        int[] pFreq = new int[256];
        for (char ch : p.toCharArray())
            pFreq[ch]++;
        int[] windowFreq = new int[256];
        int count = 0;
        int answerLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq[rightChar]++;

            if (pFreq[rightChar] > 0 && windowFreq[rightChar] <= pFreq[rightChar]) {
                count++;
            }

            while (count == p.length()) {
                if ((right - left + 1) < answerLength) {
                    answerLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;
                if (pFreq[leftChar] > 0 && windowFreq[leftChar] < pFreq[leftChar]) {
                    count--;
                }
                left++;
            }
        }

        return answerLength == Integer.MAX_VALUE ? "" : s.substring(start, start + answerLength);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        String p=scanner.next();
        System.out.println(minWindow(s,p));
    }
}
