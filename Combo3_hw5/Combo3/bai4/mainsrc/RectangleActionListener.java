package  bai4.mainsrc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import  bai4.gui.*;
import  bai4.tree.*;

public class RectangleActionListener implements ActionListener {

    private JTextField textField;

    public RectangleActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = textField.getText();
        // if tree is null, then do nothing
        if ((filePath != null) && (filePath.length() > 0)) {
          String readLine;
          try {
            File file = new File(textField.getText());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
    
            try {
              readLine = bufferedReader.readLine();
              bufferedReader.close();
            }
            catch(IOException ioException) {
              JOptionPane.showMessageDialog(null, ioException.getMessage());
              return;
            }
          }
          catch(FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException.getMessage());
            return;
          }
          catch(UnsupportedEncodingException unsupportedEncodingException) {
            JOptionPane.showMessageDialog(null, unsupportedEncodingException.getMessage());
            return;
          }
    
          Tree<Character> tree = SlicingFloorReader.buildTree(readLine);
          
          JFrame frame = new JFrame("Rectangle");
          frame.setContentPane(new RectanglePanel(tree));
          frame.setSize(200, 200);
          frame.setVisible(true);
        }
      }
}