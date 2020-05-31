package  bai4.mainsrc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class BrowserActionListener implements ActionListener {

    private JTextField textField;

    public BrowserActionListener(JTextField textField){
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO Auto-generated method stub
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().toString());
        }

    }
    
}