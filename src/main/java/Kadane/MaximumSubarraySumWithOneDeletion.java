package Kadane;

import java.util.Scanner;

public class MaximumSubarraySumWithOneDeletion {
    public static int maximumSum(int[] arr) {

        int oneDeletion=arr[0];
        int noDeletion=arr[0];
        int answer=arr[0];

        for(int i=1;i<arr.length;i++){
            int prevOneDeletion=oneDeletion;
            int prevNoDeletion=noDeletion;

            noDeletion=Math.max(noDeletion+arr[i], arr[i]);
            oneDeletion=Math.max(oneDeletion+arr[i], prevNoDeletion);

            answer=Math.max(answer, Math.max(oneDeletion, noDeletion));
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(maximumSum(arr));
    }
}
/*
Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with
at most one element deletion. In other words, you want to choose a subarray and optionally delete one
 element from it so that there is still at least one element left and the sum of the remaining
 elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.



Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the
subarray [1, 0, 3] becomes
the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete
-1 from it, then get an empty subarray to make the sum equals to 0.

* */