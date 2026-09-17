package Prefix_Sum;

import java.util.Scanner;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int arrayLength=nums.length;
        prefix[0] = nums[0];
        for(int i=1;i<arrayLength;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0;i<arrayLength;i++) {
            int leftSum=prefix[i]-nums[i];
            int rightSum=prefix[arrayLength-1]-prefix[i];
            /*
0  1   8   11  17  22 <- prefix[i]-arr[i] sum(0...i-1)
27 20  17  11   6   0<- prefix[n-1]-prefix[i]  sum(i+1...n-1)


(prefix[i]-arr[i]) + x +arr[i] = prefix[n-1]      {n=arr length
x=prefix[n-1] -(prefix[i])
x=prefix[n-1]-prefix[i]
            * */
            if(leftSum==rightSum)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(pivotIndex(arr));
    }
}
/*
1  7   3   6   5   6 <- arr
1  8  11  17  22  28 <-prefix

0  1   8   11  17  22 <- prefix[i]-arr[i] sum(0...i-1)
27 20  17  11   6   0<- prefix[n-1]-prefix[i]  sum(i+1...n-1)


(prefix[i]-arr[i]) + x +arr[i] = prefix[n-1]      {n=arr length
x=prefix[n-1] -(prefix[i])
x=prefix[n-1]-prefix[i]

*
* */