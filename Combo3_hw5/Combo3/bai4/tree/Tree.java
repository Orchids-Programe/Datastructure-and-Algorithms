package bai4.tree;

public class Tree<E> {
    protected LinkedBinaryTree<E> root;
    public void setRoot(LinkedBinaryTree<E> node) {
        root = node;
    }
    

    public LinkedBinaryTree<E> getRoot() {
        return root;
    }
    
    // "If v is the root, then the depth of v is 0.
    // Otherwise, the depth of v is one plus the depth of the parent of v."
    public int depth(LinkedBinaryTree<E> node) {
        if (node == root) {
            return 0;
        }
        return 1 + depth(node.getParent());
    }

    public int level(LinkedBinaryTree<E> node) {
        int level = 0;
        LinkedBinaryTree<E> temp = node;
        while (temp.getParent() != null) {
            temp = temp.getParent();
            level++;
        }

        return level;
    }

    // "If v is an external node, then the height of v is 0.
    // Otherwise, the height of v is one plus the maximum height of a child of v."
    public int height(LinkedBinaryTree<E> node) {
        int height, maxHeight = 0;
        if (node.isExternal()) {
            return 0;
        }
        for (LinkedBinaryTree<E> child : node.getChild()) {
            height = height(child);
            if (height> maxHeight) {
                maxHeight = height;
            }
        }
        return 1 + maxHeight;
    }

    public String preorder(){
        return preorder((bai4.tree.BinaryTreeNode<E>)root);
    }
    private String preorder(bai4.tree.BinaryTreeNode<E> node){
        StringBuilder stringBuilder = new StringBuilder();

        if (null != node) {
            stringBuilder.append(preorder(node.getLeft()));
            stringBuilder.append(node.getValue());
            stringBuilder.append(preorder(node.getRight()));
        }
        return stringBuilder.toString();
    }
}