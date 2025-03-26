package trees;

import utils.TreeNode;
import utils.TreeNodeFactory;
import utils.TreeNodePrinter;

import java.util.HashMap;

public class PathSumIII {

    public static void main(String[] args) {
        TreeNode root = TreeNodeFactory.create("10,5,-3,3,2,null,11,3,-2,null,1");
        TreeNodePrinter.print(root);
        System.out.println(new PathSumIII().pathSum(root, 8));
    }

//    private int count = 0;
//
//    public int pathSum(TreeNode root, int targetSum) {
//        pathSumDfs(root, targetSum, new ArrayList<>());
//        return count;
//    }
//
//    private void pathSumDfs(TreeNode node, int targetSum, List<TreeNode> tracePath) {
//        if (node == null) return;
//        tracePath.add(node);
//
//        checkSum(tracePath, targetSum);
//
//        pathSumDfs(node.left, targetSum, new ArrayList<>(tracePath));
//        pathSumDfs(node.right, targetSum, new ArrayList<>(tracePath));
//    }
//
//    private void checkSum(List<TreeNode> nodes, int targetSum) {
//        if (nodes.isEmpty()) return;
//        if (nodes.size() == 1) {
//            if (nodes.getFirst().val == targetSum) count++;
//            return;
//        }
//        List<TreeNode> reversedNodes = nodes.reversed();
//        TreeNode curr = reversedNodes.getFirst();
//        if (curr.val == targetSum) {
//            count++;
//        }
//        long sum = curr.val;
//        for (int i = 1; i < reversedNodes.size(); i++) {
//            sum += reversedNodes.get(i).val;
//            if (sum == targetSum) {
//                count++;
//            }
//        }
//    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }


}
