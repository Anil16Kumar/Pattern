package Stack;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Stack<Character> stk=new Stack<>();
        for(char ch: s.toCharArray()){
           if(stk.isEmpty() || stk.peek()!=ch)
               stk.add(ch);
           else
               stk.pop();

        }
        StringBuilder answer= new StringBuilder();
        while(!stk.isEmpty()){
            answer.append(stk.pop());
        }
        answer.reverse();
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(removeDuplicates(str));
    }
}
