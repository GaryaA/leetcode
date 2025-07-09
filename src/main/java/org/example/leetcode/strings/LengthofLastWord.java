package org.example.leetcode.strings;

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] wArr = s.split(" ");
        return wArr[wArr.length - 1].length();
    }

}
