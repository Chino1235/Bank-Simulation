package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.accountExist;
import static banksimulate.SqlOptions.queryPassword;

public class ClientLoginForm {
    Label account = new Label("ÕËºÅ£º");
    Label password = new Label("ÃÜÂë£º");
    TextField accounttxt = new TextField();
    TextField passtxt = new TextField();
    Button confirm = new Button("È·¶¨");
    Button openacc = new Button("Ã»ÓÐÕË»§£¿Á¢¼´¿ª»§£¡");
    Label message = new Label();

    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();

    Frame mainFrame = new Frame();

    public ClientLoginForm(){
        mainFrame.setLayout(new GridLayout(3,1));

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(account,BorderLayout.WEST);
        p1.add(accounttxt);

        mainFrame.add(p2);
        p2.setLayout(new BorderLayout());
        p2.add(password,BorderLayout.WEST);
        p2.add(passtxt);

        mainFrame.add(p3);
        p3.add(confirm);
        p3.add(openacc);


        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);
        mainFrame.setTitle("¿Í»§µÇÂ¼");
        mainFrame.pack();

        accounttxt.setSize(200,50);
        passtxt.setSize(200,50);
        passtxt.setEchoChar('*');

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        confirm.addActionListener(e -> {
            String account = accounttxt.getText();
            String password = passtxt.getText();
            try {
                String correctPass = queryPassword(account);
                if(!accountExist(account)){
                    JOptionPane.showMessageDialog(null,"Î´¿ª»§»òÕËºÅÓÐÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
                }
                else if(!password.equals(correctPass)){
                    JOptionPane.showMessageDialog(null,"ÃÜÂë´íÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
                } else{
                    new ClientMainForm();
                    mainFrame.setVisible(false);
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"SQL´íÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
            }
        });

        openacc.addActionListener(e -> new ClientOpenAccount());
    }

    public static void main(String[] args) {
        new ClientLoginForm();
    }

}
