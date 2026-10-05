package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pair<T,S>{
    T first;
    S second;
    Pair(T first, S second){
        this.first=first;
        this.second=second;
    }
}
public class FirstUniqueCharacterInaString {
    public static int firstUniqChar(String s) {

        Map<Character, Pair<Integer, Integer>> mp=new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(mp.get(ch)!=null){
                int count=mp.get(ch).first+1;
                int idx=i;
                mp.put(ch, new Pair<Integer, Integer>(count,idx));
            } else {
                mp.put(ch, new Pair<Integer, Integer>(1,i));
            }
        }

        int answer=Integer.MAX_VALUE;
        for(Character ch: mp.keySet()){
            if(mp.get(ch).first==1 && answer>mp.get(ch).second)
                answer=mp.get(ch).second;
        }

        return answer==Integer.MAX_VALUE ? -1 : answer;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(firstUniqChar(str));
    }
}
