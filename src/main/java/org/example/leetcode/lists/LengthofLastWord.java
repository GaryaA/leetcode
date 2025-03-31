package org.example.leetcode.lists;

public class LengthofLastWord {

    public static void main(String[] args) {
        String s = " fly   moon  ";
        System.out.println(new LengthofLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] wArr = s.split(" ");
        return wArr[wArr.length - 1].length();
    }

}
