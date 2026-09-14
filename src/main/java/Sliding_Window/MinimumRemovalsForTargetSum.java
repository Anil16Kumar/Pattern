package Sliding_Window;

import java.util.Scanner;

public class MinimumRemovalsForTargetSum {
    public static int SubArraySumExactlyK(int[] arr, int k){
        if(arr.length==0)
            return -1;

        int left=0;
        int n=arr.length;
        int answer=Integer.MIN_VALUE; //max length, we are looking for max length subarray because the question says
        // "minimum number of operations required to make the total sum of removed elements exactly equal to k."
        // and, operations = arr.length - lengthOfRemainingSubarray
        // that is why for operations ↓  = lengthOfRemainingSubarray ↑
        int sum=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            if (sum == k) {
                answer = Math.max(answer, right - left + 1);
            }
        }
        return answer==Integer.MIN_VALUE?-1:answer;
    }
    public static int minRemovals(int[] arr, int k) {
         int totalSum =0;
         for(int val: arr)
             totalSum +=val;

         if(totalSum<k)
             return -1;

         if(k==totalSum)
             return arr.length;

         totalSum = totalSum - k;

         int longest =SubArraySumExactlyK(arr, totalSum);

         return longest ==-1?-1:arr.length- longest;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(minRemovals(arr, k));
    }
}
/*
You are given an array of positive integers arr[] and an integer k. In one operation, you can remove either the
leftmost or the rightmost element from the array. After each operation, the size of arr[] will be reduced by one.
You have to determine the minimum number of operations required to make the total sum of removed elements exactly
equal to k. If it is not possible to achieve this, return -1.

Examples:

Input: arr[] = [3, 4, 1, 3, 2], k = 5
Output: 2
Explanation: Removing 3 from left and 2 from right gives a sum of 5 in 2 operations.
Input: arr[] = [5, 3, 4, 6, 2], k = 6
Output: -1
Explanation: It is impossible to achieve the sum of removed elements as 6.
Input: arr[] = [1, 1, 3, 1, 2], k = 4
Output: 3
Explanation: Removing 1, 1 from left and 2 from right gives a sum of 4 in 3 operation.
Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104
1 ≤ k ≤ 109
*
* */