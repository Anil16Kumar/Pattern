package Kadane;

import java.util.Scanner;

public class MaximumSumCircularSubarray {
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
    }
    public static int maxSubArray(int[] nums) {
        int bestAnswer = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int v1 = bestAnswer + nums[i];
            int v2 = nums[i];
            bestAnswer = Math.max(v1, v2);
            answer = Math.max(answer, bestAnswer);
        }
        return answer;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        for(int val:nums)
            totalSum+=val;

        int val1=maxSubArray(nums);
        // all elements are negative
        if(val1<0)
            return val1;

        int val2=totalSum-minSubarraySum(nums);

        return Math.max(val1, val2);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(maxSubarraySumCircular(arr));
    }
}
