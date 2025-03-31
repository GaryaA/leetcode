package org.example.leetcode.utils;

public class Node implements TreeNodePrintable {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public TreeNodePrintable getLeft() {
        return left;
    }

    @Override
    public TreeNodePrintable getRight() {
        return right;
    }
};
