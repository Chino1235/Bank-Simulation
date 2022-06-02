package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.*;

public class KillAccount {
    Label name = new Label("������");
    Label acc = new Label("�˺ţ�");
    Label pass = new Label("���룺");


    TextField clientName = new TextField();
    TextField account = new TextField();
    TextField password = new TextField();


    Button submit = new Button("�ύ");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    Frame mainFrame = new Frame();

    public KillAccount(){
        mainFrame.setLayout(new GridLayout(4,1));
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

        mainFrame.add(p4);
        p4.add(submit);
        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        submit.addActionListener(e->{
            String accountt= account.getText();
            String name = clientName.getText();
            String passwd=password.getText();
            try {
                double profile=queryProfile(accountt);
//todo:��ѯ�˺��Ƿ���ڣ��������ڵ�����ʾ����������д��
                if(!accountExist(accountt)){
                    JOptionPane.showMessageDialog(null,"�˺���ע��","����",JOptionPane.ERROR_MESSAGE);
                }
//ToDo��ȷ�����Ϊ0������Ϊ0������ʾ����������д��
                if(profile!=0){
                    JOptionPane.showMessageDialog(null,"��Ϊ0","����",JOptionPane.ERROR_MESSAGE);
                }
//ToDo��ȷ��������ȷ��������ȷ����
                String passwd1=queryPassword(accountt);
                if(!passwd1.equals(passwd)){
                    JOptionPane.showMessageDialog(null,"���벻��ȷ","����",JOptionPane.ERROR_MESSAGE);
                }
//ToDo��ȷ��������ȷ��������ȷ������
                String name1=queryName(accountt);
                if(!name1.equals(name)){
                    JOptionPane.showMessageDialog(null,"��������ȷ","����",JOptionPane.ERROR_MESSAGE);
                }
//ToDo��ִ�����ݿ�ɾ������
                executeSql("delete from bank.client where account='"+accountt+"';");
                JOptionPane.showMessageDialog(null,"�����ɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"���������Ϣ����","����",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }


}
