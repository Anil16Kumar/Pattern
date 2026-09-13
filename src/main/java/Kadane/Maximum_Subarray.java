package Kadane;

import java.util.Scanner;

// sliding window fails in -ve elements
/*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
* */
public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int bestAnswer=0;
        int answer=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int v1=bestAnswer+nums[i];
            int v2=nums[i];
            bestAnswer=Math.max(v1,v2);
            answer=Math.max(answer,bestAnswer);
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
        System.out.println(maxSubArray(arr));
    }
}
