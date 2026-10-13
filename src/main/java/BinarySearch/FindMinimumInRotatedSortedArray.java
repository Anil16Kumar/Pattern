package BinarySearch;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
/*
*
     |
     |  |
     |  |
  |  |  |
  |  |  |        |
  |  |  |        |
  |  |  |     |  |
  |  |  |  |  |  |
  5  6  7  1  2  4
  rotated array.
* */
    public static int findMin_Pat(int[] arr){
        int len=arr.length;
        int low=0, high=len-1;
        int answer=-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>arr[len-1]){
                low=mid+1;
            } else {
                answer=mid;
                high=mid-1;
            }
        }
        return arr[answer];
    }

    public static int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1])
            return nums[0];

        int len = nums.length;
        int low=0, high=len-1;
        while(low<high){
            int mid = low + (high - low) / 2;
            /*
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])
                return nums[mid];
                this if() part work in "peak index in a mountain array" question because,
                as per constrain minimum length of array possible is 3, but in this question as per
                 constrain minimum length of array is 1, so if we write mid-1 or mid+1,
                 it will array index out of bound
*/
            if(nums[mid] > nums[len-1]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(findMin(arr));
    }
}
/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
[a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
* */