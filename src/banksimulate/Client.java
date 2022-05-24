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
     * 客户名
     */
    private String clientName;
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String password;
    /**余额
     *
     */
    private double profile;
    /**存款金额
     *
     */
    public double depositProfile;
    /**利息
     *
     */
    public double interest;

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

    public double getProfile() {
        return profile;
    }

    public void setProfile(double profile) {
        this.profile = profile;
    }

    public void wholeDepositandWithdraw(double profile,int time){ //时间以年为单位
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
