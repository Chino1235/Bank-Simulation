package banksimulate;

public class DepositType {
    private int profile;
    private int type;
    private int time;
    private String depositTime;
    private String endTime;
    private String startInterestTime;
    private double totalInterest;

    public DepositType(int profile, int type, int time, String depositTime, String endTime, String startInterestTime, double interest) {
        this.profile = profile;
        this.type = type;
        this.time = time;
        this.depositTime = depositTime;
        this.endTime = endTime;
        this.startInterestTime = startInterestTime;
        this.totalInterest = interest;
    }


    @Override
    public String toString() {
        return profile +
                "      " + type +
                "      " + time +
                "      " + depositTime +
                "      " + endTime +
                "      " + startInterestTime +
                "      " + totalInterest ;
    }
}
