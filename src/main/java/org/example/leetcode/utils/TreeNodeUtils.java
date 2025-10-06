package org.example.leetcode.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TreeNodeUtils {

    public static TreeNode copy(TreeNode src) {
        TreeNode left = null;
        TreeNode right = null;
        if (src.left != null) {
            left = copy(src.left);
        }
        if (src.right != null) {
            right = copy(src.right);
        }
        return new TreeNode(src.val, left, right);
    }

    public static TreeNode findSameTreeNode(TreeNode root1, TreeNode root2, TreeNode q) {
        String pathFromRootQ = getPathFromRoot(root2, q);
        return findSameTreeNode(root1, root2, q, pathFromRootQ);
    }

    public static TreeNode findSameTreeNode(TreeNode root1, TreeNode root2, TreeNode q, String pathFromRootQ) {
        if (pathFromRootQ == null) return null;
        for (char ch : pathFromRootQ.toCharArray()) {
            root1 = switch (ch) {
                case '0' -> root1.left == null ? null : root1.left;
                case '1' -> root1.right == null ? null : root1.right;
                default -> throw new IllegalArgumentException();
            };
        }
        if (isSameTree(root1, q)) return root1;
        else return null;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeFromRoots(TreeNode root1, TreeNode p, TreeNode root2, TreeNode q) {
        if (!isSameTree(p, q)) return false;
        return Objects.equals(getPathFromRoot(root1, p), getPathFromRoot(root2, q));
    }

    public static String getPathFromRoot(TreeNode root, TreeNode v) {
        return getPathFromRoot(root, v, new StringBuilder()).toString();
    }

    private static StringBuilder getPathFromRoot(TreeNode root, TreeNode v, StringBuilder sb) {
        if (root == null) return null;
        if (root == v) return sb;
        if (root.left != null) {
            StringBuilder sbLeft = new StringBuilder(sb);
            sbLeft.append("0");
            StringBuilder r = getPathFromRoot(root.left, v, sbLeft);
            if (r != null) return r;
        }
        if (root.right != null) {
            StringBuilder sbRight = new StringBuilder(sb);
            sbRight.append("1");
            return getPathFromRoot(root.right, v, sbRight);
        }
        return null;
    }

    public static String toString(TreeNodePrintable root) {
        StringBuilder r = new StringBuilder();
        r.append("\n");
        int maxLevel = TreeNodeUtils.maxLevel(root);
        return r.append(printNodeInternal(Collections.singletonList(root), 1, maxLevel, new StringBuilder())).toString();
    }

    public static void print(TreeNodePrintable root) {
        System.out.println(toString(root));
    }

    private static StringBuilder printNodeInternal(List<TreeNodePrintable> nodes, int level, int maxLevel, StringBuilder sb) {
        if (nodes.isEmpty() || TreeNodeUtils.isAllElementsNull(nodes))
            return sb;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreeNodeUtils.printWhitespaces(firstSpaces, sb);

        List<TreeNodePrintable> newNodes = new ArrayList<TreeNodePrintable>();
        for (TreeNodePrintable node : nodes) {
            if (node != null) {
                sb.append(node.getVal());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                sb.append(" ");
            }

            TreeNodeUtils.printWhitespaces(betweenSpaces, sb);
        }
        sb.append("\n");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                TreeNodeUtils.printWhitespaces(firstSpaces - i, sb);
                if (nodes.get(j) == null) {
                    TreeNodeUtils.printWhitespaces(endgeLines + endgeLines + i + 1, sb);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    sb.append("/");
                else
                    TreeNodeUtils.printWhitespaces(1, sb);

                TreeNodeUtils.printWhitespaces(i + i - 1, sb);

                if (nodes.get(j).getRight() != null)
                    sb.append("\\");
                else
                    TreeNodeUtils.printWhitespaces(1, sb);

                TreeNodeUtils.printWhitespaces(endgeLines + endgeLines - i, sb);
            }

            sb.append("\n");
        }

        return printNodeInternal(newNodes, level + 1, maxLevel, sb);
    }

    private static void printWhitespaces(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++)
            sb.append(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNodePrintable node) {
        if (node == null)
            return 0;

        return Math.max(TreeNodeUtils.maxLevel(node.getLeft()), TreeNodeUtils.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
