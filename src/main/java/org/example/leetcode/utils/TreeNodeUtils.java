package org.example.leetcode.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNodeUtils {

    public static void print(TreeNodePrintable root) {
        int maxLevel = TreeNodeUtils.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNodePrintable> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreeNodeUtils.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreeNodeUtils.printWhitespaces(firstSpaces);

        List<TreeNodePrintable> newNodes = new ArrayList<TreeNodePrintable>();
        for (TreeNodePrintable node : nodes) {
            if (node != null) {
                System.out.print(node.getVal());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            TreeNodeUtils.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                TreeNodeUtils.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    TreeNodeUtils.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    TreeNodeUtils.printWhitespaces(1);

                TreeNodeUtils.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    TreeNodeUtils.printWhitespaces(1);

                TreeNodeUtils.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
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
