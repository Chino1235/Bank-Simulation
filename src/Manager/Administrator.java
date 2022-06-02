package Manager;

import uiDesigning.KillAccount;

import java.util.Scanner;

import static Manager.LogView.logView;

public class Administrator {

    public static Scanner sc = new Scanner(System.in);

    public static void clientManager(){
        ClientManager clientManager = new ClientManager();
        int option = 1;
        while(option != 0){
            ClientManager.menu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    clientManager.add();
                    break;
                case 2:
                    clientManager.delete();
                    break;
                case 3:
                    clientManager.change();
                    break;
                case 4:
                    clientManager.query();
                    break;
                default:
                    System.out.println("非法输入");
            }
        }
    }

    public static void financialProdManager(){
        FinancialProductManager financialProductManager = new FinancialProductManager();
        int option = 1;
        while(option != 0){
            FinancialProductManager.menu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    financialProductManager.add();
                    break;
                case 2:
                    financialProductManager.delete();
                    break;
                case 3:
                    financialProductManager.change();
                    break;
                case 4:
                    financialProductManager.query();
                    break;
                default:
                    System.out.println("非法输入");
            }
        }
    }

    public static void menu(){
        System.out.println("请选择操作：");
        System.out.println("1.客户信息管理");
        System.out.println("2.理财信息管理");
        System.out.println("3.银行流水查看");
        System.out.println("4.销户");
        System.out.println("0.退出系统");
    }

    public static boolean adminLogin(String name,String password){
        //todo:无需访问数据库
        String name1 = "root";
        String password1 = "root";
        Scanner sc = new Scanner(System.in);

        if (name.equals(name1)) {
            if (password.equals(password1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("欢迎使用村镇银行管理端，请先登录");
        System.out.println("请输入管理员账号：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        if(adminLogin(name,password)){
            int option =1;
            while(option != 0){
                menu();
                option = sc.nextInt();
                switch(option){
                    case 1:
                        clientManager();
                        break;
                    case 2:
                        financialProdManager();
                        break;
                    case 3:
                        logView();
                        break;
                    case 4:
                        new KillAccount();
                    default:
                        System.out.println("非法输入");
                        break;
                }
            }
        }
    }
}
