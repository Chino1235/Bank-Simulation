package uiDesigning;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

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
    Button buttonmul = new Button("*");
    Button buttondiv = new Button("/");
    Button buttonpes = new Button("BackSpace");
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

        button0.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button0.getLabel();
            txt.setText(finall);
        });

        button1.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button1.getLabel();
            txt.setText(finall);
        });

        button2.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button2.getLabel();
            txt.setText(finall);
        });
        button3.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button3.getLabel();
            txt.setText(finall);
        });
        button4.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button4.getLabel();
            txt.setText(finall);
        });
        button5.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button5.getLabel();
            txt.setText(finall);
        });
        button6.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button6.getLabel();
            txt.setText(finall);
        });
        button7.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button7.getLabel();
            txt.setText(finall);
        });
        button8.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button8.getLabel();
            txt.setText(finall);
        });
        button9.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button9.getLabel();
            txt.setText(finall);
        });
        button00.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + button00.getLabel();
            txt.setText(finall);
        });
        buttonp.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + buttonp.getLabel();
            txt.setText(finall);
        });
        buttonadd.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + buttonadd.getLabel();
            txt.setText(finall);
        });
        buttonmin.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + buttonmin.getLabel();
            txt.setText(finall);
        });
        buttonmul.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + buttonmul.getLabel();
            txt.setText(finall);
        });
        buttondiv.addActionListener(e->{
            String origin = txt.getText();
            String finall = origin + buttondiv.getLabel();
            txt.setText(finall);
        });
        buttonpes.addActionListener(e->{
            String origin = txt.getText();
            if(!Objects.equals(origin, "")){
                String finall = origin.substring(0,origin.length()-1);
                txt.setText(finall);
            }
        });
        buttonequ.addActionListener(e->{
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine scriptEngine = manager.getEngineByName("js");
            String script = txt.getText();
            try {
                Object result = scriptEngine.eval(script);
                txt.setText(result.toString());
            } catch (ScriptException ex) {
                JOptionPane.showMessageDialog(null,"´íÎó","´íÎó",JOptionPane.ERROR_MESSAGE);
            }
        });
    }



    public static void main(String[] args) {
        new Calculator();
    }
}
