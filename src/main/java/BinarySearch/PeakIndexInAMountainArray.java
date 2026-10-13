package BinarySearch;

import java.util.Scanner;

public class PeakIndexInAMountainArray {


    /*
//        5
//       / \
//      /   \
//     3     4
//    /       \
//   1         2
//
// Mountain Array: [1, 3, 5, 4, 2]
    *
    * */
    public static int peakIndexInMountainArray_pat(int[] arr) {
        int len=arr.length;
        int low=0, high=len-1;
        int answer=-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]<arr[mid + 1]){
                low=mid+1;
            } else {
                answer=mid;
                high=mid-1;
            }
        }
        return answer;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int len=arr.length;
        int low=0, high= len-1;

        while(low<high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            } else if(arr[mid] < arr[mid+1]){
                low = mid+1;
            } else {
                high = mid;
                /*It could be mid itself (could be the answer)
                    Or somewhere to the left.
                this is why, high = mid not high = mid - 1; because this else condition will hit
                when arr[mid] > arr[mid+1], so this mid could be the potential answer, that is why we still
                consider this mid, keep it as the part of our answer...
*/
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(peakIndexInMountainArray(arr));
    }
}
/*
You are given an integer mountain array arr of length n where the values increase to a peak element
and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.



Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1



Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
* */