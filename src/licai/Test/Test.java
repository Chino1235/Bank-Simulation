package licai.Test;

import licai.ShoppingSystem.Customer;
import licai.ShoppingSystem.FinancingSystem;
import licai.dao.impl.UserDaoImpl;
import licai.domain.User;

import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        while(true){
            //首先给出提示
            System.out.println("欢迎进入注册登录界面：");
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("3.退出");

            //创建一个用户操作类
            UserDaoImpl udi = new UserDaoImpl();

            //创建键盘录入对象，并获取键盘录入数据
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();

            //利用switch循环来判断
            switch (choice) {
                case "1":
                    System.out.println("欢迎来到注册界面！");
                    System.out.println("请输入用户名：");
                    String userName = sc.nextLine();
                    System.out.println("请输入密码：");
                    String passWord = sc.nextLine();
                    //把用户名和密码封装成一个用户类对象
                    User user = new User(userName,passWord);
                    //通过用户操作类对象调用注册方法
                    udi.regist(user);
                    System.out.println("注册成功！");
                    break;

                case "2":
                    System.out.println("欢迎来到登录界面！");
                    System.out.println("请输入用户名：");
                    String inputUserName = sc.nextLine();
                    System.out.println("请输入密码：");
                    String inputPassWord = sc.nextLine();
                    //通过用户操作类对象调用登录方法
                    boolean flag = udi.isLogin(inputUserName,inputPassWord);
                    if ((Objects.equals(inputPassWord, "123") && Objects.equals(inputUserName, "admin"))){
                        System.out.println("登录成功！");
                        FinancingSystem.Change();
                    }
                    else if(flag){
                        if (Objects.equals(inputPassWord, "123") && Objects.equals(inputUserName, "admin")) {
                            System.out.println("登录成功！");
                            FinancingSystem.Change();
                            break;
                        }else{
                            Customer.Buy();
                            break;
                        }
                    }else{
                        System.out.println("登录失败！");
                    }
                    break;

                case "3":{
                }
                default:
                    //对于3或者其他数字的选择，都直接退出系统
                    System.exit(0);
                    break;
            }

        }
    }
}
