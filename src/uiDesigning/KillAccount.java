package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.*;

public class KillAccount {
    Label name = new Label("姓名：");
    Label acc = new Label("账号：");
    Label pass = new Label("密码：");


    TextField clientName = new TextField();
    TextField account = new TextField();
    TextField password = new TextField();


    Button submit = new Button("提交");

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
//todo:查询账号是否存在，若不存在弹窗提示（弹窗我来写）
                if(!accountExist(accountt)){
                    JOptionPane.showMessageDialog(null,"账号已注册","错误",JOptionPane.ERROR_MESSAGE);
                }
//ToDo：确认余额为0，若不为0弹窗提示（弹窗我来写）
                if(profile!=0){
                    JOptionPane.showMessageDialog(null,"余额不为0","错误",JOptionPane.ERROR_MESSAGE);
                }
//ToDo：确认密码正确，若不正确弹窗
                String passwd1=queryPassword(accountt);
                if(!passwd1.equals(passwd)){
                    JOptionPane.showMessageDialog(null,"密码不正确","错误",JOptionPane.ERROR_MESSAGE);
                }
//ToDo：确认姓名正确，若不正确，弹窗
                String name1=queryName(accountt);
                if(!name1.equals(name)){
                    JOptionPane.showMessageDialog(null,"姓名不正确","错误",JOptionPane.ERROR_MESSAGE);
                }
//ToDo：执行数据库删除操作
                executeSql("delete from bank.client where account='"+accountt+"';");
                JOptionPane.showMessageDialog(null,"销户成功","信息",JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"您输入的信息有误","错误",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }


}
