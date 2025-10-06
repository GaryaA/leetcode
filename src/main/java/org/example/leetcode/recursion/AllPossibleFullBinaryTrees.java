package org.example.leetcode.recursion;

import org.example.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT(n, new HashMap<>());
    }

    private List<TreeNode> allPossibleFBT(int n, Map<Integer, List<TreeNode>> cache) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> leftBranch = allPossibleFBT(i, cache);
            List<TreeNode> rightBranch = allPossibleFBT(n - i - 1, cache);
            for (TreeNode leftNode : leftBranch) {
                for (TreeNode rightNode : rightBranch) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = leftNode;
                    curr.right = rightNode;
                    res.add(curr);
                }
            }
        }
        cache.put(n, res);
        return res;
    }

//    public List<TreeNode> allPossibleFBT(int n) {
//        if (n < 1 || n % 2 == 0) {
//            return new ArrayList<>();
//        }
//        TreeNode root = new TreeNode(0);
//        List<TreeNode> prevStepFBTs = new ArrayList<>();
//        prevStepFBTs.add(root);
//        if (n == 1) {
//            return prevStepFBTs;
//        }
//        for (int i = 3; i <= n; i += 2) {
//            prevStepFBTs = plusTwoVertices(prevStepFBTs, new ArrayList<>());
//        }
//        return prevStepFBTs;
//    }
//
//    private List<TreeNode> plusTwoVertices(List<TreeNode> prevStepFBTs, List<TreeNode> allPossibleFBTs) {
//        for (TreeNode prevStepFBT : prevStepFBTs) {
//            plusTwoVertices(prevStepFBT, prevStepFBT, allPossibleFBTs, new StringBuilder());
//        }
//        return allPossibleFBTs;
//    }
//
//    private List<TreeNode> plusTwoVertices(TreeNode fbt, TreeNode currV, List<TreeNode> allPossibleFBTs, StringBuilder path) {
//        if (currV.left == null) {
//            TreeNode plusOnePossibleFBT = TreeNodeUtils.copy(fbt);
//            TreeNode currVCopy = TreeNodeUtils.findSameTreeNode(plusOnePossibleFBT, fbt, currV, path.toString());
//            currVCopy.left = new TreeNode(0);
//            currVCopy.right = new TreeNode(0);
//            if (allPossibleFBTs.stream().noneMatch(possibleFBT -> TreeNodeUtils.isSameTree(possibleFBT, plusOnePossibleFBT))) {
//                allPossibleFBTs.add(plusOnePossibleFBT);
//            }
//            return allPossibleFBTs;
//        }
//        StringBuilder leftPath = new StringBuilder(path);
//        leftPath.append("0");
//        StringBuilder rightPath = new StringBuilder(path);
//        rightPath.append("1");
//        plusTwoVertices(fbt, currV.left, allPossibleFBTs, leftPath);
//        plusTwoVertices(fbt, currV.right, allPossibleFBTs, rightPath);
//        return allPossibleFBTs;
//    }


}
