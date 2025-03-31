package trees;

import utils.TreeNode;

import static utils.TreeNodeUtils.print;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            print(root);
            System.out.println(isBalanced(root));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(3);
            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(4);
            print(root);
            System.out.println(isBalanced(root));
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        if (Math.abs(depth(p) - depth(q)) > 1) {
            return false;
        }
        return isBalanced(p) && isBalanced(q);
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
