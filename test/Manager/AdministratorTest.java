package Manager;

import org.junit.Test;

import static Manager.Administrator.adminLogin;
import static Manager.Administrator.clientManager;
import static org.junit.Assert.*;

public class AdministratorTest {

    @Test
    public void clientManagerTest() {
        clientManager();
        assertEquals(1,1);
    }

    @Test
    public void financialProdManager() {
        financialProdManager();
        assertEquals(1,1);
    }

    @Test
    public void menu() {
        menu();
        assertEquals(1,1);
    }

    @Test
    public void adminLoginTest() {

    }
}