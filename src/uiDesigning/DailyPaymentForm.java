package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.executeSql;
import static banksimulate.SqlOptions.queryProfile;


public class DailyPaymentForm {
    Label account = new Label("�˺ţ�");
    Label type = new Label("���ͣ�");
    Label number = new Label("���ţ�");
    Label profile = new Label("��");

    String[] types = {"ˮ��","���","ú����","ů����"};
    JComboBox<String> typess = new JComboBox<>(types);

    TextField accounttxt = new TextField();
    TextField numbertxt = new TextField();
    TextField profiletxt = new TextField();

    Button confirm = new Button("ȷ��");
    Button cancel = new Button("ȡ��");

    Frame mainFrame = new Frame();

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    public DailyPaymentForm(){
        mainFrame.setSize(300,300);
        mainFrame.setLayout(new GridLayout(5,1));

        mainFrame.add(p0);
        p0.setLayout(new BorderLayout());
        p0.add(account,BorderLayout.WEST);
        p0.add(accounttxt);

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(type,BorderLayout.WEST);
        p1.add(typess);

        mainFrame.add(p2);
        p2.setLayout(new BorderLayout());
        p2.add(number,BorderLayout.WEST);
        p2.add(numbertxt);

        mainFrame.add(p3);
        p3.setLayout(new BorderLayout());
        p3.add(profile,BorderLayout.WEST);
        p3.add(profiletxt);

        mainFrame.add(p4);
        p4.add(cancel);
        p4.add(confirm);

        mainFrame.setVisible(true);
        mainFrame.setSize(300,300);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });
        mainFrame.setTitle("����ɷ�");

        cancel.addActionListener(e -> mainFrame.setVisible(false));

        confirm.addActionListener(e -> {
            String account = accounttxt.getText();
            try {
                double currentProfile = queryProfile(account);
                double payment = Double.parseDouble(profiletxt.getText());
                if (payment>currentProfile){
                    JOptionPane.showMessageDialog(null,"����","����",JOptionPane.ERROR_MESSAGE);
                } else {
                    double nowProfile = currentProfile-payment;
                    executeSql("UPDATE bank.client SET profile='"+nowProfile+"' where account='"+account+"';");
                    JOptionPane.showMessageDialog(null,"�ɷѳɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"ϵͳ����","����",JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"��������˺�����","����",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
