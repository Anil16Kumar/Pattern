package Sliding_Window;

import java.util.Map;
import java.util.Scanner;

public class MaxSumSubarrayofSizeK {

    public static int maxSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length < k || arr.length == 0)
            return 0;

        int left=0;
        int right=0;
        int sum=0;
        int answer=Integer.MIN_VALUE;
        while(right<arr.length){
            sum+=arr[right];
            if((right-left+1)<k){
                right++;
            } else {
                answer= Math.max(answer,sum);
                sum-=arr[left];
                left++;
                right++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(maxSubarraySum(arr, k));
    }
}
