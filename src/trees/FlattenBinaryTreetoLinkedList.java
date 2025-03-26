package trees;

import utils.TreeNode;
import utils.TreeNodeFactory;
import utils.TreeNodePrinter;

import java.util.List;

public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode root = TreeNodeFactory.create("1,2,5,3,4,null,6");
        TreeNodePrinter.print(root);
        new FlattenBinaryTreetoLinkedList().flatten(root);
        TreeNodePrinter.print(root);
    }

    //    public void flatten(TreeNode root) {
//        List<TreeNode> nodes = new ArrayList<>();
//        fillOrderedList(root, nodes);
//        if (nodes.size() < 2) {
//            return;
//        }
//        for (int i = 1; i < nodes.size(); i++) {
//            root.right = nodes.get(i);
//            root.left = null;
//            root = root.right;
//        }
//    }

//    private void fillOrderedList(TreeNode node, List<TreeNode> list) {
//        if (node == null) return;
//        list.add(node);
//
//        fillOrderedList(node.left, list);
//        fillOrderedList(node.right, list);
//
//    }

//    private TreeNode prev = null;
//
//    public void flatten(TreeNode root) {
//        if (root == null)
//            return;
//        flatten(root.right);
//        flatten(root.left);
//        root.right = prev;
//        root.left = null;
//        prev = root;
//    }

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode node, TreeNode next) {
        if (node == null) return next;
        next = flatten(node.right, next);
        next = flatten(node.left, next);
        node.right = next;
        node.left = null;
        next = node;
        return next;
    }



}
