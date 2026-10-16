package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static boolean canPlace(int[] stalls, int cows, int dist){
            int count=1;
            int lastPlace = stalls[0];
            for(int i=1;i<stalls.length;i++) {

                if(stalls[i] - lastPlace>=dist) {
                    count++;
                    lastPlace = stalls[i];
                }

                if(count >= cows) {
                    return true;
                }
            }
            return false;
    }
    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[stalls.length-1] - stalls[0];

        int answer = 0;
        while(low <= high){

            int mid = low + (high - low)/2;

            if(canPlace(stalls, cows, mid)){
                answer = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return  answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] stalls=new int[n];
        for(int i=0;i<n;i++)
            stalls[i]=scanner.nextInt();

        int cows=scanner.nextInt();
        System.out.println(aggressiveCows(stalls, cows));
    }
}
/*
Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct.
There are k aggressive cows.

Assign the cows to the stalls such that the minimum distance between any two cows is maximized.

Examples:

Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3].
The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all
valid arrangements.
Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement,
the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all
valid arrangements.
Constraints:

arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 10^8
2 ≤ k ≤ arr.size()
* */