package banksimulate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MakeLoanTest {

    @Before
    public void setUp() throws Exception {
       loan();

    }

    @After
    public void tearDown() throws Exception {
        assertEquals(1,1);
    }

    @Test
    public void loan() {
        double invest = 10000;
    }

    @Test
    public void getMonthIncome() {

    }
}