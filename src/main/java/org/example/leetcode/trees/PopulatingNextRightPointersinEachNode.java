package org.example.leetcode.trees;

import org.example.leetcode.utils.Node;
import org.example.leetcode.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        TreeNodeUtils.print(new PopulatingNextRightPointersinEachNode().connect(root));
    }

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        Queue<Object> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Object currObj = q.poll();
            List<Node> childs = new ArrayList<>();
            switch (currObj) {
                case Node node -> {
                    if (node.left != null) {
                        node.left.next = node.right;
                    }
                    if (node.left != null || node.right != null) {
                        q.offer(List.of(node.left, node.right));
                    }
                }
                case List list -> {
                    Node prev = (Node) list.get(0);
                    if (prev.left != null || prev.right != null) {
                        childs.add(prev.left);
                        childs.add(prev.right);
                    }
                    for (int i = 1; i < list.size(); i++) {
                        Node curr = (Node) list.get(i);
                        if (prev != null) {
                            prev.next = curr;
                        }
                        if (curr.left != null || curr.right != null) {
                            childs.add(curr.left);
                            childs.add(curr.right);
                        }
                        prev = curr;
                    }
                }
                default -> {
                }
            }
            if (!childs.isEmpty()) {
                q.offer(childs);
            }
        }
        return root;
    }

}
