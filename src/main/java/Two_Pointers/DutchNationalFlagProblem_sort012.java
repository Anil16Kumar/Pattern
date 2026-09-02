package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class DutchNationalFlagProblem_sort012 {

    public static void sort012(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while (mid <= right) {
            if (arr[mid] == 0) {
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}
