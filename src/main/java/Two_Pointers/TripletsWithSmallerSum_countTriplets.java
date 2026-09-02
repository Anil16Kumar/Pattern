package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class TripletsWithSmallerSum_countTriplets {

    public static int countTriplets(int sum, int arr[]) {
        if(arr.length<3 || arr==null)
            return -1;

        Arrays.sort(arr);
        int count=0;

        for(int left=0; left<arr.length;left++){
            int mid=left+1;
            int right=arr.length-1;
            while(mid<right){
                int currentSum=arr[left]+arr[mid]+arr[right];
                if(currentSum<sum){
                    count+=(right-mid);
                    mid++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        int sum=scanner.nextInt();
        System.out.println(countTriplets(sum, arr));
    }
}

/*
Given an array arr[] of distinct integers and an integer sum, count the number of unique triplets of elements whose sum is strictly less than sum. A triplet is identified only by the three elements it contains, so different permutations of the same three elements are counted as one triplet.

Examples :

Input: sum = 2, arr[] = [-2, 0, 1, 3]
Output:  2
Explanation: Triplets with sum less than 2 are (-2, 0, 1) and (-2, 0, 3).
Input: sum = 12, arr[] = [5, 1, 3, 4, 7]
Output: 4
Explanation: Triplets with sum less than 12 are (1, 3, 4), (5, 1, 3), (1, 3, 7) and (5, 1, 4).
Constraints:

1 ≤ sum ≤ 105
3 ≤ arr.size() ≤ 103
-103 ≤ arr[i] ≤ 103
* */
