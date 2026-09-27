package TrainOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
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
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] intervals=new int[n][2];

        for(int i=0;i<n;i++){
            intervals[i][0]=scanner.nextInt();
            intervals[i][1]=scanner.nextInt();
        }

        System.out.println(Arrays.deepToString(mergeTheInterval(intervals)));
    }
}
