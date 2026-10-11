package BinarySearch;

import java.util.Scanner;

public class binarySearchTargetElement {
    public static int search(int[] nums, int target) {
        int low=0, high=nums.length-1;

        while (low<=high){
            int mid=(low + high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] > target)
                high = mid-1;
            else if(nums[mid] < target)
                low = mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int target = scanner.nextInt();
        System.out.println(search(arr, target));
    }
}
