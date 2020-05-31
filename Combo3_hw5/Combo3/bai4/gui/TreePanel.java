package bai4.gui;

import java.awt.*;

import javax.swing.JPanel;

import  bai4.tree.Tree;
import  bai4.tree.BinaryTreeNode;

public class TreePanel extends JPanel {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Tree<Character> tree;

    private static final int nodeWidth = 30;
    private static final int nodeHeight = 30;

    public TreePanel(Tree<Character> tree){
        this.tree = tree;
    }
    
    public void paint(Graphics graphics) {
        BinaryTreeNode<Character> root = (BinaryTreeNode<Character>)tree.getRoot();
        drawTree(graphics, 0, 0, root, null);
    }

    private void drawTree(Graphics graphics, int x, int y, BinaryTreeNode<Character> node, Point point) {
    //point is bottom of parent's node to draw connector line    
        if (node == null) {
            return;
        }
        // blanks is used for spacing nodes evenly
        int blank = (int) Math.pow(2, tree.height(node));
        char ch = node.getValue();
        if ((ch == '|') || (ch == '-')) {
            graphics.setColor(Color.WHITE);
            graphics.fillOval(x + (blank * nodeWidth), y, nodeWidth, nodeHeight);

            graphics.setColor(Color.BLACK);
            graphics.drawOval(x + (blank * nodeWidth), y, nodeWidth, nodeHeight);
        } else {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(x + (blank * nodeWidth), y, nodeWidth, nodeHeight);

            graphics.setColor(Color.BLACK);
            graphics.drawRect(x + (blank * nodeWidth), y, nodeWidth, nodeHeight);
        }

        // determine font and line spacing dimensions
        FontMetrics fontMetric = graphics.getFontMetrics();
        int charWidth = fontMetric.charWidth('X');
        int ascent = fontMetric.getAscent();
        graphics.drawString("" + node.getValue(), x + (blank * nodeWidth) + charWidth, y + ascent);
        if (point != null) {
            graphics.setColor(Color.BLACK);
            graphics.drawLine(x + (blank *nodeWidth) + (nodeWidth/2), y, point.x, point.y);

        }

        // pass location of current node's bottom half
        point = new Point(x + (blank * nodeWidth) + (nodeWidth/2), y + nodeHeight);

        drawTree(graphics, x, y + (nodeHeight * 2), node.getLeft(), point);
        drawTree(graphics, x + (blank * nodeWidth), y + (nodeHeight * 2), node.getRight(), point);
        
    }

}