package bai4.tree;

import java.util.LinkedList;
import java.util.List;

public class LinkedBinaryTree<E> {
    protected LinkedBinaryTree<E> parent;
    //parent P
    public void setParent(LinkedBinaryTree<E> node) {
        parent = node;
    }
    public LinkedBinaryTree<E> getParent(){
        return parent;
    }
    protected E value;
    public void setValue(E value) {
        this.value = value;
    }
    public E getValue(){
        return value;
    }
    public LinkedBinaryTree(){}
    public LinkedBinaryTree(E value){
        this.value = value;
    }

    protected List<LinkedBinaryTree<E>> child = new LinkedList<LinkedBinaryTree<E>>();
    // child of parent
    public void addChild(LinkedBinaryTree<E> node) {
        child.add(node);
        node.setParent(node);
    }
    public boolean removeChild(LinkedBinaryTree<E> node) {
        if (child.remove(node)) {
            node.setParent(null);
            return true;
        }
        return false;
    }
    public List<LinkedBinaryTree<E>> getChild() {
        return child;
    }


    // a node v is external if v has no children
	public boolean isExternal() {
		return (child.size() == 0);
    }
    // a node v is internal if it has one or more children
    public boolean isInternal() {
        return (child.size() >=1);
    } 
    // External nodes are also known as leaves
    public boolean isLeaf() {
        return isExternal();
    }
    // A node u is an ancestor of a node v if u = v or u is an ancestor of the parent of v
    public boolean isAncestor(LinkedBinaryTree<E> node) {
        return ((this == node) || (this == node.getParent()));
    }
    // If node u is an ancestor of node v, then v is a descendent of u
    public boolean isDescendentOf(LinkedBinaryTree<E> node) {
        return node.isAncestor(this);
    }
    
    
}