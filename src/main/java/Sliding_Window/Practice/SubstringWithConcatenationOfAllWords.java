package Sliding_Window.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> answer = new ArrayList<>();

        if (s == null || words == null || words.length == 0)
            return answer;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;

        if (s.length() < windowSize)
            return answer;

        // Frequency of words that we need
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        /*
         * We have to try word boundaries starting from:
         *
         * 0, 1, 2, ... wordLength - 1
         *
         * Example:
         * wordLength = 3
         *
         * barfoofoobarthe
         * ^  ^  ^
         * 0  1  2
         */
        for (int start = 0; start < wordLength; start++) {

            int left = start;
            int right = start;

            Map<String, Integer> windowFreq = new HashMap<>();

            int count = 0;

            while (right + wordLength <= s.length()) {

                // Take one complete word from the current window
                String currentWord =
                        s.substring(right, right + wordLength);

                right += wordLength;

                // Case 1: currentWord is not present in words
                if (!wordFreq.containsKey(currentWord)) {

                    windowFreq.clear();
                    count = 0;
                    left = right;

                } else {

                    // Add currentWord to our window
                    windowFreq.put(
                            currentWord,
                            windowFreq.getOrDefault(currentWord, 0) + 1
                    );

                    count++;

                    /*
                     * If current word occurs more times than required,
                     * remove words from the left until it becomes valid.
                     */
                    while (windowFreq.get(currentWord)
                            > wordFreq.get(currentWord)) {

                        String leftWord =
                                s.substring(left, left + wordLength);

                        windowFreq.put(
                                leftWord,
                                windowFreq.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }

                    /*
                     * If we have exactly all words,
                     * we found a valid concatenation.
                     */
                    if (count == totalWords) {

                        answer.add(left);

                        /*
                         * Move left by one word so that we can
                         * continue looking for another answer.
                         */
                        String leftWord =
                                s.substring(left, left + wordLength);

                        windowFreq.put(
                                leftWord,
                                windowFreq.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        int n = scanner.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        System.out.println(findSubstring(str, words));
    }
}
/*
You are given a string s and an array of strings words. All the strings of words are
of the same length.

A concatenated string is a string that exactly contains all the strings of any
permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab",
"efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string
because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can
return the answer in any order.



Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a
permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a
permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].


* */