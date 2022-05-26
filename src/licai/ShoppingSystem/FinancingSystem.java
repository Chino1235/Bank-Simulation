package licai.ShoppingSystem;
import java.util.Arrays;
import java.util.Scanner;

public class FinancingSystem {
     public static void Change(){
        //1.定义对象数组并赋值
        Good[] goods = new Good[3];
        goods[0] =new Good(1000,10000,"笔记本") ;
        goods[1] =new Good(1001,20000,"西红柿") ;
        goods[2] =new Good(1002,50000,"新能源") ;

        //2.创建Scanner对象并调用获取控制台输入信息的方法
        Scanner sc = new Scanner(System.in);

        //3.定义循环条件
        boolean isWork=true;
        //4.定义操作商品编号
        int indexNum;
        //5.定义操作的商品编号的下标
        int index=0;

        while (isWork){
            System.out.println("===================超市管理系统==================");
            System.out.println("1:货物清单\t2:增加货物\t3:删除货物\t4:修改货物\t5:退出");
            System.out.println("输出你要操作的编号：");
            int choseNum = sc.nextInt();
            System.out.println();

            //1:货物清单
            if(choseNum==1){
                System.out.println("===================商品清单==================");
                System.out.println("商品编号\t商品单价\t商品名称");
                for (int i = 0; i <goods.length ; i++) {
                    if(goods[i]!=null){
                        System.out.println(goods[i].toString());
                    }
                }
                //2:增加货物
            }else if(choseNum==2){
                System.out.println("您选择的是添加商品功能");
                //2.1增加对象数组长度
                goods=Arrays.copyOf(goods,goods.length+1);
                //2.2创建新对象并把对象放入新数组中
                goods[3]= new Good();
                //goods[3]=goods4;
                //2.3动态赋值
                System.out.print("输入商品编号ID：");
                goods[goods.length-1].setId(sc.nextInt());
                System.out.print("输入商品单价：");
                goods[goods.length-1].setPirce(sc.nextDouble());
                System.out.print("输入商品名称：");
                goods[goods.length-1].setName(sc.next());
                System.out.println("添加成功");

                //3:删除货物
            }else if(choseNum==3){
                System.out.println("您选择的是删除功能");
                System.out.println("输入要删除的商品编号ID");
                indexNum=sc.nextInt();
                //找到对应商品编号的对象并赋值为null 。
                for (int i = 0; i <goods.length ; i++) {
                    if(indexNum == goods[i].getId()){
                        goods[i]=null;
                    }
                }
                System.out.println("删除成功");
                //4:修改货物
            }else if(choseNum==4){
                System.out.println("选的是修改功能");
                System.out.println("输入你要修改的商品编号ID");
                indexNum=sc.nextInt();
                //找到对应商品编号的一维数组。
                for (int i = 0; i <goods.length ; i++) {
                    if(indexNum==goods[i].getId()){
                        index=i;
                    }
                }
                System.out.println("输入新的商品编号");
                goods[index].setId(sc.nextInt());
                System.out.println("输入商品单价");
                goods[index].setPirce(sc.nextDouble());
                System.out.println("输入商品名称");
                goods[index].setName(sc.next());
                System.out.println("修改成功");
                //5:退出
            }else if(choseNum==5){
                isWork=false;
            }else{
                System.out.println("输入错误，请选择1-5的数字！");
            }
        }

    }
}

