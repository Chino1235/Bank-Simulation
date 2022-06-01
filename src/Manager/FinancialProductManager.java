package Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static banksimulate.SqlOptions.executeSql;
import static banksimulate.SqlOptions.queryFinancialProd;

public class FinancialProductManager implements Manager{
    String name;
    String annual_yield;
    Scanner scanner = new Scanner(System.in);
    String id;

    @Override
    public void add() {
        System.out.println("����");
        System.out.println("��Ʋ�Ʒ���ƣ�");
        name = scanner.nextLine();
        System.out.println("��Ʋ�Ʒ�����棺");
        annual_yield = scanner.nextLine();
        try {
            executeSql("INSERT INTO bank.financial_products(name,annual_yield) VALUES ('" + name + "','" + annual_yield + "');");
            System.out.println("��Ʒ��ӳɹ���");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("ɾ��");
        System.out.println("��Ʋ�Ʒ���");
        id  = scanner.nextLine();
        try {
            executeSql("delete from bank.financial_products where id = "+id);
            System.out.println("��Ʒɾ���ɹ���");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("�޸�");
        System.out.println("��Ʋ�Ʒ���");
        id  = scanner.nextLine();
        System.out.println("��Ʒ����");
        name = scanner.nextLine();
        System.out.println("��Ʋ�Ʒ������");
        annual_yield = scanner.nextLine();
        try {
                executeSql("update bank.financial_products set name = "+name+" annual_yield = "+annual_yield+" where id = "+id);
                System.out.println("��Ʒ�޸ĳɹ���");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void query() {
        System.out.println("����");
        System.out.println("1����Ʒ��Ų�������1");
        System.out.println("2����Ʒ���Ʋ�������2");
        System.out.println("3����Ʒ�������������3");

        int a = Integer.parseInt(scanner.nextLine());
        switch(a){
            case 1:
                System.out.println("�������Ʒ���");
                id = scanner.nextLine();
                try {
                    ResultSet result = queryFinancialProd("id", id);

                    int id = 0;
                    String name = null;
                    double annual_yield = 0;
                    while (result.next()) {
                        id = result.getInt("id");
                        name = result.getString("name");
                        annual_yield = result.getDouble("annual_yield");
                        System.out.println("��Ʒ���ҳɹ���\t");
                        System.out.println(id + "\t" + name + "\t" + annual_yield + "\t");
                        //todo:�����Ʒ��ϸ��Ϣ
                    }
                    result.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("�������Ʒ����");
                name = scanner.nextLine();
                try{
                    ResultSet result = queryFinancialProd("name",name);

                    int id = 0;
                    String name = null;
                    double annual_yield = 0;
                    while (result.next()) {
                        id = result.getInt("id");
                        name = result.getString("name");
                        annual_yield = result.getDouble("annual_yield");
                        System.out.println("��Ʒ���ҳɹ���\t");
                        System.out.println(id + "\t" + name + "\t" + annual_yield + "\t");
                        //todo:�����Ʒ��ϸ��Ϣ
                    }
                    result.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                System.out.println("�������Ʒ������");
                annual_yield = scanner.nextLine();
                try{
                    ResultSet result = queryFinancialProd("annual_yield", annual_yield);

                    int id = 0;
                    String name = null;
                    double annual_yield = 0;
                    while (result.next()) {
                        id = result.getInt("id");
                        name = result.getString("name");
                        annual_yield = result.getDouble("annual_yield");
                        System.out.println("��Ʒ���ҳɹ���\t");
                        System.out.println(id + "\t" + name + "\t" + annual_yield + "\t");
                        //todo:�����Ʒ��ϸ��Ϣ
                    }
                    result.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("�Ƿ�����");
                break;
        }
    }

    public static void menu(){
        System.out.println("���ѽ�����Ʋ�Ʒ��Ϣ����ϵͳ");
        System.out.println("���������");
        System.out.println("��ѡ������Ҫ�Ĳ���");
        System.out.println("1.�����Ʋ�Ʒ");
        System.out.println("2.ɾ����Ʋ�Ʒ");
        System.out.println("3.�޸���Ʋ�Ʒ");
        System.out.println("4.��ѯ��Ʋ�Ʒ");
        System.out.println("0.�˳�ϵͳ");
    }
}
