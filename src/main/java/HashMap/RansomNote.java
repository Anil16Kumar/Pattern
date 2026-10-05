package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    public static boolean canConstruct_ConstantSpace(String ransomNote, String magazine) {

        int[] freq = new int[26];

        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (--freq[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomFreq=new HashMap<>();
        for(Character ch: ransomNote.toCharArray()){
            ransomFreq.put(ch,ransomFreq.getOrDefault(ch,0)+1);
        }

        Map<Character, Integer> magazineFreq = new HashMap<>();
        for(Character ch: magazine.toCharArray()){
            magazineFreq.put(ch,magazineFreq.getOrDefault(ch,0)+1);
        }

        for(Character ch:ransomFreq.keySet()){

            if(magazineFreq.get(ch)==null)
                return false;
            if( magazineFreq.get(ch)<ransomFreq.get(ch))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String ransomNote = scanner.next();
        String magazine = scanner.next();
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
