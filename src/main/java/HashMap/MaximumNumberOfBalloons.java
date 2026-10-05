package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumNumberOfBalloons {
    public static boolean isBalloonChar(char ch){
        return ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n';
    }
    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map=new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(Character ch: text.toCharArray()){
            if(isBalloonChar(ch))
                map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int answer=Integer.MAX_VALUE;
        for(Character ch: map.keySet()){
            int temp;
            if(ch=='b' || ch=='a' || ch=='n')
                temp = map.get(ch);
            else
                temp = map.get(ch)/2;

            answer = Math.min(answer, temp);
        }

        return  answer;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text = scanner.next();
        System.out.println(maxNumberOfBalloons(text));
    }
}
