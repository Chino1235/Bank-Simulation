package licai.ShoppingSystem;
import java.util.Arrays;
import java.util.Scanner;

public class FinancingSystem {
     public static void Change(){
        //1.����������鲢��ֵ
        Good[] goods = new Good[3];
        goods[0] =new Good(1000,10000,"�ʼǱ�") ;
        goods[1] =new Good(1001,20000,"������") ;
        goods[2] =new Good(1002,50000,"����Դ") ;

        //2.����Scanner���󲢵��û�ȡ����̨������Ϣ�ķ���
        Scanner sc = new Scanner(System.in);

        //3.����ѭ������
        boolean isWork=true;
        //4.���������Ʒ���
        int indexNum;
        //5.�����������Ʒ��ŵ��±�
        int index=0;

        while (isWork){
            System.out.println("===================���й���ϵͳ==================");
            System.out.println("1:�����嵥\t2:���ӻ���\t3:ɾ������\t4:�޸Ļ���\t5:�˳�");
            System.out.println("�����Ҫ�����ı�ţ�");
            int choseNum = sc.nextInt();
            System.out.println();

            //1:�����嵥
            if(choseNum==1){
                System.out.println("===================��Ʒ�嵥==================");
                System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ����");
                for (int i = 0; i <goods.length ; i++) {
                    if(goods[i]!=null){
                        System.out.println(goods[i].toString());
                    }
                }
                //2:���ӻ���
            }else if(choseNum==2){
                System.out.println("��ѡ����������Ʒ����");
                //2.1���Ӷ������鳤��
                goods=Arrays.copyOf(goods,goods.length+1);
                //2.2�����¶��󲢰Ѷ��������������
                goods[3]= new Good();
                //goods[3]=goods4;
                //2.3��̬��ֵ
                System.out.print("������Ʒ���ID��");
                goods[goods.length-1].setId(sc.nextInt());
                System.out.print("������Ʒ���ۣ�");
                goods[goods.length-1].setPirce(sc.nextDouble());
                System.out.print("������Ʒ���ƣ�");
                goods[goods.length-1].setName(sc.next());
                System.out.println("��ӳɹ�");

                //3:ɾ������
            }else if(choseNum==3){
                System.out.println("��ѡ�����ɾ������");
                System.out.println("����Ҫɾ������Ʒ���ID");
                indexNum=sc.nextInt();
                //�ҵ���Ӧ��Ʒ��ŵĶ��󲢸�ֵΪnull ��
                for (int i = 0; i <goods.length ; i++) {
                    if(indexNum == goods[i].getId()){
                        goods[i]=null;
                    }
                }
                System.out.println("ɾ���ɹ�");
                //4:�޸Ļ���
            }else if(choseNum==4){
                System.out.println("ѡ�����޸Ĺ���");
                System.out.println("������Ҫ�޸ĵ���Ʒ���ID");
                indexNum=sc.nextInt();
                //�ҵ���Ӧ��Ʒ��ŵ�һά���顣
                for (int i = 0; i <goods.length ; i++) {
                    if(indexNum==goods[i].getId()){
                        index=i;
                    }
                }
                System.out.println("�����µ���Ʒ���");
                goods[index].setId(sc.nextInt());
                System.out.println("������Ʒ����");
                goods[index].setPirce(sc.nextDouble());
                System.out.println("������Ʒ����");
                goods[index].setName(sc.next());
                System.out.println("�޸ĳɹ�");
                //5:�˳�
            }else if(choseNum==5){
                isWork=false;
            }else{
                System.out.println("���������ѡ��1-5�����֣�");
            }
        }

    }
}

