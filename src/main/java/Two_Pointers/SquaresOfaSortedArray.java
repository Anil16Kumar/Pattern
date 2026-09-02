package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class SquaresOfaSortedArray {
    public static int[] sortedSquares(int[] nums) {
        if(nums.length==0)
            return new int[]{-1};

        int[] answer=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int ansIdx=nums.length-1;

        while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];

            if(leftSquare>rightSquare){
                answer[ansIdx]=leftSquare;
                left++;
            } else {
                answer[ansIdx] = rightSquare;
                right--;
            }
            ansIdx--;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int Arr[]=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        System.out.println(Arrays.toString(sortedSquares(Arr)));


        //-----------
        System.out.println(
                Arrays.toString(
                        Arrays.stream(Arr)
                        .map(val -> val * val)
                        .sorted()
                        .toArray()
                )
        );
        //---------
    }
}
/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.


Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
* */