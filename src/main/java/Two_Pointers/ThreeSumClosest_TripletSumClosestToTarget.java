package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest_TripletSumClosestToTarget {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return -1;

        Arrays.sort(nums);
        int answerSum = nums[0] + nums[1] + nums[2];

        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;

            while (mid < right) {
                int currentSum = nums[left] + nums[mid] + nums[right];

                if (Math.abs(target - currentSum) < Math.abs(target - answerSum)) {
                    answerSum = currentSum;
                }

                if (currentSum < target) {
                    mid++;
                } else {
                    right--;
                }
            }
        }
        return answerSum;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] Arr=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        int target=scanner.nextInt();

        System.out.println(threeSumClosest(Arr,target));
    }
}

/*
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
* */