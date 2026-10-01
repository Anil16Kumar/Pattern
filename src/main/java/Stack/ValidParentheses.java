package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isOpen(char ch){
        return ch == '(' || ch == '{' || ch == '[';
    }
    public static boolean isClose(char ch){
        return ch == ')' || ch == '}' || ch == ']';
    }
    public static boolean isMatch(char c1, char c2){
        return (c1 == '(' && c2 == ')') ||
                (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']');
    }
    public static boolean isValid(String s) {
        if(s.length()%2==1)
            return false;

        Stack<Character> stk=new Stack<>();
        for(char ch: s.toCharArray()){
            if(stk.isEmpty() || isOpen(ch))
                stk.add(ch);

            else if(isClose(ch)){
                if(isMatch(stk.peek(), ch))
                    stk.pop();
                else
                    return false;
            }
        }

        return stk.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(isValid(str));
    }
}
