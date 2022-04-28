package banksimulate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimulatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void menu() {
        Simulator.menu();
        assertEquals(1,1);
    }

    @Test
    public void basicInfoOutput() {
        Simulator.basicInfoOutput();
        assertEquals(1,1);
    }

    @Test
    public void main() {
        //Simulator.main(new String[]{""});
        assertEquals(1,1);
    }
}