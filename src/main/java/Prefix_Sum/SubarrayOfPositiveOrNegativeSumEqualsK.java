package Prefix_Sum;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given an array of integers nums and an integer k, return the total number of subarrays
whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000 <--------- that is why the sliding window doesn't work here
-107 <= k <= 107
* */
public class SubarrayOfPositiveOrNegativeSumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int prefixSum=0;
        int count=0;
        Map<Integer, Integer> subarrayCount=new HashMap<>();
        /*
        Suppose:
        prefixSum[j] - prefixSum[i] = k
        Then:
        prefixSum[i] = prefixSum[j] - k
        So while traversing the array, if we have already seen:

        prefixSum - k

        then we have found a subarray whose sum is k.
        That's why we store previous prefix sums in a HashMap.
        * */
        subarrayCount.put(0,1);
        for(int num:nums){
            prefixSum += num;
            count+=subarrayCount.getOrDefault(prefixSum-k,0);
            subarrayCount.put(prefixSum,subarrayCount.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(subarraySum(arr, k));
    }
}
