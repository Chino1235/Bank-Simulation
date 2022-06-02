package Manager;

import org.junit.Test;

import static Manager.Administrator.adminLogin;
import static Manager.Administrator.clientManager;
import static org.junit.Assert.*;

public class AdministratorTest {


    @Test
    public void menu() {
        menu();
        assertEquals(1,1);
    }

    @Test
    public void adminLoginTest() {
        String trueAcc = "root";
        String truePass = "root";
        boolean success = adminLogin(trueAcc,truePass);
        assertTrue(success);
        String falseAcc = "root1";
        String falsePass="root1";
        boolean false1 = adminLogin(falseAcc,falsePass);
        assertFalse(false1);
        boolean false2=adminLogin(trueAcc,falsePass);
        assertFalse(false2);
    }
}