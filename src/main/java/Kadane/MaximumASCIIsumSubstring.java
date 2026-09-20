package Kadane;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumASCIIsumSubstring {

    public static String maxSum(String s, char[] a, int[] b) {

        int[] ascii = new int[256];

        // Mark characters that don't have a redefined ASCII value
        Arrays.fill(ascii, Integer.MIN_VALUE);

        // Store redefined ASCII values
        for (int i = 0; i < a.length; i++) {
            ascii[a[i]] = b[i];
        }

        int bestAnswer = Integer.MIN_VALUE;
        int currentSum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int val = (ascii[ch] != Integer.MIN_VALUE)
                    ? ascii[ch]
                    : (int) ch;

            // Kadane's algorithm
            if (currentSum + val < val) {
                currentSum = val;
                start = i;
            } else {
                currentSum += val;
            }

            // Update best substring
            if (currentSum > bestAnswer) {
                bestAnswer = currentSum;
                ansStart = start;
                ansEnd = i;
            }
        }

        return s.substring(ansStart, ansEnd + 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        int n = scanner.nextInt();

        char[] a = new char[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().charAt(0);
        }

        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(maxSum(str, a, b));
    }
}