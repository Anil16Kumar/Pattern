package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int prefixSum=0;
        Map<Integer, Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        for(int num:nums){
            prefixSum += num;
            int remender=prefixSum%k;
            if(remender<0)
                remender+=k;
            count+=hashMap.getOrDefault(remender,0);
            hashMap.put(remender, hashMap.getOrDefault(remender,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(subarraysDivByK(arr, k));
    }
}

/*
How to Get a Subarray Sum Using Prefix Sum?

Suppose:
arr = [2, 3, 5, 7]

Prefix:
[2, 5, 10, 17]

Suppose we want:
[3, 5]
This is index 1 to 2.

We can calculate:
sum(1...2) = prefix[2] - prefix[0] = 10 - 2 = 8

Generally:
sum(i...j) = prefix[j] - prefix[i-1]

But there is an even more useful way to think about it.

The Most Important Formula

Suppose:
prefix[j] - prefix[i] = subarray sum

We want this subarray sum to be divisible by k.
So:
(prefix[j] - prefix[i]) % k == 0

Now comes the key mathematical observation:
If two numbers have the same remainder when divided by k, their difference is divisible by k.

For example, with:
k = 5

Consider:
12 % 5 = 2
7  % 5 = 2

Their difference:
12 - 7 = 5
and:
5 % 5 = 0

Another:
17 % 5 = 2
7  % 5 = 2

17 - 7 = 10
10 % 5 = 0

Therefore:
prefix[j] % k == prefix[i] % k
means:
(prefix[j] - prefix[i]) % k == 0
This is the entire trick.
Same remainder
      ↓
Difference divisible by K
      ↓
Subarray sum divisible by K


How to Get a Subarray Sum Using Prefix Sum?

Suppose:

arr = [2, 3, 5, 7]

Prefix:

[2, 5, 10, 17]

Suppose we want:

[3, 5]

This is index 1 to 2.

We can calculate:

sum(1...2)
=
prefix[2] - prefix[0]
=
10 - 2
=
8

Generally:

sum(i...j) = prefix[j] - prefix[i-1]

But there is an even more useful way to think about it.

6. The Most Important Formula

Suppose:

prefix[j] - prefix[i] = subarray sum

We want this subarray sum to be divisible by k.

So:

(prefix[j] - prefix[i]) % k == 0

Now comes the key mathematical observation:

If two numbers have the same remainder when divided by k, their difference is divisible by k.

For example, with:

k = 5

Consider:

12 % 5 = 2
7  % 5 = 2

Their difference:

12 - 7 = 5

and:

5 % 5 = 0

Another:

17 % 5 = 2
7  % 5 = 2

17 - 7 = 10

10 % 5 = 0

Therefore:

prefix[j] % k == prefix[i] % k

means:

(prefix[j] - prefix[i]) % k == 0
This is the entire trick.

Same remainder
      ↓
Difference divisible by K
      ↓
Subarray sum divisible by K


Now we need to find previous prefix sums having the same remainder.
Instead of storing every prefix sum, we store:
remainder → frequency

Example:
k = 5

Suppose we have seen:
remainder = 2
three times.

Then when another prefix sum has:
remainder = 2
we know that it forms a divisible subarray with each of those three previous prefix sums.

Therefore:
count += frequency
This is why we use a HashMap.


* */
