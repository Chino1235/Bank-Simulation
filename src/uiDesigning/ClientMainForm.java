package uiDesigning;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientMainForm {
    public Button withdrawAppointment = new Button("预约取款");
    public Button depositAppointment = new Button("预约存款");
    public Button financialProducts = new Button("购买理财");
    public Button makeloan = new Button("办理贷款");
    public Button dailyLifePayment = new Button("生活缴费");
    public Button transfer = new Button("转账");
    public Button account = new Button("修改密码");
    public Button exit = new Button("退出");
    public Label welcome = new Label("欢饮使用村镇银行客户端");

    public Panel pleft = new Panel();
    public Panel pright = new Panel();

    public Frame mainFrame = new Frame();

    public ClientMainForm(){
        mainFrame.setLayout(new BorderLayout());
        pleft.setLayout(new GridLayout(4,1));
        pright.setLayout(new GridLayout(4,1));
        Font f = new Font("微软雅黑",Font.PLAIN,20);

        mainFrame.add(pleft,BorderLayout.WEST);
        mainFrame.add(pright,BorderLayout.EAST);
        mainFrame.add(welcome,BorderLayout.NORTH);
        pleft.add(withdrawAppointment);
        pleft.add(depositAppointment);
        pleft.add(financialProducts);
        pleft.add(makeloan);
        pright.add(dailyLifePayment);
        pright.add(transfer);
        pright.add(account);
        pright.add(exit);

        mainFrame.setSize(700,700);
        welcome.setFont(f);
        mainFrame.setVisible(true);
        mainFrame.setTitle("村镇银行客户端");
        mainFrame.setLocation(500,50);
        mainFrame.pack();

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*
         * 取款预约
         */
        withdrawAppointment.addActionListener(e -> new WithdrawAppointment());
        /*
         * 存款预约
         */
        depositAppointment.addActionListener(e -> new WithdrawAppointment());
        /*
         * @method
         */
        dailyLifePayment.addActionListener(e -> new DailyPaymentForm());
        /*
         * 贷款
         */
        makeloan.addActionListener(e -> new ClientLoanForm());
        /*
         * 转账
         */
        transfer.addActionListener(e -> new TransferForm());

        financialProducts.addActionListener(e -> new FinancialProdForm());

        account.addActionListener(e -> new AccountMgrForm());

        exit.addActionListener(e -> {

        });
    }

    public static void main(String[] args) {
        new ClientMainForm();
    }
}
