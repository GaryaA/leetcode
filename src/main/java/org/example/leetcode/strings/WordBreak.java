package org.example.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        System.out.println(s);
        List<String> list = new ArrayList<>();//"cats","dog","sand","and","cat"
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(new WordBreak().wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[s.length()];
    }

}
