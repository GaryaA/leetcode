package utils;

import java.util.*;

public class TreeNodeFactory {

    public static TreeNode create(String str) {
        String numsStr = str.replace("[", "").replace("]", "");
        if (numsStr.isEmpty()) {
            return null;
        }
        return create(
                Arrays.stream(numsStr.split(","))
                        .map(s -> "null".equals(s) ? null : Integer.parseInt(s)).toList()
        );
    }

    public static TreeNode create(List<Integer> listNodes) {
        List<Integer> list = new ArrayList<>(listNodes);
        TreeNode root = new TreeNode(list.removeFirst());
        if (list.isEmpty()) return root;

        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));

        List<TreeNode> prevNodes = null;
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.poll();
            if (prevNodes != null) {
                setUpChildren(prevNodes, nodes);
            }

            List<TreeNode> children = list.subList(0, Math.min(list.size(), nodes.stream().filter(Objects::nonNull).toList().size() * 2))
                    .stream().map(n -> n == null ? null : new TreeNode(n)).toList();

            list = list.subList(children.size(), list.size());

            if (!children.isEmpty()) {
                queue.offer(children);
            }
            prevNodes = nodes;
        }

        return root;
    }

    private static void setUpChildren(List<TreeNode> parents, List<TreeNode> children) {
        List<TreeNode> copyChildren = new ArrayList<>(children);
        for (TreeNode parent : parents) {
            if (parent == null) continue;
            parent.left = getChildAndUpdate(copyChildren);
            parent.right = getChildAndUpdate(copyChildren);
        }
    }

    private static TreeNode getChildAndUpdate(List<TreeNode> children) {
        if (children.isEmpty()) return null;
        return children.removeFirst();
    }

}
