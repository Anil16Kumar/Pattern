package Prefix_Sum;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
**/
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        /*
              nums: 1, 2, 3, 4
prefixProductStart: 1, 2, 6, 24
prefixProductLast : 24,24,12, 4

result: 24, 12, 8, 6
result: prefixProductStart[i-1] * prefixProductLast[i+1]

        * */
        int n=nums.length;
        int result[] = new int[n];
        int prefixProductStart[] = new int[n];
        int prefixProductLast[] = new int[n];

        prefixProductStart[0] = nums[0];
        for(int i=1;i<n;i++)
            prefixProductStart[i] = prefixProductStart[i-1]*nums[i];

        prefixProductLast[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            prefixProductLast[i]=prefixProductLast[i+1]*nums[i];

        result[0]=prefixProductLast[1];
        result[n-1]=prefixProductStart[n-2];
        for(int i=1;i<n-1;i++)
            result[i]=prefixProductStart[i-1] * prefixProductLast[i+1];

        return result;
// but this solution takes extra space

    }

    public static int[] productExceptSelf_spaceEfficent(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int productBeforeCurrent=1;
        int productAfterCurrent=1;
        for(int i=0;i<n;i++){
            result[i] = productBeforeCurrent;
            productBeforeCurrent *= nums[i];
        }
        /*
        // abhi tak result me prefix product hai, nums[] ka except ith index
        result[i] = product(0....i-1);
        result[0] = 1

        for example, nums[] = 1, 2, 3, 4
                   result[] = 1, 1, 2, 6

          abb, productAfterCurrent variable left se (i+1, n-1) ka product ko contain karega,
          aur usse hum result[i] me multiply kar dege, jo (0, i-1) tak ka product carry kar raha h

        * */

        for(int i=n-1;i>=0;i--){
            result[i] *= productAfterCurrent;
            productAfterCurrent *= nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=scanner.nextInt();
        System.out.println(Arrays.toString(productExceptSelf_spaceEfficent(nums)));
    }
}
