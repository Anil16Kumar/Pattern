package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] answer=new int[temperatures.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }

            if(stk.isEmpty())
                answer[i]=0;
            else
                answer[i]=stk.peek() - i;

            stk.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int[] temperature = new int[n];
        for(int i=0;i<n;i++)
            temperature[i]=scanner.nextInt();

        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }
}
