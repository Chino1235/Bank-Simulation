package Manager;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static banksimulate.SqlOptions.executeSql;

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

    }

    @Override
    public void change() {

    }

    @Override
    public void query() {

    }
}
