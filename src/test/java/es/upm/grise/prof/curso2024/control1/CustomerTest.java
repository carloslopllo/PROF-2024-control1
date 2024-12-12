package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void test_getAccountWithHighestBalance() {
        Customer c = new Customer();
        assertThrows(NoAccountsException.class, () -> {
            c.getAccountWithHighestBalance();
        });
    }

    @Test
    public void test_getCurrentBalance() {
        Account a1 = new Account("a1",1);
        Account a2 = new Account("a2",2);
        Customer c = new Customer();

        c.addAccount(a1);
        c.addAccount(a2);

        String selectedAccount = "";
        try {
            selectedAccount = c.getAccountWithHighestBalance();
        } catch (NoAccountsException e) {
            e.printStackTrace();
        }

        assertEquals(selectedAccount, a2.getAccountNumber());
    }
}
