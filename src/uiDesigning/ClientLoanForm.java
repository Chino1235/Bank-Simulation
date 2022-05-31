package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;

import static banksimulate.SqlOptions.executeSql;
import static banksimulate.SqlOptions.queryProfile;

public class ClientLoanForm {
    Label account = new Label("账号：");
    Label time = new Label("期限：");
    Label profile = new Label("金额：");
    TextField acctxt = new TextField();
    TextField timetxt = new TextField();
    TextField profiletxt = new TextField();
    Button confirm = new Button("确定");
    Button cancel = new Button("取消");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();

    Frame mainFrame = new Frame();

    public ClientLoanForm(){
        mainFrame.setLayout(new GridLayout(4,1));

        mainFrame.add(p0);
        p0.setLayout(new BorderLayout());
        p0.add(account,BorderLayout.WEST);
        p0.add(acctxt);

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(time,BorderLayout.WEST);
        p1.add(timetxt);

        mainFrame.add(p2);
        p2.setLayout(new BorderLayout());
        p2.add(profile,BorderLayout.WEST);
        p2.add(profiletxt);

        mainFrame.add(p3);
        p3.add(cancel);
        p3.add(confirm);

        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);

        mainFrame.setTitle("办理贷款");

        timetxt.setSize(200,50);
        profiletxt.setSize(200,50);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        cancel.addActionListener(e -> mainFrame.setVisible(false));

        confirm.addActionListener(e -> {
            Date loanDate = new Date(System.currentTimeMillis());
            Date returnDate = loanDate;
            double profile = Double.parseDouble(profiletxt.getText());
            returnDate.setYear(loanDate.getYear()+Integer.parseInt(timetxt.getText()));
            String sql = "INSERT INTO bank.client_loan(clientAccount, loanProfile, loanTime, returnTime) VALUES('" +
                    acctxt.getText() + "','"+ profile + "','"+ loanDate +"','"+ returnDate +"');";
            String logSql = "INSERT INTO bank_log.banklog(account, profile, `option`) VALUE ('"+acctxt.getText()+"','"+profile+"','loan')";
            try {
                double currentProfile = queryProfile(acctxt.getText());
                double finalProfile = currentProfile + profile;
                executeSql("UPDATE bank.client SET profile='"+finalProfile+"' where account='"+acctxt.getText()+"';");
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
