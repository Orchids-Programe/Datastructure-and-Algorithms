package  bai4.gui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JButton browse;
    private JButton rectangle;
    private JButton tree;

    private static int rows = 1;
    private static int cols = 3;

    public MainPanel(){
        JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setLayout(new GridLayout( rows, cols));

        textField = new JTextField(10);
        textField.setEditable(false);

        browse = new JButton("Browse...");

        fileChooserPanel.add(new JLabel("Slicing Floor Plan file:"));
        fileChooserPanel.add(textField);
        fileChooserPanel.add(browse);

        JPanel drawPanel = new JPanel(new GridLayout(3, 3));

        rectangle = new JButton("RECTANGLE");
        tree = new JButton("TREE");

        drawPanel.add(new JLabel(""));
        drawPanel.add(rectangle);
        drawPanel.add(new JLabel(""));
        drawPanel.add(tree);
        drawPanel.add(new JLabel(""));

        setLayout(new BorderLayout());
        add(fileChooserPanel, BorderLayout.NORTH);
        add(drawPanel);

    }

    public JTextField getTextField(){
        return textField;
    }

    public void setBrowserActionListener( final ActionListener actionListener) {
        browse.addActionListener(actionListener);
    }

    public void setRectangleActionListener( final ActionListener actionListener) {
        rectangle.addActionListener(actionListener);
    }

    public void setTreeActionListener( final ActionListener actionListener) {
        tree.addActionListener(actionListener);
    }

}