package uiDesigning;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static banksimulate.Simulator.*;

public class AccountMgrForm {
    Label account = new Label("账号");
    Label old = new Label("旧密码：");
    Label neww = new Label("新密码：");
    Label confirmNeww = new Label("确认密码");

    TextField accounttxt = new TextField();
    TextField oldtxt = new TextField();
    TextField newtxt = new TextField();
    TextField confirmtxt = new TextField();

    Button confirm = new Button("确定");
    Button cancel = new Button("取消");

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

        mainFrame.setLayout(new GridLayout(5,1));
        mainFrame.add(p0);
        mainFrame.add(p1);
        mainFrame.add(p2);
        mainFrame.add(p3);
        mainFrame.add(p4);
        mainFrame.setVisible(true);
        mainFrame.setTitle("修改密码");
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
                String accountnum = accounttxt.getText();
                String oldpass = old.getText();
                String newpass = newtxt.getText();
                String sql = "UPDATE bank.client SET password='" + newpass + "' WHERE account="+accountnum+";";
                executeSql(sql);

        });
    }
}
