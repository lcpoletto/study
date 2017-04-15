package com.carrercup;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.careercup.com/question?id=5187290822344704
 */
public class BinaryTree {

    private static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    public boolean canForm(TreeNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return false;
        }

        final Map<TreeNode, TreeNode[]> nodesMap = new HashMap<>(nodes.length);
        for (final TreeNode parent : nodes) {
            TreeNode[] children = nodesMap.get(parent);
            if (children == null) {
                children = new TreeNode[2];
            }
            // if we already filled up the array for this node it means there are more
            // nodes pointing to it as a parent, thus this is not a binary tree
            if (parent.left != null && children[0] != null) {
                return false;
            }
            if (parent.right != null && children[1] != null) {
                return false;
            }
            children[0] = parent.left;
            children[1] = parent.right;
            nodesMap.put(parent, children);
        }

        // now we check for at least one node that is not on the parent map
        boolean foundRoot = false;
        for (final TreeNode node : nodes) {
            if (!nodesMap.containsKey(node)) {
                foundRoot = true;
                break;
            }
        }

        return foundRoot;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Can form with possible? " + tree.canForm(null));
        System.out.println("Can form with impossible? " + tree.canForm(null));

    }
}
