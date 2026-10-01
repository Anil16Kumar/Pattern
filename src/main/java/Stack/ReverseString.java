package Stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        StringBuilder str= new StringBuilder("abcdefghi");
        Stack<Character> stk=new Stack<>();

        for(char ch: str.toString().toCharArray())
            stk.add(ch);

        str = new StringBuilder();

        while(!stk.isEmpty()){
            str.append(stk.peek());
            stk.pop();
        }
        System.out.println(str);
    }
}
