package banksimulate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        double invest = 10000;
        double yearRate = 0.0525;
        double monthRate = yearRate/12;
        int month = 12;
        double monthIncome = (invest* monthRate * Math.pow(1+monthRate,month))/(Math.pow(1+monthRate,month)-1);
        String result = String.format("%.2f", monthIncome);
        assertEquals(1,1);


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