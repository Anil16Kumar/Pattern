package Merge_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                ans.add(new int[]{start, end});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] A=new int[n][2];
        for(int i=0;i<n;i++){
            A[i][0]=scanner.nextInt();
            A[i][1]=scanner.nextInt();
        }

        int m=scanner.nextInt();
        int[][] B=new int[m][2];
        for(int i=0;i<m;i++){
            B[i][0]=scanner.nextInt();
            B[i][1]=scanner.nextInt();
        }

        System.out.println(Arrays.deepToString(intervalIntersection(A, B)));

    }
}
