package slidingwindow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PermutationinString {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "eidabfcdooo";
        System.out.println(new PermutationinString().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            int left = i - s1.length() + 1;
            if (left >= 0) {
                if (map1.entrySet().stream().allMatch(e ->
                        map2.containsKey(e.getKey()) && map2.get(e.getKey()).equals(e.getValue()))) {
                    return true;
                }
                Integer countFirstElem = map2.get(s2.charAt(left));
                if (countFirstElem == 1) {
                    map2.remove(s2.charAt(left));
                } else {
                    map2.put(s2.charAt(left), countFirstElem - 1);
                }
            }
        }
        return false;
    }

}
