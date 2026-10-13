package BinarySearch;

import java.util.Scanner;

public class searchElementInARotatedSortedArray {

// solution in one iteration inside "SearchElementInRotatedArray_OneLoopIterationOnly"
    public static int minimumValuePoint_pivot(int[] nums){
        int answer=-1;
        int len=nums.length;
        int low=0, high=len-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(nums[mid]>nums[len-1]){
                low=mid+1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    public static int SearchElementHelper(int[] nums, int low, int high, int target){
        int answer=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]>target){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return answer;
    }
// solution in one iteration inside "SearchElementInRotatedArray_OneLoopIterationOnly"
    public static int SearchElement(int[] nums, int target){
        int len=nums.length;
        int minimumPivotPoint = minimumValuePoint_pivot(nums);
        int searchFirstPart = SearchElementHelper(nums, 0, minimumPivotPoint - 1, target);
        int searchSecondPart = SearchElementHelper(nums, minimumPivotPoint, len - 1, target);

        return (searchFirstPart==-1 && searchSecondPart==-1) ? -1 : (searchFirstPart==-1) ? searchSecondPart : searchFirstPart;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] Arr=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(SearchElement(Arr, target));
    }
}
