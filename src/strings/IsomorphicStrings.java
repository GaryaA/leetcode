package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (maps.containsKey(c1) && maps.get(c1) != c2) {
                return false;
            }
            if (mapt.containsKey(c2) && mapt.get(c2) != c1) {
                return false;
            }
            maps.put(c1, c2);
            mapt.put(c2, c1);
        }
        return true;
    }

}
