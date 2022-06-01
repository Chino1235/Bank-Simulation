package Manager;

import banksimulate.SqlOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static banksimulate.SqlOptions.queryAllLog;

public class LogView {

    public static void logView() {


        try {
            //Ҫִ�е�SQL���
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = queryAllLog();
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");
            System.out.println("-----------------");
            System.out.println("�˻�" + "\t" + "���" + "\t" + "����" + "\t");
            System.out.println("-----------------");

            String account = null;
            String profile = null;
            String option = null;

            while (rs.next()) {
                //��ȡaccount��������
                account = rs.getString("account");
                //��ȡprofile��������
                profile = rs.getString("profile");
                //��ȡoption��������
                option = rs.getString("option");
                //������
                System.out.println(profile + "\t" + account + "\t" + option + "\t");
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (Exception e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();
        }
        finally {
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }

}