package Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckIfPermutationIsSubstring {

        public static boolean search_2ndApproach(String txt, String pat) {

            if (pat.length() > txt.length())
                return false;

            Map<Character, Integer> patFreq = new HashMap<>();
            Map<Character, Integer> windowFreq = new HashMap<>();

            for (char ch : pat.toCharArray()) {
                patFreq.put(ch, patFreq.getOrDefault(ch, 0) + 1);
            }

            int left = 0;

            for (int right = 0; right < txt.length(); right++) {

                char rightChar = txt.charAt(right);
                windowFreq.put(
                        rightChar,
                        windowFreq.getOrDefault(rightChar, 0) + 1
                );

                // If window becomes bigger than pattern,
                // remove left character
                if (right - left + 1 > pat.length()) {

                    char leftChar = txt.charAt(left);

                    windowFreq.put(
                            leftChar,
                            windowFreq.get(leftChar) - 1
                    );

                    if (windowFreq.get(leftChar) == 0)
                        windowFreq.remove(leftChar);

                    left++;
                }

                // Fixed-size window
                if (right - left + 1 == pat.length()) {
                    if (windowFreq.equals(patFreq))
                        return true;
                }
            }

            return false;
        }

    public static boolean search(String txt, String pat) {

        if (txt.isEmpty() || pat.length() > txt.length())
            return false;

        int left = 0;
        int[] patFreq = new int[256];
        for (char ch : pat.toCharArray())
            patFreq[ch]++;

        Map<Character, Integer> mp = new HashMap<>();
        int right = 0;
        while (right < txt.length()) {
            mp.put(txt.charAt(right),mp.getOrDefault(txt.charAt(right), 0)+1);
            if ((right - left) < pat.length()) {
                right++;
            }

            if ((right - left) == pat.length()) {
                int count = 0;
                for (Character key : mp.keySet()) {
                    if (mp.get(key) == patFreq[key])
                        count++;
                }
                if (count == mp.size())
                    return true;

                char leftChar = txt.charAt(left);
                mp.put(leftChar, mp.get(leftChar) - 1);
                if (mp.get(leftChar) == 0)
                    mp.remove(leftChar);
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        String pat = scanner.next();
        System.out.println(search(txt, pat));
    }
}

