package trees;

import utils.TreeNode;
import utils.TreeNodeUtils;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
//        {
//            TreeNode root = new TreeNode(-10);
//            root.left = new TreeNode(9);
//            root.right = new TreeNode(20);
//            root.right.left = new TreeNode(15);
//            root.right.right = new TreeNode(7);
//            TreeNodePrinter.print(root);
//            System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
//        }
//        {
//            TreeNode root = new TreeNode(-3);
//            System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
//        }
//        {
//            TreeNode root = new TreeNode(2);
//            root.left = new TreeNode(-1);
//            System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
//        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(-2);
            root.right = new TreeNode(-3);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.left = new TreeNode(-2);
            root.left.left.left = new TreeNode(-1);
            TreeNodeUtils.print(root);
            System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
        }
    }

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDfs(root);
        return maxValue;
    }

    private int maxPathDfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDfs(node.left));
        int right = Math.max(0, maxPathDfs(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

}
