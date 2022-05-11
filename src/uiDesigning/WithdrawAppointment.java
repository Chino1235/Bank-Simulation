package uiDesigning;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WithdrawAppointment {
    Label time = new Label("时间：");
    Label profile = new Label("金额：");
    TextField timetxt = new TextField();
    TextField profiletxt = new TextField();
    Button confirm = new Button("确定");
    Button cancel = new Button("取消");

    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();

    Frame mainFrame = new Frame();

    public WithdrawAppointment(){
        mainFrame.setLayout(new GridLayout(3,1));

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

        timetxt.setSize(200,50);
        profiletxt.setSize(200,50);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });

        cancel.addActionListener(e -> mainFrame.setVisible(false));
    }


}
