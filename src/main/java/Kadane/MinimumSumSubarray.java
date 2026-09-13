package Kadane;

import java.util.Scanner;

public class MinimumSumSubarray {
    public static int minSubarraySum(int[] arr) {
        int bestAnswer=0;
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int v1=bestAnswer+arr[i];
            int v2=arr[i];
            bestAnswer=Math.min(v1,v2);
            answer=Math.min(bestAnswer, answer);
        }
        return answer;
        // har ek 'i' ke liye, ab tak ka best answer me ith value ko add karo, phir compare
        // karo current ith value ko ab tak ke best answer se, max store karo, phir answer me store karo

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(minSubarraySum(arr));
    }
}
