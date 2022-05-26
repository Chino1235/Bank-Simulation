package banksimulate;

import java.text.SimpleDateFormat;
import java.util.*;

public class Simulator {

    /**
     * ������ȡ������
     */
    public static final double YearlyInterestofWDWW = 0.0325;
    /**
     * �����ȡ������
     */
    public static final double YearlyInterestofLDWW = 0.0155;


    static Client client = new Client("John","62170009666666666666666","000000",0);
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/resources";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";

    public static void menu(){
        System.out.println("����������������������������������������������������������������");
        System.out.println("��       ��  ӭ  ��  ��  ��       ��");
        System.out.println("��        ��   Ԫ   ��   ��       ��");
        System.out.println("��       ��  ѡ  ��  ��   ��      ��");
        System.out.println("��       1.��  ��  ��  ��         ��");
        System.out.println("��       2.��  ��  ��  ȡ         ��");
        System.out.println("��       3.��  ��  ��  ȡ         ��");
        System.out.println("��       4.��  ��  ��  ȡ         ��");
        System.out.println("��       5.��  ��  ��  ��         ��");
        System.out.println("��       6.ȡ         ��         ��");
        System.out.println("��       7.��  ��  ��  ��         ��");
        System.out.println("��       8.��  ��  ��  ��         ��");
        System.out.println("��       9.��  ��  ת  ��         ��");
        System.out.println("��       0.��         ��         ��");
        System.out.println("����������������������������������������������������������������");
    }

    public static void basicInfoOutput(){
        System.out.println("�����������" + client.getClientName());
        System.out.println("������˺ţ�" + client.getAccountNumber());
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
                    System.out.print("���������");
                    int profile = sc.nextInt();
                    client.currentDeposit(profile);
                    basicInfoOutput();
                    System.out.println("����"+ profile + "Ԫ");
                    System.out.println("��ǰ�˻����Ϊ��"+ client.getProfile() + "Ԫ");
                    DepositType depositType = new DepositType(profile,opt,0,today,"*",today,0);
                    depositList.add(depositType);
                    ClientReceipt.generateReceipt(client,profile);
                    currentProfile += profile;
                    break;
                }
                case 2:{
                    System.out.print("���������");
                    int profile = sc.nextInt();
                    System.out.print("�����������ޣ�");
                    int year = sc.nextInt();
                    client.wholeDepositandWithdraw(profile,year);
                    basicInfoOutput();
                    System.out.println("����"+ profile + "Ԫ");
                    listAdder(depositList, sd, today, opt, profile, year);
                    ClientReceipt.generateReceipt(client,profile);
                    onTimeProfile += profile;
                    break;
                }

