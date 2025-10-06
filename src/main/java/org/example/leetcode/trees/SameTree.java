package org.example.leetcode.trees;

import org.example.leetcode.utils.TreeNode;
import org.example.leetcode.utils.TreeNodeUtils;

import static org.example.leetcode.utils.TreeNodeUtils.print;

public class SameTree {

    public static void main(String[] args) {
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);

            print(root);
            print(root1);
            System.out.println(isSameTree(root, root1));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);

            TreeNode root1 = new TreeNode(1);
            root1.right = new TreeNode(2);

            print(root);
            print(root1);
            System.out.println(isSameTree(root, root1));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(1);

            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(1);
            root1.right = new TreeNode(2);

            print(root);
            print(root1);
            System.out.println(isSameTree(root, root1));
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return TreeNodeUtils.isSameTree(p, q);
    }

}
