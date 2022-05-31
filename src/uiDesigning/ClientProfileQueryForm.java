package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.queryProfile;

public class ClientProfileQueryForm {
    Label label = new Label("账号：");
    TextField textField = new TextField();
    Button button = new Button("查询");

    Panel p0 = new Panel();
    Panel p1 = new Panel();

    Frame mainFrame = new Frame();

    public ClientProfileQueryForm(){
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.add(p0);

        p0.setLayout(new BorderLayout());
        p0.add(label,BorderLayout.WEST);
        p0.add(textField);

        mainFrame.add(p1);
        p1.add(button);

        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
            }
        });

        button.addActionListener(e -> {
            String account = textField.getText();
            try {
                double profile = queryProfile(account);
                String result = "您当前的余额为"+profile+"元";
                JOptionPane.showMessageDialog(null,result,"信息",JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"系统错误","错误",JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL错误","错误",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
