package strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams242 {

    public static void main(String[] args) {

        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            char tChar = tChars[i];
            map.compute(sChar, (_, count) -> count == null ? 1 : count + 1);
            map.compute(tChar, (_, count) -> count == null ? -1 : count - 1);
        }
        return map.values().stream().allMatch(count -> count == 0);
    }

}
