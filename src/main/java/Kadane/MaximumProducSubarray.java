package Kadane;

import java.util.Scanner;

public class MaximumProducSubarray {
    public static int maxProduct(int[] nums) {
        int maxAnswer=1;
        int minAnswer=1;
        int answer=Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            int v1=maxAnswer*nums[i];
            int v2=minAnswer*nums[i];
            int v3=nums[i];
            maxAnswer=Math.max(v3,Math.max(v2,v1));
            minAnswer=Math.min(v3,Math.min(v2,v1));
            answer=Math.max(answer, Math.max(maxAnswer,minAnswer));
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(maxProduct(arr));
    }
}
