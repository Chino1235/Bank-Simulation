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
            //���ȸ�����ʾ
            System.out.println("��ӭ����ע���¼���棺");
            System.out.println("1.ע��");
            System.out.println("2.��¼");
            System.out.println("3.�˳�");

            //����һ���û�������
            UserDaoImpl udi = new UserDaoImpl();

            //��������¼����󣬲���ȡ����¼������
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();

            //����switchѭ�����ж�
            switch (choice) {
                case "1":
                    System.out.println("��ӭ����ע����棡");
                    System.out.println("�������û�����");
                    String userName = sc.nextLine();
                    System.out.println("���������룺");
                    String passWord = sc.nextLine();
                    //���û����������װ��һ���û������
                    User user = new User(userName,passWord);
                    //ͨ���û�������������ע�᷽��
                    udi.regist(user);
                    System.out.println("ע��ɹ���");
                    break;

                case "2":
                    System.out.println("��ӭ������¼���棡");
                    System.out.println("�������û�����");
                    String inputUserName = sc.nextLine();
                    System.out.println("���������룺");
                    String inputPassWord = sc.nextLine();
                    //ͨ���û������������õ�¼����
                    boolean flag = udi.isLogin(inputUserName,inputPassWord);
                    if ((Objects.equals(inputPassWord, "123") && Objects.equals(inputUserName, "admin"))){
                        System.out.println("��¼�ɹ���");
                        FinancingSystem.Change();
                    }
                    else if(flag){
                        if (Objects.equals(inputPassWord, "123") && Objects.equals(inputUserName, "admin")) {
                            System.out.println("��¼�ɹ���");
                            FinancingSystem.Change();
                            break;
                        }else{
                            Customer.Buy();
                            break;
                        }
                    }else{
                        System.out.println("��¼ʧ�ܣ�");
                    }
                    break;

                case "3":{
                }
                default:
                    //����3�����������ֵ�ѡ�񣬶�ֱ���˳�ϵͳ
                    System.exit(0);
                    break;
            }

        }
    }
}
