package banksimulate;

import static banksimulate.Simulator.YearlyInterestofLDWW;
import static banksimulate.Simulator.YearlyInterestofWDWW;

/**
 * class: Client
 *
 * @author MaFeiyang CCUT
 * @date 2022/3/12
 */
public class Client {
    /**
     * �ͻ���
     */
    private String clientName;
    /**
     * �˺�
     */
    private String accountNumber;
    /**
     * ����
     */
    private String password;
    /**���
     *
     */
    private double profile;
    /**�����
     *
     */
    public double depositProfile;
    /**��Ϣ
     *
     */
    public double interest;

    private int waterrate;

    public Client(String clientName, String accountNumber, String password, double profile) {
        this.clientName = clientName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.profile = profile;
    }


    public String getClientName() {
        return clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {return password; }

    public double getProfile() {
        return profile;
    }

    public int getWaterrate() { return waterrate; }
    public void setWaterrate(int waterrate) { this.waterrate = waterrate; }
    public void setProfile(double profile) {
        this.profile = profile;
    }

    public void wholeDepositandWithdraw(double profile,int time){ //ʱ������Ϊ��λ
        double profile1 = profile;
        while(time!=0){
            profile = profile * (1+YearlyInterestofWDWW);
            time -= 1;
        }
        this.setProfile(this.getProfile()+profile1);
        this.depositProfile = profile;
        this.interest = profile - profile1;
    }

    public void wholeDepositandLumpsumWithdraw(double profile, int withdrawTime, int time){
        double withdrawPerTime = profile / withdrawTime;
        double totalInterest = (this.getProfile() + withdrawPerTime) / 2 * withdrawTime * 1 * YearlyInterestofWDWW / 12;
        this.setProfile(this.getProfile()+profile);
        this.depositProfile = profile;
        this.interest = totalInterest;
    }


    public void lumpsumDepositandwholeWithdraw(double profileMonthly,int depositTime){
        double totalDeposit = profileMonthly * depositTime;
        double totalInterest = profileMonthly * (depositTime + 1) / 2 * depositTime * YearlyInterestofLDWW / 12;
        this.setProfile(this.getProfile()+totalDeposit);
        this.depositProfile = totalDeposit;
        this.interest = totalInterest;
    }

    public void currentDeposit(double profile){
        this.setProfile(this.getProfile()+profile);
        this.depositProfile = profile;
    }
    public  void deposit(double profile){
        this.setProfile(this.getProfile()-profile);
    }

    @Override
    public String toString() {
        return "Client{" +
                "DepositProfile=" + depositProfile +
                ", Interest=" + interest +
                '}';
    }

}
