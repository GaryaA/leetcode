package trees;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {

        {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);

            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.left = new TreeNode(5);
            root.right.right.right = new TreeNode(1);

            System.out.println(pathSum(root, 22));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            System.out.println(pathSum(root, 5));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            System.out.println(pathSum(root, 0));
        }

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return searchPathSumDfs(root, targetSum, 0, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> searchPathSumDfs(TreeNode node, int targetSum, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return result;
        sum += node.val;
        currentPath.add(node.val);

        if (node.left == null && node.right == null) {
            if (targetSum == sum) {
                result.add(currentPath);
            }
            return result;
        }
        searchPathSumDfs(node.left, targetSum, sum, new ArrayList<>(currentPath), result);
        searchPathSumDfs(node.right, targetSum, sum, new ArrayList<>(currentPath), result);
        return result;
    }

}
