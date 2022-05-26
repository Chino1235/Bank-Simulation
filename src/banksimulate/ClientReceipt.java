package banksimulate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientReceipt {
    private String clientName;
    private String  account;
    private double  depositProfile;
    private String date;

    public ClientReceipt(String clientName, String account, double depositProfile,String date) {
        this.clientName = clientName;
        this.account = account;
        this.depositProfile = depositProfile;
        this.date = date;
    }


    @Override
    public String toString() {
        return "������'" + clientName + '\n' +
                "�˺ţ�'" + account + '\n' +
                "��'" + depositProfile + '\n' +
                "���ڣ�" + date ;
    }

   public static void generateReceipt(Client client,double profile)
    {
        System.out.println("�Ƿ���Ҫ��ִ��y/n");
        Scanner sc = new Scanner(System.in);
        if("n".equals(sc.nextLine())){
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date(System.currentTimeMillis());

        ClientReceipt clientreceipt=new ClientReceipt(client.getClientName(),client.getAccountNumber(),profile,format.format(date));
        System.out.println(clientreceipt);


    }

}
