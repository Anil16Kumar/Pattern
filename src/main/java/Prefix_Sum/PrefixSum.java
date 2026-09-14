package Prefix_Sum;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int val:prefix)
            System.out.println(val+" ");
    }
}
