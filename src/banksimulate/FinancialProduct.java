package banksimulate;

public class FinancialProduct {
    private String name;
    private double annualYield;

    public FinancialProduct(String name, double annualYield) {
        this.name = name;
        this.annualYield = annualYield;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualYield() {
        return annualYield;
    }

    public void setAnnualYield(double annualYield) {
        this.annualYield = annualYield;
    }
}
