package uiDesigning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator {
    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");
    Button button9 = new Button("9");
    Button button0 = new Button("0");
    Button button00 = new Button("00");
    Button buttonp = new Button(".");
    Button buttonadd = new Button("+");
    Button buttonmin = new Button("-");
    Button buttonmul = new Button("¡Á");
    Button buttondiv = new Button("¡Â");
    Button buttonpes = new Button("%");
    Button buttonequ = new Button("=");

    TextField txt = new TextField();

    Panel p = new Panel();

    Frame mainFrame = new Frame();

    public Calculator(){
        p.setLayout(new GridLayout(6,3));
        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(button7);
        p.add(button8);
        p.add(button9);
        p.add(button0);
        p.add(button00);
        p.add(buttonp);
        p.add(buttonadd);
        p.add(buttonmin);
        p.add(buttonpes);
        p.add(buttonmul);
        p.add(buttondiv);
        p.add(buttonequ);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(txt,BorderLayout.NORTH);
        mainFrame.add(p);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setTitle("¼ÆËãÆ÷");
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
