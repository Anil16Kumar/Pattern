package BinarySearch;

import java.util.Scanner;

public class ImplementUpperBound {
    public static int upperBound(int[] arr, int target) {
        int n=arr.length;
        if(arr[n-1]<=target)
            return n;

        int low=0, high=n-1;
        int answer = -1;
        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]<=target)
                low=mid+1;
            else{
                answer=mid;
                high = mid - 1;
            }
        }

        return  answer;
    }
    public static int upperBound_(int[] arr, int target) {
        int n = arr.length;

        if (arr[n - 1] <= target)
            return n;

        int low = 0, high = n - 1;
        int answer = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] Arr=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(upperBound(Arr, target));
    }
}

/*
Given a sorted array arr[] and a number target, the task is to find the upper bound of the target
in this given array.

The upper bound is the smallest index in the sorted array where the element is greater than the given
target.
If all the elements in the given array are smaller than or equal to the target, the upper bound will
be the length of the array.
Examples :

Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
Output: 3
Explanation: 3 is the smallest index in arr[], at which element (arr[3] = 10) is larger than 9.
Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
Output: 6
Explanation: 6 is the smallest index in arr[], at which element (arr[6] = 25) is larger than 11.
Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
Output: 7
Explanation: As no element in arr[] is greater than 100, return the length of array.
Constraints:

1 ≤ arr.size(), arr[i], target ≤ 106

* */
