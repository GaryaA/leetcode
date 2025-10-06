package org.example.leetcode.recursion;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        StringBuilder r = new StringBuilder();
        StringBuilder nStr = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                nStr.append(ch);
                continue;
            }
            if (ch == '[') {
                String innerStr = getInnerStrToDecode(s.substring(i + 1));
                String decodedInnerStr = decodeString(innerStr);
                for (int j = 0; j < Integer.parseInt(nStr.toString()); j++) {
                    r.append(decodedInnerStr);
                }
                i += innerStr.length() + 1;
                nStr.setLength(0);
                continue;
            }
            r.append(ch);
        }
        return r.toString();

    }

    private String getInnerStrToDecode(String s) {
        Stack<Character> paranthesesStack = new Stack<>();
        StringBuilder r = new StringBuilder();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '[' -> {
                    paranthesesStack.push(ch);
                    r.append(ch);
                }
                case ']' -> {
                    if (paranthesesStack.isEmpty()) {
                        return r.toString();
                    } else {
                        paranthesesStack.pop();
                        r.append(ch);
                    }
                }
                default -> r.append(ch);
            }
        }
        throw new IllegalStateException();
    }

}
