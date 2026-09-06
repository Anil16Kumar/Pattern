package Sliding_Window;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length<1)
             return -1;

        int left=0;
        int answerLength=Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0)
                left=right+1;
            answerLength=Math.max(answerLength,(right-left+1));
        }
        return answerLength;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scanner.nextInt();
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
