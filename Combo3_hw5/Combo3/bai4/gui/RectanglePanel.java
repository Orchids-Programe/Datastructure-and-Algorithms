package bai4.gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bai4.mainsrc.SlicingFloorReader;
import  bai4.tree.Tree;
import  bai4.tree.BinaryTreeNode;

import  bai4.queue.LinkedListQueue;

public class RectanglePanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Tree<Character> tree;
    private LinkedListQueue<Rectangle> queue;

    public RectanglePanel(final Tree<Character> tree){
        this.tree = tree;
    }

    public void paint(final Graphics g) {
        //g: the Graphics object used in drawing rectangle
        drawRectangles((Graphics2D) g, 10, 10, 100, 100);
    }
    public void drawRectangles(final Graphics2D g, final int x, final int y, final int width, final int height) {
        // x: the integer x coordinate of floor's top left corner
        // y: the integer y coordinate of floor's top left corner
        //width: the width of the floor
        //height: the height of the floor
        queue = new LinkedListQueue<Rectangle>();
        queue.enqueue(new Rectangle(x, y, width, height));

        drawRectangles((BinaryTreeNode<Character>) tree.getRoot(), g);
    }
    private void drawRectangles(final BinaryTreeNode<Character> node, final Graphics2D g) {
        switch (node.getValue()) {
            case '|':
              drawVerticalCut();
              break;
            case '-':
              drawHorizontalCut();
              break;
            default:
              drawRectangle(node, g);
              break;
        }
        if (node.getLeft() != null) {
            //does node's left child need to be drawn ?
            drawRectangles(node.getLeft(), g);
        }
        if (node.getRight() != null) {
            //does node's right child need to be drawn ?
            drawRectangles(node.getRight(), g);
        }
    }

    private void drawVerticalCut() {
        //draw a vertical cut on the floor plan
        Rectangle temp = (Rectangle) queue.dequeue();
        LinkedListQueue<Rectangle> q = new LinkedListQueue<Rectangle>();

        int newWidth = (int) (temp.getWidth()/2);
        //remove all old rectangle shapes, so that the new rectangle shapes can become first and second in queue
        while (!queue.isEmpty()) {
            q.enqueue(queue.dequeue());
        }
        //push the first half of rectangle onto queue
        queue.enqueue(new Rectangle((int) temp.getX(), (int) temp.getY(),newWidth, (int) temp.getHeight()));
        //push the second half of rectangle onto queue
        queue.enqueue(new Rectangle((int) temp.getX() + newWidth, (int) temp.getY(),newWidth, (int) temp.getHeight()));
        //replace old rectangle shapes into queue
        while (!q.isEmpty()) {
            queue.enqueue(q.dequeue());
        }

    }

    private void drawHorizontalCut() {
        //draw a horizontal cut on the floor plan
        Rectangle temp = (Rectangle) queue.dequeue();
        LinkedListQueue<Rectangle> q = new LinkedListQueue<Rectangle>();

        int newHeight = (int) (temp.getHeight()/2);
        //remove all old rectangle shapes, so that the new rectangle shapes can become first and second in queue
        while (!queue.isEmpty()) {
            q.enqueue(queue.dequeue());
        }
        // push the first half of rectangle onto queue
        queue.enqueue(new Rectangle((int) temp.getX(), (int) temp.getY(),(int) temp.getWidth(), newHeight));
        // push the second half of rectangle onto queue
        queue.enqueue(new Rectangle((int) temp.getX(),(int) temp.getY() + newHeight, (int) temp.getWidth(), newHeight));
        //replace old rectangle shapes into queue
        while (!q.isEmpty()) {
            queue.enqueue(q.dequeue());
        }
    }

    private void drawRectangle(BinaryTreeNode<Character> node, Graphics2D g) {
        Rectangle temp = (Rectangle) queue.dequeue();
        
        float x = (float) (temp.getX() + (temp.getWidth() / 2));
        float y = (float) (temp.getY() + (temp.getHeight() / 2));

        g.setColor(Color.WHITE);
        g.fill((Shape) temp);

        g.setColor(Color.BLACK);
        g.draw((Shape) temp);
        g.drawString(""+ node.getValue(), x, y);
    }

    //test draw
    public static void main(String[] args) {
        Tree<Character> tree = SlicingFloorReader.buildTree("|-AB-|C-EFD");
        RectanglePanel panel = new RectanglePanel(tree);
        JFrame frame = new JFrame("FileChooserPanel");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}