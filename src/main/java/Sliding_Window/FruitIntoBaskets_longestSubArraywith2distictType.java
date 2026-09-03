package Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FruitIntoBaskets_longestSubArraywith2distictType {

    public static int FruitIntoBaskets_LongestSubarrayWith2DistinedTypeOfFruit(int[] arr){
        if (arr.length == 1)
            return 1;

        int left = 0;
        int answerLength = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);

            while (mp.size() > 2) {
                mp.put(arr[left], mp.get(arr[left]) - 1);
                if (mp.get(arr[left]) == 0)
                    mp.remove(arr[left]);
                left++;
            }

            answerLength = Math.max(answerLength, right - left + 1);
        }
        return answerLength;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        System.out.println(FruitIntoBaskets_LongestSubarrayWith2DistinedTypeOfFruit(arr));
    }
}
