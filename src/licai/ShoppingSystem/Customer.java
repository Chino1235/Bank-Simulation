package licai.ShoppingSystem;

import java.util.Arrays;
import java.util.Scanner;

public class Customer extends FinancingSystem {
    public static void Buy(){
        //编写5个商品数据
        Good[] goods = new Good[3];
        goods[0] =new Good(1000,10000,"笔记本") ;
        goods[1] =new Good(1001,20000,"西红柿") ;
        goods[2] =new Good(1002,50000,"新能源") ;

        //2.展示数据
        System.out.println("----------基金商城---------");
        System.out.println(Arrays.toString(goods));
        int i = 0;
        //3.循环接收购买数据
        Scanner sc  = new Scanner(System.in);
        String  flag ="Y";
        while("Y".equals(flag)){
            System.out.println("请输入购买商品的序号(前方1开头为商品序号)");
            int id = sc.nextInt();
            //重复变量
            int count=0;
            double money=0;

            switch(id){
                case 1000:
                    System.out.println("请输入购买数量");
                    count = sc.nextInt();
                    money =count* Arrays.stream(goods).count();
                    System.out.println("您购买笔记本金融"+count+"份。一共花费"+10000*count+"元");
                    System.out.println("继续输入请输入Y，结束请输入N");
                    flag = sc.next();
                    break;
                case 1001:
                    System.out.println("请输入购买数量");
                    count = sc.nextInt();
                    money =count;
                    System.out.println("您购买西红柿金融"+count+"份。一共花费"+20000*count+"元");
                    System.out.println("继续输入请输入Y，结束请输入N");
                    flag = sc.next();
                    break;
                case 1002:
                    System.out.println("请输入购买数量");
                    count = sc.nextInt();
                    money =count;
                    System.out.println("您购买新能源金融"+count+"份。一共花费"+50000*count+"元");
                    System.out.println("继续输入请输入Y，结束请输入N");
                    flag = sc.next();
                    break;
                default:
                    System.out.println("你输入的序号有误");
                    break;
            }
        }
        System.out.println("这个项目我王多鱼投了!");
    }

}