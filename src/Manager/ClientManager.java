package Manager;

import java.sql.Connection;
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
        System.out.println("请输入想要删除的账户");
        account = sc.next();
        System.out.println("请输入密码");
        password = sc.next();
        System.out.println("确定要注销账户吗？");
        String answer = sc.next();
        if (answer.equals("y")) {
            String sql = "delete from account where name = ? and password= ?";
            boolean preparedStatement;
            try {
                Connection connection;
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, account);
                preparedStatement.setString(2, password);
                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    System.out.println("删除成功！");
                } else {
                    System.out.println("删除失败！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("退出删除用户");
        }


    }

    @Override
    public void change() {

        System.out.println("请输入你要修改的账户：");
        account = sc.nextLine();
        boolean bo=false;
        //遍历集合
        while(sc.next()) {
            //拿输入的账户和数据库的账户进行比较
            if(sc.getString("account:").equals(account)) {
                bo=true;
                break;
            }
        }

        if(bo == false) {
            System.out.println("不好意思,你要修改的账户对应的用户信息不存在,请回去重新你的选择");
        }else {
            System.out.println("请输入要更新的选项");
            System.out.println("1   姓名");
            int n;
            n=sc.nextInt();
            if(n==1) {
                System.out.println("请输入用户的新姓名：");
                String name = sc.next();
                String insertsql2 ="update List set name = '"+name+"'"; //更新语句
                state.executeUpdate(insertsql2);
            }else {
                System.out.println("输入格式错误，请重新输入");
            }
            System.out.println("修改学生成功");
        }

    }


    @Override
    public void query() {
        System.out.println("请输入要查询的账户");
        account = sc.nextInt();
       
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
