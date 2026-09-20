package Kadane;

import java.util.Scanner;

public class MaximumProducSubarray {
    public static int maxProduct(int[] nums) {
        int maxAnswer=1;
        int minAnswer=1;
        int answer=Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            int v1=maxAnswer*nums[i];
            int v2=minAnswer*nums[i];
            int v3=nums[i];
            maxAnswer=Math.max(v3,Math.max(v2,v1));
            minAnswer=Math.min(v3,Math.min(v2,v1));
            answer=Math.max(answer, Math.max(maxAnswer,minAnswer));
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(maxProduct(arr));
    }
}
/*
iven an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */