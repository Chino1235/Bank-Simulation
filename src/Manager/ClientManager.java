package Manager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static banksimulate.SqlOptions.*;

public class ClientManager implements Manager{

    String name;
    String account;
    String password;
    String confirm;
    Scanner sc = new Scanner(System.in);
    @Override
    public void add()  {
        System.out.println("������������֣�");
        name = sc.nextLine();
        System.out.println("����������˻���");
        account = sc.nextLine();
        System.out.println("������������룺");
        password = sc.nextLine();
        System.out.println("���ٴ�ȷ�����룺��");
        confirm = sc.nextLine();
        try {
            if(Objects.equals(confirm, password)){
                executeSql("INSERT INTO bank.client(account,name,password) VALUES ('"+account+"','"+name+"','"+password+"');");
                System.out.println("�û���ӳɹ���");
            }else{
                System.out.print("�������벻һ�£�����������������Ϣ��");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("��������Ҫɾ�����˻�");
        account = sc.next();
        System.out.println("����������");
        password = sc.next();
        System.out.println("ȷ��Ҫע���˻���");
        String answer = sc.next();
        if (answer.equals("y")) {
            String sql = "delete from bank.client where account = '" + account + "';";
            try {
                executeSql(sql);
                JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ϵͳ����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "���ݿ����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void change() {

        System.out.println("��������Ҫ�޸ĵ��˻���");
        account = sc.nextLine();
        try {
            String sql ="select * from bank.client where account = '"+account+"';";
            ResultSet result = queryClient("account",account);
            if(result == null){
                System.out.println("�˻���������������");
                return;
            }

            System.out.println("�������µ��û�����");
            name = sc.nextLine();
            System.out.println("�������µ����룺");
            password = sc.nextLine();
            sql ="update bank.client set name ='"+name+"',password ='"+password+"' where account ='"+account+"';";
            executeSql(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ϵͳ����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "���ݿ����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    @Override
    public void query() {
        System.out.println("��ѡ����Ҫ��ѯ�ķ�ʽ����1���û�����2���˻�");
        int number = sc.nextInt();
        if(number == 1){
            System.out.println("����������Ҫ��ѯ���û�����");
            name = sc.nextLine();
            try {
                ResultSet result = queryClient("name",name);
                //��ȡaccount��������
                String name = null;
                String account = null;
                double profile = 0;
                System.out.println("����\t�˺�\t\t\t\t\t���\t");
                while (result.next()) {
                    //��ȡaccount��������
                    account = result.getString("account");
                    //��ȡprofile��������
                    profile = result.getDouble("profile");
                    //��ȡoption��������
                    name = result.getString("name");
                    //������
                    System.out.println(name + "\t" + account + "\t" + profile + "\t");
                }
                result.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else if(number ==  2){
            System.out.println("����������Ҫ��ѯ���˺ţ�");
            name = sc.nextLine();
            try {
                ResultSet result = queryClient("account",account);
                //��ȡaccount��������
                String name = null;
                String account = null;
                double profile = 0;
                System.out.println("����\t�˺�\t\t\t\t\t���\t");
                while (result.next()) {
                    //��ȡaccount��������
                    account = result.getString("account");
                    //��ȡprofile��������
                    profile = result.getDouble("profile");
                    //��ȡoption��������
                    name = result.getString("name");
                    //������
                    System.out.println(name + "\t" + account + "\t" + profile + "\t");
                }
                result.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("��������ȷ��ָ�");
        }


    }

    public static void menu(){
        System.out.println("���ѽ���ͻ���Ϣ����ϵͳ");
        System.out.println("���������");
        System.out.println("��ѡ������Ҫ�Ĳ���");
        System.out.println("1.��ӿͻ�");
        System.out.println("2.ɾ���ͻ�");
        System.out.println("3.�޸Ŀͻ�");
        System.out.println("4.��ѯ�ͻ�");
        System.out.println("0.�˳�ϵͳ");
    }
}
