package Merge_Interval;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumRoomNeededForNmeeting_MeetingRoom2 {
    public static int minMeetingRooms(int[] start, int[] end) {

        //check in -> add room, check out-> remove room
        // one thing we can do add both array into single array and sort them, in that case we need to store
        // them in a pair, <value, checkIn/checkOut>, and based on check in/check out we add remove the room's
        // accordingly, but we can write in more optimize manner, sort both array separately and then use 2-pointer...

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxRooms = 0;

        int i = 0, j = 0;
        int n = start.length;

        while (i < n) {
            if (start[i] < end[j]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] checkIn=new int[n];
        for(int i=0;i<n;i++)
            checkIn[i]=scanner.nextInt();

        int[] checkOut=new int[n];
        for(int i=0;i<n;i++)
            checkOut[i]=scanner.nextInt();

        System.out.println(minMeetingRooms(checkIn, checkOut));
    }
}
