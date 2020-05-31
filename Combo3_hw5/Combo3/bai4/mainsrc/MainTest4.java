package  bai4.mainsrc;

import javax.swing.JFrame;
import javax.swing.JTextField;

import  bai4.gui.*;

public class MainTest4 {
    
    public static void main(String[] args) {
        MainPanel mainPanel = new MainPanel();

        JTextField textField = mainPanel.getTextField();
        
        mainPanel.setBrowserActionListener(new BrowserActionListener(textField));
        mainPanel.setRectangleActionListener(new RectangleActionListener(textField));
        mainPanel.setTreeActionListener(new TreeActionListener(textField));

        JFrame frame = new JFrame("SlicingFloor");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}