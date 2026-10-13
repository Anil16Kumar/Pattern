package BinarySearch;

import java.util.Scanner;

public class SearchElementInRotatedArray_OneLoopIterationOnly {

    /*
        |
     |  |
     |  |
  |  |  |
  |  |  |        |
  |  |  |        |
  |  |  |     |  |
  |  |  |  |  |  |
  5  6  7  1  2  4

  part 2: 5,6,7
  part 1: 1,2,4

  rotated array.
    * */
    public static int searchElementInOneLoopItreration(int[] nums, int target){
        int len=nums.length;
        int low=0, high=len-1;
        int answer=-1;
        while(low<=high){
            int mid=low + (high-low)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid]>nums[len-1]){ // part 1
                if(nums[mid]>target){
                    if(nums[0]>target)
                        low = mid+1;
                    else
                        high = mid-1;
                } else {
                    low = mid+1;
                }
            } else { //part 2
                if(nums[mid]>target){
                    high = mid-1;
                } else {
                    if(nums[len-1]<target)
                        high = mid-1;
                    else
                        low = mid+1;
                }
            }
        }
        return  answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] Arr=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(searchElementInOneLoopItreration(Arr, target));
    }
}
