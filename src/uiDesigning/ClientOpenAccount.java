package uiDesigning;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Objects;

import static banksimulate.SqlOptions.accountExist;
import static banksimulate.SqlOptions.executeSql;

public class ClientOpenAccount {
    Label name = new Label("������");
    Label acc = new Label("�˺ţ�");
    Label pass = new Label("���룺");
    Label confirm = new Label("ȷ�����룺");

    TextField clientName = new TextField();
    TextField account = new TextField();
    TextField password = new TextField();
    TextField confirmpassword = new TextField();

    Button submit = new Button("�ύ");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    Frame mainFrame = new Frame();

    public ClientOpenAccount(){
        mainFrame.setLayout(new GridLayout(5,1));

        mainFrame.add(p0);
        p0.setLayout(new BorderLayout());
        p0.add(name,BorderLayout.WEST);
        p0.add(clientName);

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(acc, BorderLayout.WEST);
        p1.add(account);

        mainFrame.add(p2);
        p2.setLayout(new BorderLayout());
        p2.add(pass,BorderLayout.WEST);
        p2.add(password);
        password.setEchoChar('*');

        mainFrame.add(p3);
        p3.setLayout(new BorderLayout());
        p3.add(confirm,BorderLayout.WEST);
        p3.add(confirmpassword);
        confirmpassword.setEchoChar('*');

        mainFrame.add(p4);
        p4.add(submit);

        mainFrame.setSize(300,300);
        mainFrame.setTitle("����");
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        submit.addActionListener(e -> {
            String name = clientName.getText();
            String accoun = account.getText();
            String passwd = password.getText();
            //todo:�ж�ȷ�������Ƿ���ȷ�������󵯳�
            String passwd1 = confirmpassword.getText();
            if(!Objects.equals(passwd, passwd1)){
                JOptionPane.showMessageDialog(null,"�����������벻һ��","����",JOptionPane.ERROR_MESSAGE);

            }
            //JOptionPane.showMessageDialog(null,"�����������벻һ��","����",JOptionPane.ERROR_MESSAGE);
            //todo:�ж��˺��Ƿ���ע�ᣬ����ע�ᵯ��
            try {
                if(!accountExist(accoun)){
                    JOptionPane.showMessageDialog(null,"�˺���ע��","����",JOptionPane.ERROR_MESSAGE);
                } else {
                    executeSql("insert into bank.client(account,name,password) value ('" + accoun + "','" + name + "','" + passwd + "');");
                    JOptionPane.showMessageDialog(null,"�����ɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //JOptionPane.showMessageDialog(null,"�˺���ע��","����",JOptionPane.ERROR_MESSAGE);
            //todo��ִ�����ݿ�������
        });
    }
}
