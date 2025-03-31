package org.example.leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        String[] arrPaths = path.split("/");
        if (arrPaths.length == 1) return path;

        Stack<String> stack = new Stack<>();
        for (String arrPath : arrPaths) {
            if (arrPath.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            if (arrPath.isEmpty() || arrPath.equals(".")) continue;

            stack.push(arrPath);
        }
        return toPath(stack);
    }

    private String toPath(Stack<String> stack) {
        if (stack.isEmpty()) return "/";
        List<String> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
            list.add("/");
        }
        return String.join("", list.reversed());
    }

//    private void popSlash(Stack<Character> stack) {
//        if (stack.size() > 1 && stack.peek() == '/') stack.pop();
//    }
//
//    private void pollWord(Stack<Character> stack) {
//        while (!stack.isEmpty() && stack.peek() != '/') stack.pop();
//    }
//
//    private String toString(Stack<Character> stack) {
//        StringBuilder res = new StringBuilder();
//        while (!stack.isEmpty()) {
//            res.append(stack.pop());
//        }
//        return res.reverse().toString();
//    }

}
