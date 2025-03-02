package strings;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String s = "(a)())()";

        System.out.println(removeInvalidParentheses(s));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> r = new ArrayList<>();
        if (!s.contains("(") && !s.contains(")")) {
            r.add(s);
            return r;
        }
        char[] sChars = s.toCharArray();
        while (s.startsWith(")")) {
            s = s.substring(1);
        }
        Set<String> correctStrings = funcBfs(s, new HashSet<>());
        if (correctStrings.isEmpty()) {
            r.add("");
        } else {
            r.addAll(correctStrings);
        }
        return r;
    }

    public static Set<String> funcBfs(String s, Set<String> uniqueStrings) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);

        Set<String> r = new HashSet<>();
        int depth = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            String str = queue.remove();
            uniqueStrings.add(str);
            Set<String> removals = removals(str, 0);
            if (removals.isEmpty()) {
                r.add(str);
                return r;
            }
            for (String removal : removals) {
                if (s.length() - removal.length() > depth) {
                    return r;
                }
                if (isValidParentheses(removal)) {
                    depth = s.length() - removal.length();
                    r.add(removal);
                }
            }
            for (String removal : removals) {
                if (uniqueStrings.contains(removal)) {
                    continue;
                }
                queue.add(removal);
            }

        }
        return r;
    }

    public static Set<String> removals(String s, int start) {
        Set<String> r = new HashSet<>();
        if (isValidParentheses(s)) {
            return r;
        }
        int idxToRemove;
        while ((idxToRemove = oneIdxToRemove(s, start)) != -1) {
            String removal = s.substring(0, idxToRemove) + s.substring(idxToRemove + 1);
            r.add(removal);
            start = idxToRemove + 1;
        }
        return r;
    }

    public static int oneIdxToRemove(String s, int start) {
        char[] sChars = s.toCharArray();
        int countOpened = 0, countClosed = 0;
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            if (sChar == '(') {
                countOpened++;
            }
            if (sChar == ')') {
                countClosed++;
            }
        }
        return countOpened >= countClosed ? s.indexOf("(", start) : s.indexOf(")", start);
    }

    public static boolean isValidParentheses(String s) {
        if (!s.contains("(") && !s.contains(")")) {
            return true;
        }
        char[] sChars = s.toCharArray();
        int countOpened = 0, countClosed = 0;
        for (char c : sChars) {
            if (c == '(') {
                countOpened++;
            }
            if (c == ')') {
                countClosed++;
            }
            if (countClosed > countOpened) {
                return false;
            }
        }
        if (countOpened > countClosed) {
            return false;
        }
        return true;
    }
}
