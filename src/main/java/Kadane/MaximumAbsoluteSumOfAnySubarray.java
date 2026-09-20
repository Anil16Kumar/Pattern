package Kadane;

import java.util.Scanner;

public class MaximumAbsoluteSumOfAnySubarray {
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
    public static int maxAbsoluteSum(int[] nums) {
        int val1=minSubarraySum(nums);
        int val2=maxSubArray(nums);
        return Math.max( Math.abs(val2), Math.abs(val1));
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(maxAbsoluteSum(arr));
    }
}
/*
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr]
is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.


Example 1:
Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

Example 2:
Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
* */