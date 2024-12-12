package es.upm.grise.prof.curso2024.control1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class AccountTest {
    
    Account account;
    Transaction t1;

    @BeforeEach
    public void setUp() {
        this.account = new Account();
        this.t1 = mock(Transaction.class);
        account.addTransaction(t1);
        account.setInitialAmount(100.0f);
    }

    @Test
    public void testGetCurrentBalance() {
        when(t1.getAmount()).thenReturn(100.0f);
        float expectedResult = 200.0f;
        assertEquals(expectedResult, account.getCurrentBalance(), "El saldo actual no se calculó correctamente");
    }
}
