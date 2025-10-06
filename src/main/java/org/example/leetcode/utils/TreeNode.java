package org.example.leetcode.utils;

public class TreeNode implements TreeNodePrintable, Cloneable {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public TreeNode getLeft() {
        return left;
    }

    @Override
    public TreeNode getRight() {
        return right;
    }

//    @Override
//    public String toString() {
//        return TreeNodeUtils.toString(this);
//    }

}
