package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp() {
        this.customer = new Customer();
    }

    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        
        
        assertThrows(NoAccountsException.class, () -> customer.getAccountWithHighestBalance(), "La excepción NoAccountsException no se lanzó cuando no había cuentas");
    }

    @Test
    public void testGetAccountWithHighestBalance() throws NoAccountsException {
        Account a1 = new Account();
        Account a2 = new Account();

        a1.setInitialAmount(100.0f);
        a2.setInitialAmount(200.0f);

        a1.setAccountNumber("1");
        a2.setAccountNumber("2");

        customer.addAccount(a1);
        customer.addAccount(a2);

        String expeString = "2";
        assertEquals(expeString, customer.getAccountWithHighestBalance(), "La cuenta con el saldo más alto no se devolvió correctamente");


    }
    
}