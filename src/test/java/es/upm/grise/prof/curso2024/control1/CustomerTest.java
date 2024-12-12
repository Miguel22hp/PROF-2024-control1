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
    
}
