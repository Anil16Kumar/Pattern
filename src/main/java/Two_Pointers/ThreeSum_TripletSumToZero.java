package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum_TripletSumToZero {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return answer;

        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            // Skip duplicate values for 'left'
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            int mid = left + 1;
            int right = nums.length - 1;

            while (mid < right) {
                int currentSum = nums[left] + nums[mid] + nums[right];

                if (currentSum == 0) {
                    answer.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;

                    // Skip duplicates
                    while (mid < right && nums[mid] == nums[mid - 1])
                        mid++;
                    while (mid < right && nums[right] == nums[right + 1])
                        right--;

                } else if (currentSum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int Arr[]=new int[n];

        for(int i=0;i<n;i++)
            Arr[i]=scanner.nextInt();

        System.out.println(threeSum(Arr));
    }
}
