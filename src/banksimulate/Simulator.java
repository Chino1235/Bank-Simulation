package banksimulate;

import java.text.SimpleDateFormat;
import java.util.*;

public class Simulator {

    /**
     * 整存整取年利率
     */
    public static final double YearlyInterestofWDWW = 0.0325;
    /**
     * 零存整取年利率
     */
    public static final double YearlyInterestofLDWW = 0.0155;


    static Client client = new Client("John","62170009666666666666666","000000",0);
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/resources";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";

    public static void menu(){
        System.out.println("┏──────────────────────────────┓");
        System.out.println("│       欢  迎  您  来  到       │");
        System.out.println("│        次   元   银   行       │");
        System.out.println("│       请  选  择  操   作      │");
        System.out.println("│       1.活  期  存  款         │");
        System.out.println("│       2.整  存  整  取         │");
        System.out.println("│       3.零  存  整  取         │");
        System.out.println("│       4.整  存  零  取         │");
        System.out.println("│       5.查  看  详  情         │");
        System.out.println("│       6.取         款         │");
        System.out.println("│       7.生  活  缴  费         │");
        System.out.println("│       8.修  改  密  码         │");
        System.out.println("│       9.亲  友  转  账         │");
        System.out.println("│       0.退         卡         │");
        System.out.println("┗──────────────────────────────┛");
    }

