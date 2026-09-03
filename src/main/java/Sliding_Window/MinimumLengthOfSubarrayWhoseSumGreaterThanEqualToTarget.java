package Sliding_Window;

import java.util.Scanner;

public class MinimumLengthOfSubarrayWhoseSumGreaterThanEqualToTarget {
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0)
            return -1;

        int left=0;
        int sum=0;
        int answerSubarrayLength=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                answerSubarrayLength=Math.min(answerSubarrayLength, (right-left+1) );
                sum-=nums[left];
                left++;
            }
        }
        return answerSubarrayLength==Integer.MAX_VALUE ? 0 : answerSubarrayLength;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(minSubArrayLen(target,arr));
    }
}
