package licai.ShoppingSystem;

import java.util.Arrays;
import java.util.Scanner;

public class Customer extends FinancingSystem {
    public static void Buy(){
        //��д5����Ʒ����
        Good[] goods = new Good[3];
        goods[0] =new Good(1000,10000,"�ʼǱ�") ;
        goods[1] =new Good(1001,20000,"������") ;
        goods[2] =new Good(1002,50000,"����Դ") ;

        //2.չʾ����
        System.out.println("----------�����̳�---------");
        System.out.println(Arrays.toString(goods));
        int i = 0;
        //3.ѭ�����չ�������
        Scanner sc  = new Scanner(System.in);
        String  flag ="Y";
        do{
            System.out.println("�����빺����Ʒ�����(ǰ��1��ͷΪ��Ʒ���)");
            int id = sc.nextInt();
            //�ظ�����
            int count=0;
            double money=0;

            switch(id){
                case 1000:
                    System.out.println("�����빺������");
                    count = sc.nextInt();
                    money =count* Arrays.stream(goods).count();
                    System.out.println("������ʼǱ�����"+count+"�ݡ�һ������"+10000*count+"Ԫ");
                    System.out.println("��������������y������������n");
                    flag = sc.next();
                    break;
                case 1001:
                    System.out.println("�����빺������");
                    count = sc.nextInt();
                    money =count;
                    System.out.println("����������������"+count+"�ݡ�һ������"+20000*count+"Ԫ");
                    System.out.println("��������������y������������n");
                    flag = sc.next();
                    break;
                case 1002:
                    System.out.println("�����빺������");
                    count = sc.nextInt();
                    money =count;
                    System.out.println("����������Դ����"+count+"�ݡ�һ������"+50000*count+"Ԫ");
                    System.out.println("��������������y������������n");
                    flag = sc.next();
                    break;
                default:
                    System.out.println("��������������");
                    break;
            }
        }while ("y".equals(flag));
        System.out.println("�����Ŀ��������Ͷ��!");
    }

}