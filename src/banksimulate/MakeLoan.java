package banksimulate;

import java.util.Scanner;

public class MakeLoan {
    public static void Loan(){
        System.out.println("����������");
        Scanner input=new Scanner(System.in);
        double invest = input.nextDouble();     //�����

        System.out.println("�����������ʣ�(���磺5.25%����0.0525)");
        double yearRate = input.nextDouble();     //������

        double monthRate = yearRate/12;   //������
        System.out.println("��������������(���磺30�����360)");

        int month = input.nextInt();  //��������

        System.out.println("����-->"+invest+"   ������--->"+yearRate*100+"%"+"  ����--->"+month+"����");
        System.out.println("--------------------------------------------");

        // ÿ�±�Ϣ���  = (����������ʡ�(1��������)�޻�������)�� ((1��������)�޻�������-1))
        double monthIncome = (invest* monthRate * Math.pow(1+monthRate,month))/(Math.pow(1+monthRate,month)-1);
        //���������ȡ����λ
        String result = String.format("%.2f", monthIncome);

        System.out.println("ÿ�±�Ϣ��� : " + result);
        System.out.println("---------------------------------------------------");

        // ÿ�±��� = ����������ʡ�(1+������)^(���������-1)��((1+������)^��������-1))
        double monthCapital = 0;
        for(int i=1;i<month+1;i++){
            monthCapital = (invest* monthRate * (Math.pow((1+monthRate),i-1)))/(Math.pow(1+monthRate,month)-1);
            //���������ȡ����λ
            String monthCapital1 = String.format("%.2f", monthCapital);
            System.out.println("��" + i + "�±��� " + monthCapital1);
        }
        System.out.println("---------------------------------------------------");


        // ÿ����Ϣ  = ʣ�౾�� x ����������
        double monthInterest = 0;
        double capital = invest;
        double tmpCapital = 0;
        double totalInterest = 0;
        for(int i=1;i<month+1;i++){
            capital = capital - tmpCapital;
            monthInterest = capital * monthRate;
            tmpCapital = (invest* monthRate * (Math.pow((1+monthRate),i-1)))/(Math.pow(1+monthRate,month)-1);
            //���������ȡ����λ
            String ssa = String.format("%.2f", monthInterest);
            System.out.println("��" + i + "����Ϣ�� " + ssa);
            totalInterest = totalInterest + monthInterest;

        }

        System.out.println("-------------------------------------------------");
        //���������ȡ����λ
        String ss = String.format("%.2f", totalInterest);
        System.out.println("����Ϣ��--->"+ss+" Ԫ");
        System.out.println("-------------------------------------------------");
        System.out.println("�����ʣ�--->"+yearRate*100+"%");
        System.out.println("-------------------------------------------------");
        System.out.println("������� : " + month/12+" ��");
        System.out.println("-------------------------------------------------");
        System.out.println("ÿ�»��Ϣ��� : " + result+" Ԫ");
    }

    /**
     * ��ȡÿ�±�Ϣ���
     * ���㷽ʽ
     * ÿ�±�Ϣ���  = (����������ʡ�(1��������)�޻�������)�� ((1��������)�޻�������-1))
     * @param invest  ����
     * @param yearRate ������
     * @param month   ������
     * @return  ÿ�±�Ϣ���
     */
    public double getMonthIncome(double invest, double yearRate,int month){
        double monthRate = yearRate/12;   //������
        return (invest* monthRate * Math.pow(1+monthRate,month))/(Math.pow(1+monthRate,month)-1);
    }
}


