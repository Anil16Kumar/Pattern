package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Pair<T,S>{
    T first;
    S second;

    Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
}
public class RemoveAllAdjacentDuplicatesInStringII {
    public static String removeDuplicates(String s, int k) {

        Stack<Pair<Character, Integer>> stk = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stk.isEmpty() && stk.peek().first == ch) {

                stk.peek().second++;

                if (stk.peek().second == k) {
                    stk.pop();
                }

            } else {
                stk.push(new Pair<>(ch, 1));
            }
        }

        StringBuilder answer = new StringBuilder();

        for (Pair<Character, Integer> p : stk) {

            for (int i = 0; i < p.second; i++) {
                answer.append(p.first);
            }
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int k=scanner.nextInt();

        System.out.println(removeDuplicates(str, k));
    }
}
