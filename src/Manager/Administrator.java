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
                    System.out.println("�Ƿ�����");
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
                    System.out.println("�Ƿ�����");
            }
        }
    }

    public static void menu(){
        System.out.println("��ѡ�������");
        System.out.println("1.�ͻ���Ϣ����");
        System.out.println("2.�����Ϣ����");
        System.out.println("3.������ˮ�鿴");
        System.out.println("4.����");
        System.out.println("0.�˳�ϵͳ");
    }

    public static boolean adminLogin(){
        //todo:����������ݿ�
        String name;
        String name1 = "root";
        String password;
        String password1 = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("���������Ա�˺ţ�");
        name = sc.nextLine();
        System.out.println("���������룺");
        password = sc.nextLine();

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
        System.out.println("��ӭʹ�ô������й���ˣ����ȵ�¼");
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
                    case 4:
                        new KillAccount();
                    default:
                        System.out.println("�Ƿ�����");
                        break;
                }
            }
        }
    }
}
