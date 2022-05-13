package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FinancialProdForm {
    Label type = new Label("产品名称：");
    Label number = new Label("户号：");
    Label profile = new Label("金额：");

    String[] types = {"理财A","理财B","理财C","理财D"};
    JComboBox<String> typess = new JComboBox<>(types);

    TextField numbertxt = new TextField();
    TextField profiletxt = new TextField();

    Button confirm = new Button("确定");
    Button cancel = new Button("取消");

    Frame mainFrame = new Frame();

    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    public FinancialProdForm (){
        mainFrame.setSize(300,300);
        mainFrame.setLayout(new GridLayout(4,1));

        mainFrame.add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(type,BorderLayout.WEST);
        p1.add(typess);

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
        mainFrame.setTitle("购买理财");

        cancel.addActionListener(e -> mainFrame.setVisible(false));
    }
}
