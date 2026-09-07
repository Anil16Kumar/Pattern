package Sliding_Window;

import java.util.Scanner;

public class SubarraysWithSumInRange {
    public static int countSubarray(int[] arr, int l, int r) {
        return countAtMost(arr, r) - countAtMost(arr, l - 1);
    }

    private static int countAtMost(int[] arr, int bound) {
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > bound && left <= right) {
                sum -= arr[left];
                left++;
            }
            count += (right - left + 1);
            // every subarray that ends at right and starts anywhere between left and right is valid.
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int l=scanner.nextInt();
        int r=scanner.nextInt();
        System.out.println(countSubarray(arr, l, r));
    }
}
