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
        System.out.println("请输入你的名字：");
        name = sc.nextLine();
        System.out.println("请输入你的账户：");
        account = sc.nextLine();
        System.out.println("请输入你的密码：");
        password = sc.nextLine();
        System.out.println("请再次确认密码：：");
        confirm = sc.nextLine();
        try {
            if(Objects.equals(confirm, password)){
                executeSql("INSERT INTO bank.client(account,name,password) VALUES ('"+account+"','"+name+"','"+password+"');");
                System.out.println("用户添加成功！");
            }else{
                System.out.print("两次密码不一致，请重新输入所有信息！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("请输入想要删除的账户");
        account = sc.next();
        System.out.println("请输入密码");
        password = sc.next();
        System.out.println("确定要注销账户吗？");
        String answer = sc.next();
        if (answer.equals("y")) {
            String sql = "delete from bank.client where account = '" + account + "';";
            try {
                executeSql(sql);
                JOptionPane.showMessageDialog(null, "删除成功", "信息", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "系统错误", "信息", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "数据库错误", "信息", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void change() {

        System.out.println("请输入你要修改的账户：");
        account = sc.nextLine();
        try {
            String sql ="select * from bank.client where account = '"+account+"';";
            ResultSet result = queryClient("account",account);
            if(result == null){
                System.out.println("账户错误，请重新输入");
                return;
            }

            System.out.println("请输入新的用户名：");
            name = sc.nextLine();
            System.out.println("请输入新的密码：");
            password = sc.nextLine();
            sql ="update bank.client set name ='"+name+"',password ='"+password+"' where account ='"+account+"';";
            executeSql(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "系统错误", "信息", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "数据库错误", "信息", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    @Override
    public void query() {
        System.out.println("请选择您要查询的方式：（1）用户名（2）账户");
        int number = sc.nextInt();
        if(number == 1){
            System.out.println("请输入您想要查询的用户名：");
            name = sc.nextLine();
            try {
                ResultSet result = queryClient("name",name);
                //获取account这列数据
                String name = null;
                String account = null;
                double profile = 0;
                System.out.println("姓名\t账号\t\t\t\t\t余额\t");
                while (result.next()) {
                    //获取account这列数据
                    account = result.getString("account");
                    //获取profile这列数据
                    profile = result.getDouble("profile");
                    //获取option这列数据
                    name = result.getString("name");
                    //输出结果
                    System.out.println(name + "\t" + account + "\t" + profile + "\t");
                }
                result.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else if(number ==  2){
            System.out.println("请输入您想要查询的账号：");
            name = sc.nextLine();
            try {
                ResultSet result = queryClient("account",account);
                //获取account这列数据
                String name = null;
                String account = null;
                double profile = 0;
                System.out.println("姓名\t账号\t\t\t\t\t余额\t");
                while (result.next()) {
                    //获取account这列数据
                    account = result.getString("account");
                    //获取profile这列数据
                    profile = result.getDouble("profile");
                    //获取option这列数据
                    name = result.getString("name");
                    //输出结果
                    System.out.println(name + "\t" + account + "\t" + profile + "\t");
                }
                result.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("请输入正确的指令！");
        }


    }

    public static void menu(){
        System.out.println("您已进入客户信息管理系统");
        System.out.println("请谨慎操作");
        System.out.println("请选择您需要的操作");
        System.out.println("1.添加客户");
        System.out.println("2.删除客户");
        System.out.println("3.修改客户");
        System.out.println("4.查询客户");
        System.out.println("0.退出系统");
    }
}
