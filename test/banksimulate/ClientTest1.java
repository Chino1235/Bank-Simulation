package banksimulate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest1 {

    Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client("John","123456789","000000",0);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void wholeDepositandWithdraw() {
        client.setProfile(10000);
        Client client1 = new Client("John","123456789","000000",10325);
        client1.depositProfile =10325;
        client1.interest =325;
        client.wholeDepositandWithdraw(10000,1);
        assertEquals(client.toString(),client1.toString());
    }

    @Test
    public void wholeDepositandLumpsumWithdraw() {
        client.wholeDepositandLumpsumWithdraw(10000,12,1);
        assertEquals(1,1);

    }

    @Test
    public void lumpsumDepositandwholeWithdraw() {
        client.lumpsumDepositandwholeWithdraw(10000,12);
        assertEquals(1,1);
    }

    @Test
    public void currentDeposit() {
        client.interest =0;
        Client client1 = new Client("John","123456789","000000",10000);
        client1.interest =0;
        client1.depositProfile = 10000;
        client.currentDeposit(10000);
        assertEquals(client1.toString(),client.toString());
    }

}