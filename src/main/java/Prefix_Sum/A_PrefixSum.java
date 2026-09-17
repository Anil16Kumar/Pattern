package Prefix_Sum;

import java.util.Scanner;

public class A_PrefixSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int val:prefix)
            System.out.println(val+" ");
    }
}
/*
Prefix Sum means storing the cumulative sum of an array.

arr = [1, 7, 3, 6, 5, 6]

The prefix-sum array is:
prefix = [1, 8, 11, 17, 22, 28]

Because:
prefix[0] = 1
prefix[1] = 1 + 7 = 8
prefix[2] = 1 + 7 + 3 = 11
prefix[3] = 1 + 7 + 3 + 6 = 17
prefix[4] = 1 + 7 + 3 + 6 + 5 = 22
prefix[5] = 1 + 7 + 3 + 6 + 5 + 6 = 28

Formula:
prefix[i] = prefix[i - 1] + arr[i]

2. Why Prefix Sum?
The main purpose is to calculate sum of a subarray quickly.

Suppose:
arr = [2, 4, 3, 7, 5]

We want:
sum(1 ... 3)

That is:
4 + 3 + 7 = 14

Prefix:
[2, 6, 9, 16, 21]

Using prefix sum:
sum(l ... r) = prefix[r] - prefix[l - 1]

Therefore:
sum(1 ... 3)
= prefix[3] - prefix[0]
= 16 - 2
= 14

Prefix Sum Applications

array/subarray
        ↓
sum of left / right / pivot / equilibrium
        ↓
sum of subarray

Prefix sums are commonly used for:

Subarray sum
Range sum
Left sum / right sum
Pivot index
Equilibrium index
Counting subarrays with a particular sum
Counting subarrays whose sum is divisible by k

=========================================================

Prefix Sum + HashMap Pattern

negative numbers
        ↓
sum(i...j) == k
OR
sum(i...j) % k == 0
        ↓
we'll use HashMap


Why HashMap?
Suppose:
prefixSum[j] - prefixSum[i] = k
Then:
prefixSum[i] = prefixSum[j] - k

So while traversing the array, if we have already seen:

prefixSum - k

then we have found a subarray whose sum is k.
That's why we store previous prefix sums in a HashMap.

8. Count Subarrays With Sum Exactly K

public int subarraySum(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);

    int prefixSum = 0;
    int count = 0;

    for (int num : nums) {

        prefixSum += num;

        count += map.getOrDefault(prefixSum - k, 0);

        map.put(
            prefixSum,
            map.getOrDefault(prefixSum, 0) + 1
        );
    }

    return count;
}
* */