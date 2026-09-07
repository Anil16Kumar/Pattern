package Sliding_Window;

import java.util.Scanner;

public class SubarraysProductLessThanK {
    public static int countProductSubarray(int[] arr, int k) {
        if(arr.length==0)
            return -1;

        int prod=1;
        int left=0, answer=0;
        for(int right=0;right<arr.length;right++){
            prod*=arr[right];
            while (prod>=k && left<=right){
                prod/=arr[left];
                left++;
            }
            if(prod<k)
                answer+=(right-left+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(countProductSubarray(arr, k));

    }
}
