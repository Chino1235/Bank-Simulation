package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static banksimulate.Simulator.*;

public class AccountMgrForm {
    Label account = new Label("ÕËºÅ");
    Label old = new Label("¾ÉÃÜÂë£º");
    Label neww = new Label("ÐÂÃÜÂë£º");
    Label confirmNeww = new Label("È·ÈÏÃÜÂë");

    TextField accounttxt = new TextField();
    TextField oldtxt = new TextField();
    TextField newtxt = new TextField();
    TextField confirmtxt = new TextField();

    Button confirm = new Button("È·¶¨");
    Button cancel = new Button("È¡Ïû");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    Frame mainFrame = new Frame();

    public AccountMgrForm(){
        p0.setLayout(new BorderLayout());
        p0.add(account,BorderLayout.WEST);
        p0.add(accounttxt);

        p1.setLayout(new BorderLayout());
        p1.add(old,BorderLayout.WEST);
        p1.add(oldtxt);

        p2.setLayout(new BorderLayout());
        p2.add(neww,BorderLayout.WEST);
        p2.add(newtxt);

        p3.setLayout(new BorderLayout());
        p3.add(confirmNeww,BorderLayout.WEST);
        p3.add(confirmtxt);

        p4.add(confirm);
        p4.add(cancel);

        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.add(p1);
        mainFrame.add(p2);
        mainFrame.add(p3);
        mainFrame.add(p4);
        mainFrame.setVisible(true);
        mainFrame.setTitle("ÐÞ¸ÄÃÜÂë");
        mainFrame.setSize(300,300);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        cancel.addActionListener(e -> mainFrame.setVisible(false));

        confirmtxt.setEchoChar('*');
        newtxt.setEchoChar('*');
        oldtxt.setEchoChar('*');

        confirm.addActionListener(e -> {
            try {
                Connection conn = null;
                Statement stat = null;
                String accountnum = accounttxt.getText();
                String oldpass = old.getText();
                String newpass = newtxt.getText();
                String sql = "UPDATE bank.client SET password='" + newpass + "' WHERE account="+accountnum+";";
                Class.forName(DBDRIVER);
                conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
                stat =conn.createStatement();
                stat.executeUpdate(sql);
                stat.close();
                conn.close();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"ÏµÍ³´íÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"SQL´íÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
