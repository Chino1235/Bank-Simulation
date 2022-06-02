package banksimulate;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static banksimulate.SqlOptions.*;
import static org.junit.Assert.*;

public class SqlOptionsTest {

    @Test
    public void executeSqlTest() throws SQLException, ClassNotFoundException {
        executeSql("insert into bank.client(name,account,password) value ('test','testacc',987654);");
        ResultSet resultSet = queryClient("account","test");
        assertNotNull(resultSet);

        executeSql("update bank.client set profile=100.00 where name='test';");
        double expectedProfile = 100;
        double actualProfile = queryProfile("testacc");
        assertEquals(expectedProfile,actualProfile,0);

        executeSql("DELETE FROM bank.client where name = 'test';");
        boolean exist = accountExist("testacc");
        assertFalse(exist);
    }

    @Test
    public void queryProfileTest() throws SQLException, ClassNotFoundException {
        String account = "6127200219568426559";
        double expectedProfile = 29900.12;
        double actualProfile = queryProfile(account);
        assertEquals(expectedProfile,actualProfile,0);
    }

    @Test
    public void queryPasswordTest() throws SQLException, ClassNotFoundException {
        String account = "testAccount";
        String expectedPass = "testpas";
        String actualPass = queryPassword(account);
        assertEquals(expectedPass,actualPass);
    }

    @Test
    public void queryNameTest() throws SQLException, ClassNotFoundException {
        String account = "testAccount";
        String expectedName = "test_name1";
        String actualName = queryName(account);
        assertEquals(expectedName,actualName);
    }

    @Test
    public void accountExistTest() throws SQLException, ClassNotFoundException {
        String account = "testAccount";
        boolean exist = accountExist(account);
        assertTrue(exist);
        String account1 = "jsanxauasw";
        boolean exist1 = accountExist(account1);
        assertFalse(exist1);

    }

    @Test
    public void queryClientLogTest() throws SQLException, ClassNotFoundException {
        String account = "testAccount1";
        ResultSet resultSet =queryClientLog(account);
        assertNotNull(resultSet);
    }

    @Test
    public void queryAllLogTest() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = queryAllLog();
        assertNotNull(resultSet);
    }

    @Test
    public void queryFinancialProdTest() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = queryFinancialProd("name","test");
        assertNotNull(resultSet);
    }

    @Test
    public void queryClientTest() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = queryClient("name","李四");
        assertNotNull(resultSet);
        ResultSet resultSet1 = queryClient("name","王五");
        assertNotNull(resultSet1);
    }
}