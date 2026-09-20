package Slow_Fast_Pointer;

import java.util.Scanner;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scanner.nextInt();
        System.out.println(findDuplicate(nums));
    }
}
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n]
inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

[1,3,4,2,2]
 0,1,2,3,4

idx->val->idx.......its a cycle
0->1
1->3
3->2
2->4
4->2 (2 is already visited....)



Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
* */