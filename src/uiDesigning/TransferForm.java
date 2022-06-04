package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static banksimulate.SqlOptions.*;

public class TransferForm {
    Label thisacc = new Label("我方账号：");
    Label account = new Label("对方账号：");
    Label profile = new Label("金额：");
    TextField thisactxt = new TextField();
    TextField acctxt = new TextField();
    TextField profiletxt = new TextField();
    Button confirm = new Button("确定");
    Button cancel = new Button("取消");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();

    Frame mainFrame = new Frame();

    public TransferForm(){
        mainFrame.setLayout(new GridLayout(4,1));

        mainFrame.add(p0);
        p0.setLayout(new BorderLayout());
        p0.add(thisacc,BorderLayout.WEST);
        p0.add(thisactxt);

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(account,BorderLayout.WEST);
        p1.add(acctxt);

        mainFrame.add(p2);
        p2.setLayout(new BorderLayout());
        p2.add(profile,BorderLayout.WEST);
        p2.add(profiletxt);

        mainFrame.add(p3);
        p3.add(cancel);
        p3.add(confirm);

        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);


        acctxt.setSize(200,50);
        profiletxt.setSize(200,50);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });
        mainFrame.setTitle("转账");

        cancel.addActionListener(e -> mainFrame.setVisible(false));

        confirm.addActionListener(e -> {
            String thisAccount = thisactxt.getText();
            String account = acctxt.getText();
            double profile = Double.parseDouble(profiletxt.getText());
            try {
                double profileOfThis = queryProfile(thisAccount);
                if(profileOfThis<profile){
                    JOptionPane.showMessageDialog(null,"余额不足","错误", JOptionPane.ERROR_MESSAGE);
                } else if(!accountExist(thisAccount) || !accountExist(account)) {
                    JOptionPane.showMessageDialog(null,"账号输入错误","错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    double accProfile = queryProfile(account);
                    double accProfileNow = accProfile + profile;
                    double accThisProfile = queryProfile(thisAccount);
                    double accThisProfileNow = accThisProfile - profile;
                    executeSql("UPDATE bank.client SET profile='"+accProfileNow+"' WHERE account='"+account+"'; ");
                    executeSql("UPDATE bank.client SET profile='"+accThisProfileNow+"' WHERE account='"+thisAccount+"'; ");
                    JOptionPane.showMessageDialog(null,"转账成功","信息",JOptionPane.INFORMATION_MESSAGE);
                }
                String logsqlout = "insert into bank_log.banklog(account,profile,option) value ('"+thisAccount+"',"+profile+",'transfer out');";
                String logsqlin = "insert into bank_log.banklog(account,profile,option) value ('"+account+"',"+profile+",'transfer in');";
                //executeSql(logsqlout);
                //executeSql(logsqlin);
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
