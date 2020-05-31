package bai4.tree;

public class BinaryTreeNode<E> extends  bai4.tree.LinkedBinaryTree<E> {
    private  bai4.tree.BinaryTreeNode<E> left;
    private  bai4.tree.BinaryTreeNode<E> right;
    // left and right child of Parent

    public BinaryTreeNode(){}
    public BinaryTreeNode(E value){
        this.value = value;
    }

    @Override
    public void addChild( bai4.tree.LinkedBinaryTree<E> node) {
         throw new UnsupportedOperationException("You must use either setLeftChild or setRightChild for Binary Tree.");
    }
    
    public boolean removeChild( bai4.tree.LinkedBinaryTree<E> node) {
        super.removeChild(node);

        if (left == node) {
            left = null;
            return true;
        }
        if (right == node) {
            right = null;
            return true;
        }
        return false;
    }

    public bai4.tree.BinaryTreeNode<E> getLeft(){
        return left;
    }
    public  bai4.tree.BinaryTreeNode<E> getRight(){
        return right;
    }
    public void setLeft(bai4.tree.BinaryTreeNode<E> node) {
        if (left != null) {
            child.remove(left);
        }
        super.addChild(node);
        left = node;
    }
    public void setRight( bai4.tree.BinaryTreeNode<E> node) {
        if (right != null) {
            child.remove(right);
        }
        super.addChild(node);
        right = node;
    }
}