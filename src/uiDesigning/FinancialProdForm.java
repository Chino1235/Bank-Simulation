package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FinancialProdForm {
    Label type = new Label("��Ʒ���ƣ�");
    Label number = new Label("���ţ�");
    Label profile = new Label("��");

    String[] types = {"���A","���B","���C","���D"};
    JComboBox<String> typess = new JComboBox<>(types);

    TextField numbertxt = new TextField();
    TextField profiletxt = new TextField();

    Button confirm = new Button("ȷ��");
    Button cancel = new Button("ȡ��");

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
        mainFrame.setTitle("�������");

        cancel.addActionListener(e -> mainFrame.setVisible(false));

        confirm.addActionListener(e -> {
            String type = (String) typess.getSelectedItem();
            double profile = Double.parseDouble(profiletxt.getText());
            String number = (String) typess.getSelectedItem();
            JOptionPane.showMessageDialog(null,"ԤԼ�ɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
