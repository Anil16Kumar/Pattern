package Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxConsecutiveOneWith_Exactly_KFlips {
    public static int maxOnes(int arr[], int k) {
        if(arr.length==0 || k>arr.length)
            return -1;

        int left=0;
        int answerLength=Integer.MIN_VALUE;
        Map<Integer, Integer> mp=new HashMap<>();

        for(int right=0;right<arr.length;right++){
            mp.put(arr[right], mp.getOrDefault(arr[right],0)+1);

            // for exactly k
            while( ((right-left+1)-mp.get(1))>k){
                if(arr[left]==1)
                    mp.put(1,mp.get(1)-1);
                left++;
            }

            /*
            // allow at most k zeros, not exactly k
                while(((right-left+1) - mp.getOrDefault(1,0)) > k){
                    if(arr[left]==1)
                        mp.put(1, mp.get(1)-1);
                    left++;
                }
            * */

            answerLength=Math.max(answerLength,(right-left+1));
        }
        return answerLength;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println(maxOnes(arr, k));
    }
}
