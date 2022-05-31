package Manager;

import java.util.Scanner;

import static Manager.LogView.logView;

public class Administrator {

    public static Scanner sc = new Scanner(System.in);

    public static void clientManager(){
        ClientManager clientManager = new ClientManager();
        int option = 1;
        while(option != 0){
            menu();
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
            menu();
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
        System.out.println("0.退出系统");
    }

    public static boolean adminLogin(){
        //todo:无需访问数据库
    }

    public static void main(String[] args) {
        System.out.println("欢迎使用村镇银行管理端，请先登录");
        if(adminLogin()){
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
                    default:
                        System.out.println("非法输入");
                        break;
                }
            }
        }
    }
}
