package uiDesigning;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientOpenAccount {
    Label name = new Label("姓名：");
    Label acc = new Label("账号：");
    Label pass = new Label("密码：");
    Label confirm = new Label("确认密码：");

    TextField clientName = new TextField();
    TextField account = new TextField();
    TextField password = new TextField();
    TextField confirmpassword = new TextField();

    Button submit = new Button("提交");

    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    Frame mainFrame = new Frame();

    public ClientOpenAccount(){
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

        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        submit.addActionListener(e -> {

        });
    }
}
