package BinarySearch;

import java.util.Scanner;

public class SearchInRotatedSortedArray {

    // bekar solution h, "searchElementInARotatedSortedArray" -> issme sahi solution h
    public static int pivitPoint(int[] arr){
        int n=arr.length;
        int low=0, high=n-1;

        while(low <= high){

            if(arr[low]<=arr[high])
                return low;

            int mid=low+(high-low)/2;
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;

            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
                return mid;
            } else if(arr[mid]<=arr[high]){
                high=mid-1;
            } else if(arr[mid]>=arr[low]){
                low=mid+1;
            }
        }
        return -1;
    }

    public static int searchEle(int[] nums,int low,int high, int target){
        int answer=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high= mid - 1;
            else
                low = mid + 1;
        }
        return answer;
    }

    public static int search(int[] nums, int target) {
        int len=nums.length;
        int piviotPoint = pivitPoint(nums);

        int firstPart = searchEle(nums, 0, piviotPoint-1, target);
        int secondPart = searchEle(nums, piviotPoint, len-1, target);

        return (firstPart==-1 && secondPart==-1) ? -1 : (firstPart==-1) ? secondPart : firstPart;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(search(arr, target));
    }
}
