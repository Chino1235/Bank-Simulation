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

        System.out.println("请输入贷款本金：");


        double invest = r.nextInt(10)+10;    //贷款本金

        System.out.println("请输入年利率：(例如：5.25%就是0.0525)");
        double yearRate = r.nextInt(10)+10;      //年利率

        double monthRate = yearRate/12;   //月利率
        System.out.println("请输入借款月数：(例如：30年就是360)");

        int month = r.nextInt(10)+10;   //还款月数

        System.out.println("本金-->"+invest+"   年利率--->"+yearRate*100+"%"+"  期限--->"+month+"个月");
        System.out.println("--------------------------------------------");

        // 每月本息金额  = (本金×月利率×(1＋月利率)＾还款月数)÷ ((1＋月利率)＾还款月数-1))
        double monthIncome = (invest* monthRate * Math.pow(1+monthRate,month))/(Math.pow(1+monthRate,month)-1);
        //四舍五入截取后两位
        String result = String.format("%.2f", monthIncome);

        System.out.println("每月本息金额 : " + result);
        System.out.println("---------------------------------------------------");

        // 每月本金 = 本金×月利率×(1+月利率)^(还款月序号-1)÷((1+月利率)^还款月数-1))
        double monthCapital = 0;
        for(int i=1;i<month+1;i++){
            monthCapital = (invest* monthRate * (Math.pow((1+monthRate),i-1)))/(Math.pow(1+monthRate,month)-1);
            //四舍五入截取后两位
            String monthCapital1 = String.format("%.2f", monthCapital);
            System.out.println("第" + i + "月本金： " + monthCapital1);
        }
        System.out.println("---------------------------------------------------");


        // 每月利息  = 剩余本金 x 贷款月利率
        double monthInterest = 0;
        double capital = invest;
        double tmpCapital = 0;
        double totalInterest = 0;
        for(int i=1;i<month+1;i++){
            capital = capital - tmpCapital;
            monthInterest = capital * monthRate;
            tmpCapital = (invest* monthRate * (Math.pow((1+monthRate),i-1)))/(Math.pow(1+monthRate,month)-1);
            //四舍五入截取后两位
            String ssa = String.format("%.2f", monthInterest);
            System.out.println("第" + i + "月利息： " + ssa);
            totalInterest = totalInterest + monthInterest;

        }

        System.out.println("-------------------------------------------------");
        //四舍五入截取后两位
        String ss = String.format("%.2f", totalInterest);
        System.out.println("总利息：--->"+ss+" 元");
        System.out.println("-------------------------------------------------");
        System.out.println("年利率：--->"+yearRate*100+"%");
        System.out.println("-------------------------------------------------");
        System.out.println("借款期限 : " + month/12+" 年");
        System.out.println("-------------------------------------------------");
        System.out.println("每月还款本息金额 : " + result+" 元");
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