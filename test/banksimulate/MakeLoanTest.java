package banksimulate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;
import java.util.SplittableRandom;

import static org.junit.Assert.*;

public class MakeLoanTest {

    MakeLoan makeLoan = new MakeLoan();

    @Before
    public void setUp() throws Exception {
        new MakeLoan();

    }

    @After
    public void tearDown() throws Exception {
        assertEquals(1,1);
    }

    @Test
    public void loan() {
        Random r = new Random();

        System.out.println("����������");


        double invest = r.nextInt(10)+10;    //�����

        System.out.println("�����������ʣ�(���磺5.25%����0.0525)");
        double yearRate = r.nextInt(10)+10;      //������

        double monthRate = yearRate/12;   //������
        System.out.println("��������������(���磺30�����360)");

        int month = r.nextInt(10)+10;   //��������

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


    @Test
    public void getMonthIncome(){
        double invest = 10000;
        double yearRate = 0.0525;
        double monthRate = yearRate/12;
        int month = 12;
        float result = (float) makeLoan.getMonthIncome(10000, 0.525, 12);
        assertEquals(1088.8342,result,0.0001);

    }
}