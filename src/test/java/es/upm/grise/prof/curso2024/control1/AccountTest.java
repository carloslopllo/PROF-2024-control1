package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void test_getCurrentBalance() {
        Account a = mock(Account.class);
        when(a.getCurrentBalance()).thenReturn((float) 10);

        float balanceExpected = 10;

        assertEquals(balanceExpected, a.getCurrentBalance());
    }

    @Test
    public void test_pregunta3() {
        Account a1 = mock(Account.class);
        Account a2 = mock(Account.class);
        Customer c = new Customer();

        c.addAccount(a1);
        c.addAccount(a2);

        when(a1.getCurrentBalance()).thenReturn((float) 1);
        when(a2.getCurrentBalance()).thenReturn((float) 2);

        String selectedAccount = "";
        try {
            selectedAccount = c.getAccountWithHighestBalance();
        } catch (NoAccountsException e) {
            e.printStackTrace();
        }

        assertEquals(selectedAccount, a2.getAccountNumber());
    }
}
