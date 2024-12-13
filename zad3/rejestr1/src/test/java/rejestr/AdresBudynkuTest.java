package rejestr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AdresBudynkuTest {

    private AdresBudynku adres;

    @BeforeEach
    public void setUp() {
        adres = new AdresBudynku("Ulica Testowa", "10", "15", "Warszawa");
    }

    @Test
    public void testGetUlica() {
        String expectedUlica = "Ulica Testowa";
        assertEquals(expectedUlica, adres.getUlica(), "Ulica powinna być równa Ulica Testowa");
    }

    @Test
    public void testGetNumerBudynek() {
        String expectedNumerBudynek = "10";
        assertEquals(expectedNumerBudynek, adres.getNumerBudynek(), "Numer budynku powinien być równy 10");
    }

    @Test
    public void testGetNumerLokalu() {
        String expectedNumerLokalu = "15";
        assertEquals(expectedNumerLokalu, adres.getNumerLokalu(), "Numer lokalu powinien być równy 15");
    }

    @Test
    public void testGetPelnyAdres() {
        String pelnyAdres = adres.getPelnyAdres();
        assertEquals("Ulica Testowa 10/15, Warszawa", pelnyAdres);
    }

    @Test
    public void testGetMiasto() {
        assertEquals("Warszawa", adres.getMiasto());
    }
}
