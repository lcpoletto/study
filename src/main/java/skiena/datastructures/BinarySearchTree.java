package skiena.datastructures;

/**
 * Defined on page 78 of the book.
 * <p>
 * Created by poletto on 5/26/2017.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Tree root;

    private class Tree {
        T item;
        Tree parent;
        Tree left;
        Tree right;
    }

    public Tree search(Tree node, T t) {
        if (node == null) {
            return null;
        }

        if (node.item.equals(t)) {
            return node;
        }

        if (t.compareTo(node.item) < 0) {
            return search(node.left, t);
        }
        return search(node.right, t);
    }

    public Tree min(Tree node) {
        if (node == null) {
            return null;
        }
        Tree min = node;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public Tree max(Tree node) {
        if (node == null) {
            return null;
        }
        Tree max = node;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    /**
     * In order binary search tree traversal.
     *
     * @param node
     */
    public void traverse(Tree node) {
        if (node != null) {
            traverse(node.left);
            process(node);
            traverse(node.right);
        }
    }

    public Tree insert(Tree node, T item) {
        if (node == null) {
            Tree result = new Tree();
            result.item = item;
            return result;
        }
        final int cmp = item.compareTo(node.item);
        if (cmp < 0) {
            node.left = insert(node.left, item);
            node.left.parent = node;
        } else if (cmp > 0) {
            node.right = insert(node.right, item);
            node.right.parent = node;
        } else {
            System.out.println("Element already on tree.");
        }
        return node;
    }

    public Tree delete(Tree node, T item) {
        if (node == null) {
            return null;
        }
        // TODO: finish method
        return null;
    }

    private void process(Tree node) {
        System.out.println(node.item + " ");
    }


}