                case 3:{
                    System.out.print("������ÿ�´����");
                    int profile = sc.nextInt();
                    System.out.print("�����������ޣ�");
                    int year = sc.nextInt();
                    client.lumpsumDepositandwholeWithdraw(profile,year*12);
                    basicInfoOutput();
                    System.out.println("����"+ client.depositProfile + "Ԫ");
                    System.out.println("������Ϣ��"+ client.interest + "Ԫ");
                    listAdder(depositList, sd, today, opt, profile*12*year, year);
                    ClientReceipt.generateReceipt(client,profile*12*year);
                    onTimeProfile += (profile*12*year);
                    break;
                }
                case 4:{
                    System.out.print("���������");
                    int profile = sc.nextInt();
                    System.out.print("������֧ȡ������");
                    int time = sc.nextInt();
                    System.out.print("�����������ޣ�");
                    int year = sc.nextInt();
                    client.wholeDepositandLumpsumWithdraw(profile,time,year);
                    basicInfoOutput();
                    System.out.println("����"+ profile + "Ԫ");
                    double formatt = (double)Math.round(client.interest *100)/100;
                    System.out.println("������Ϣ��"+ formatt + "Ԫ");
                    listAdder(depositList, sd, today,opt, profile, year);
                    ClientReceipt.generateReceipt(client,profile);
                    onTimeProfile += profile;
                    break;
                }
                case 5:{
                    basicInfoOutput();
                    System.out.println("��ǰ�˻���"+client.getProfile());
                    System.out.println("���У��������"+currentProfile+"Ԫ���������"+onTimeProfile+"Ԫ\n");
                    System.out.println("1-���ڴ��\n2-������ȡ\n3-�����ȡ\n4-������ȡ\n5-ȡ��\n");
                    System.out.println("�����\t�������\t�������\t\t���ʱ��\t\t\t����ʱ��\t\t\t\t��Ϣʱ��\t\t\t\t������Ϣ");
                    Iterator<DepositType> iterator = depositList.iterator();
                    while(iterator.hasNext()){
                        DepositType depositType = (DepositType) iterator.next();
                        System.out.println(depositType.toString());
                    }
                    break;
                }
                case 6:{
                    System.out.println("������ȡ����");
                    int profile = sc.nextInt();
                    if(profile>currentProfile){
                        System.out.println("ȡ������ڵ�ǰ���ڽ��޷�ȡ�");
                        break;
                    }
                    System.out.println("ȡ��ɹ���");
                    client.deposit(profile);
                    client.setProfile(client.getProfile()-profile);
                    currentProfile-=profile;
                    break;
                }
                case 7: {
                    System.out.println("��ѡ��ɷ���Ŀ:");
                    System.out.println("1.ˮ��");
                    System.out.println("2.���");
                    System.out.println("3.ú����");
                    System.out.println("4.ů����");
                    int PaymentForm = sc.nextInt();
                    if (PaymentForm == 1) {
                        System.out.println("������ɷѽ��:");
                        int waterrate = sc.nextInt();
                        if (waterrate > currentProfile) {
                            System.out.println("���㣬�޷��ɷѣ�");
                            break;
                        }
                        client.setProfile(client.getProfile() - waterrate);
                        client.setWaterrate(client.getWaterrate() + waterrate);
                        currentProfile -= waterrate;
                        currentWaterrate += waterrate;
                        System.out.println("�ɷѳɹ�,���п����Ϊ��" + currentProfile + "Ԫ,ˮ�����Ϊ"+currentWaterrate);
                        break;
                    }
                    if (PaymentForm == 2) {
                        System.out.println("������ɷѽ��:");
                        int elerate = sc.nextInt();
                        if (elerate > currentProfile) {
                            System.out.println("���㣬�޷��ɷѣ�");
                            break;
                        }
                        client.setProfile(client.getProfile() - elerate);
                        currentProfile -= elerate;
                        currentElerate += elerate;
                        System.out.println("�ɷѳɹ�,���п����Ϊ��" + currentProfile + "Ԫ,������Ϊ"+currentElerate);
                        break;
                    }
                    if (PaymentForm == 3) {
                        System.out.println("������ɷѽ��:");
                        int gasrate = sc.nextInt();
                        if (gasrate > currentProfile) {
                            System.out.println("���㣬�޷��ɷѣ�");
                            break;
                        }
                        client.setProfile(client.getProfile() - gasrate);
                        currentProfile -= gasrate;
                        currentElerate += gasrate;
                        System.out.println("�ɷѳɹ�,���п����Ϊ��" + currentProfile + "Ԫ,ú�������Ϊ"+currentGasrate);
                        break;
                    }
                    if (PaymentForm == 4) {
                        System.out.println("������ɷѽ��:");
                        int heatrate = sc.nextInt();
                        if (heatrate > currentProfile) {
                            System.out.println("���㣬�޷��ɷѣ�");
                            break;
                        }
                        client.setProfile(client.getProfile() - heatrate);
                        currentProfile -= heatrate;
                        currentElerate += heatrate;
                        System.out.println("�ɷѳɹ�,���п����Ϊ��" + currentProfile + "Ԫ,ů�������Ϊ"+currentHeatrate);
                        break;
                    }
                }
                case 8:{
                    String password = "666666";
                    System.out.println("�����������");
                    String oldpassword = sc.nextLine();
                    if (oldpassword == password){
                        System.out.println("�����������룺");
                        String newpassword = sc.nextLine();
                        System.out.println("���ٴ���������:");
                        String renewpassword = sc.nextLine();
                        if (newpassword == renewpassword){
                            System.out.println("�����޸ĳɹ�!");
                            password = newpassword;
                            break;
                        }
                        else {
                            System.out.println("�����������벻һ�£����������룡");
                            break;
                        }
                    }
                    else{
                        System.out.println("�����������������!");
                        break;
                    }
                }
                case 9:{
                    System.out.println("������Է��˺�:");
                    int time = sc.nextInt();
                    System.out.println("������ת�˽��:");
                    int profile = sc.nextInt();
                    if (profile > currentProfile) {
                        System.out.println("���㣬�޷��ɷѣ�");
                        break;
                    }
                    client.setProfile(client.getProfile() - profile);
                    currentProfile -= profile;
                    System.out.println("�ɷѳɹ�,���п����Ϊ��" + currentProfile + "Ԫ!");
                    break;

                }
                case 0:{
                    System.out.println("��л���Ĺ���");
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("������ѡ��");
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
