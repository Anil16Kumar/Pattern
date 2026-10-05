package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] circularNums = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            circularNums[i] = nums[i % n];
        }

        int[] nge = new int[2 * n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stk.isEmpty() && stk.peek() <= circularNums[i]) {
                stk.pop();
            }

            nge[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(circularNums[i]);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = nge[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scanner.nextInt();
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is
nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order
next in the array, which means you could search circularly to find its next greater number.
If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
* */
