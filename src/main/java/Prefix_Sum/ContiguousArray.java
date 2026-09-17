package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int cntOne=0,cntZero=0;
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) cntZero++;
            else cntOne++;
            int diff = cntZero-cntOne;

            if(diff==0){
                ans=Math.max(ans,i+1);
            }

            if(map.containsKey(diff)){
                int idx= map.get(diff);
                int len=i-idx;
                ans=Math.max(len,ans);
            }else{
                map.put(diff,i);
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] Arr=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        System.out.println(findMaxLength(Arr));
    }
}
/*
Given a binary array nums, return the maximum length of a contiguous subarray
with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Example 3:
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
* */