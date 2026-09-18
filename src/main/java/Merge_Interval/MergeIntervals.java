package Merge_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) { // overlap
                end1 = Math.max(end1, end2);
            } else { // no overlap
                result.add(new int[]{start1, end1});

                start1 = start2;
                end1 = end2;
            }
        }

        // add last merged interval
        result.add(new int[]{start1, end1});

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] intervals=new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0]=scanner.nextInt();
            intervals[i][1]=scanner.nextInt();
        }
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
