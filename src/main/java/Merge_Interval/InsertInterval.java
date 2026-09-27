package Merge_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {

    public static int[][] mergeTheInterval(int[][] intervals){
        if(intervals.length == 0)
            return intervals;
        int len=intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));

        List<int[]> answer=new ArrayList<>();
        int start1=intervals[0][0];
        int end1=intervals[0][1];

        for(int i=1;i<len;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];

            if(end1>=start2){
                end1=Math.max(end1, end2);
            } else {
                answer.add(new int[]{start1,end1});
                start1=start2;
                end1=end2;
            }
        }
        answer.add(new int[]{start1, end1});
        return answer.toArray(new int[answer.size()][]);
    }
    public static int[][] insertThe(int[][] intervals, int[] newInterval) {

        if(intervals.length<1)
            return new int[][]{newInterval};

        List<int[]> addIntervalList=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(newInterval[0]<intervals[i][0])
                addIntervalList.add(newInterval);
            addIntervalList.add(intervals[i]);
        }

        if(intervals[0][0]>=newInterval[0])
            addIntervalList.add(0, newInterval);
        if(intervals[intervals.length - 1][0]<=newInterval[0])
            addIntervalList.add(newInterval);

        return mergeTheInterval(addIntervalList.toArray(new int[addIntervalList.size()][]));
    }

    /* -------------------------------------------2nd way-------------------------------------------------------- */

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

// Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

// Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

// Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

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

        int[] newInterval = new int[2];
        newInterval[0]=scanner.nextInt();
        newInterval[1]=scanner.nextInt();

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