    public static void basicInfoOutput(){
        System.out.println("存款人姓名：" + client.getClientName());
        System.out.println("存款人账号：" + client.getAccountNumber());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List depositList = new ArrayList<DepositType>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = sd.format(date);
        int currentProfile = 0;
        int onTimeProfile = 0;
        int currentWaterrate = 0;
        int currentElerate = 0;
        int currentGasrate = 0;
        int currentHeatrate = 0;
        for(;;){
            Calendar calendar = Calendar.getInstance();
            menu();
            int opt = sc.nextInt();
            switch (opt){
                case 1:{
                    System.out.print("请输入存款金额：");
                    int profile = sc.nextInt();
                    client.currentDeposit(profile);
                    basicInfoOutput();
                    System.out.println("存款金额："+ profile + "元");
                    System.out.println("当前账户余额为："+ client.getProfile() + "元");
                    DepositType depositType = new DepositType(profile,opt,0,today,"*",today,0);
                    depositList.add(depositType);
                    ClientReceipt.generateReceipt(client,profile);
                    currentProfile += profile;
                    break;
                }
                case 2:{
                    System.out.print("请输入存款金额：");
                    int profile = sc.nextInt();
                    System.out.print("请输入存款年限：");
                    int year = sc.nextInt();
                    client.wholeDepositandWithdraw(profile,year);
                    basicInfoOutput();
                    System.out.println("存款金额："+ profile + "元");
                    listAdder(depositList, sd, today, opt, profile, year);
                    ClientReceipt.generateReceipt(client,profile);
                    onTimeProfile += profile;
                    break;
                }

                case 3:{
                    System.out.print("请输入每月存入金额：");
                    int profile = sc.nextInt();
                    System.out.print("请输入存款年限：");
                    int year = sc.nextInt();
                    client.lumpsumDepositandwholeWithdraw(profile,year*12);
                    basicInfoOutput();
                    System.out.println("存款金额："+ client.depositProfile + "元");
                    System.out.println("到期利息："+ client.interest + "元");
                    listAdder(depositList, sd, today, opt, profile*12*year, year);
                    ClientReceipt.generateReceipt(client,profile*12*year);
                    onTimeProfile += (profile*12*year);
                    break;
                }
                case 4:{
                    System.out.print("请输入存款金额：");
                    int profile = sc.nextInt();
                    System.out.print("请输入支取次数：");
                    int time = sc.nextInt();
                    System.out.print("请输入存款年限：");
                    int year = sc.nextInt();
                    client.wholeDepositandLumpsumWithdraw(profile,time,year);
                    basicInfoOutput();
                    System.out.println("存款金额："+ profile + "元");
                    double formatt = (double)Math.round(client.interest *100)/100;
                    System.out.println("到期利息："+ formatt + "元");
                    listAdder(depositList, sd, today,opt, profile, year);
                    ClientReceipt.generateReceipt(client,profile);
                    onTimeProfile += profile;
                    break;
                }
                case 5:{
                    basicInfoOutput();
                    System.out.println("当前账户余额："+client.getProfile());
                    System.out.println("其中，活期余额"+currentProfile+"元，定期余额"+onTimeProfile+"元\n");
                    System.out.println("1-活期存款\n2-整存零取\n3-零存整取\n4-整存零取\n5-取款\n");
                    System.out.println("存款金额\t存款类型\t存款年限\t\t存款时间\t\t\t到期时间\t\t\t\t起息时间\t\t\t\t到期利息");
                    Iterator<DepositType> iterator = depositList.iterator();
                    while(iterator.hasNext()){
                        DepositType depositType = (DepositType) iterator.next();
                        System.out.println(depositType.toString());
                    }
                    break;
                }
                case 6:{
                    System.out.println("请输入取款金额");
                    int profile = sc.nextInt();
                    if(profile>currentProfile){
                        System.out.println("取款金额大于当前活期金额，无法取款！");
                        break;
                    }
                    System.out.println("取款成功！");
                    client.deposit(profile);
                    client.setProfile(client.getProfile()-profile);
                    currentProfile-=profile;
                    break;
                }
                case 7: {
                    System.out.println("请选择缴费项目:");
                    System.out.println("1.水费");
                    System.out.println("2.电费");
                    System.out.println("3.煤气费");
                    System.out.println("4.暖气费");
                    int PaymentForm = sc.nextInt();
                    if (PaymentForm == 1) {
                        System.out.println("请输入缴费金额:");
                        int waterrate = sc.nextInt();
                        if (waterrate > currentProfile) {
                            System.out.println("余额不足，无法缴费！");
                            break;
                        }
                        client.setProfile(client.getProfile() - waterrate);
                        client.setWaterrate(client.getWaterrate() + waterrate);
                        currentProfile -= waterrate;
                        currentWaterrate += waterrate;
                        System.out.println("缴费成功,银行卡余额为：" + currentProfile + "元,水费余额为"+currentWaterrate);
                        break;
                    }
                    if (PaymentForm == 2) {
                        System.out.println("请输入缴费金额:");
                        int elerate = sc.nextInt();
                        if (elerate > currentProfile) {
                            System.out.println("余额不足，无法缴费！");
                            break;
                        }
                        client.setProfile(client.getProfile() - elerate);
                        currentProfile -= elerate;
                        currentElerate += elerate;
                        System.out.println("缴费成功,银行卡余额为：" + currentProfile + "元,电费余额为"+currentElerate);
                        break;
                    }
                    if (PaymentForm == 3) {
                        System.out.println("请输入缴费金额:");
                        int gasrate = sc.nextInt();
                        if (gasrate > currentProfile) {
                            System.out.println("余额不足，无法缴费！");
                            break;
                        }
                        client.setProfile(client.getProfile() - gasrate);
                        currentProfile -= gasrate;
                        currentElerate += gasrate;
                        System.out.println("缴费成功,银行卡余额为：" + currentProfile + "元,煤气费余额为"+currentGasrate);
                        break;
                    }
                    if (PaymentForm == 4) {
                        System.out.println("请输入缴费金额:");
                        int heatrate = sc.nextInt();
                        if (heatrate > currentProfile) {
                            System.out.println("余额不足，无法缴费！");
                            break;
                        }
                        client.setProfile(client.getProfile() - heatrate);
                        currentProfile -= heatrate;
                        currentElerate += heatrate;
                        System.out.println("缴费成功,银行卡余额为：" + currentProfile + "元,暖气费余额为"+currentHeatrate);
                        break;
                    }
                }
                case 8:{
                    String password = "666666";
                    System.out.println("请输入旧密码");
                    String oldpassword = sc.nextLine();
                    if (oldpassword == password){
                        System.out.println("请输入新密码：");
                        String newpassword = sc.nextLine();
                        System.out.println("请再次输入密码:");
                        String renewpassword = sc.nextLine();
                        if (newpassword == renewpassword){
                            System.out.println("密码修改成功!");
                            password = newpassword;
                            break;
                        }
                        else {
                            System.out.println("两次密码输入不一致，请重新输入！");
                            break;
                        }
                    }
                    else{
                        System.out.println("密码错误，请重新输入!");
                        break;
                    }
                }
                case 9:{
                    System.out.println("请输入对方账号:");
                    int time = sc.nextInt();
                    System.out.println("请输入转账金额:");
                    int profile = sc.nextInt();
                    if (profile > currentProfile) {
                        System.out.println("余额不足，无法缴费！");
                        break;
                    }
                    client.setProfile(client.getProfile() - profile);
                    currentProfile -= profile;
                    System.out.println("缴费成功,银行卡余额为：" + currentProfile + "元!");
                    break;

                }
                case 0:{
                    System.out.println("感谢您的光临");
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("请重新选择");
                    break;
                }
            }
        }
    }

    public static void listAdder(List depositList, SimpleDateFormat sd, String today, int opt, int profile, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,year);
        Date date = calendar.getTime();
        String finalDate = sd.format(date);
        DepositType depositType = new DepositType(profile,opt,0,today,finalDate,today, client.interest);
        depositList.add(depositType);
    }




}
