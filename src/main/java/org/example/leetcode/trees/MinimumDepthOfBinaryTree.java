package org.example.leetcode.trees;

import utils.Pair;
import utils.TreeNode;
import utils.TreeNodeFactory;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {


    public static void main(String[] args) {
        TreeNode root = TreeNodeFactory.create("[]");
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode curr = pair.first();
            if (curr.left == null && curr.right == null) {
                return pair.second();
            }
            if (curr.left != null) {
                queue.add(new Pair<>(curr.left, pair.second() + 1));
            }
            if (curr.right != null) {
                queue.add(new Pair<>(curr.right, pair.second() + 1));
            }
        }
        return 0;
    }


}
