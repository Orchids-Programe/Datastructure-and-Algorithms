package bai4.mainsrc;

import java.util.Stack;

import  bai4.tree.*;

public class SlicingFloorReader {
    public static Tree<Character> buildTree(String str) {
        char ch;
        BinaryTreeNode<Character> current = null;
        BinaryTreeNode<Character> node = null;
        Stack<BinaryTreeNode<Character>> stack = new Stack<BinaryTreeNode<Character>>();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            node = new BinaryTreeNode<Character>();
            node.setValue(ch);
            if (current == null) {
                current = node;
            } else {
                while ((current.getLeft() != null) && (current.getRight() != null)) {
                    current = stack.pop();
                }
                if (current.getLeft() == null) {
                    current.setLeft(node);
                } else {
                    current.setRight(node);
                }
                if ((ch == '|') || (ch == '-')) {
                    stack.push(current);
                    current = node;
                }
            }
        }
        BinaryTreeNode<Character> root = stack.size() > 0 ? stack.pop() : current;
        Tree<Character> tree = new Tree<Character>();
        tree.setRoot(root);

        return tree;
    }
}