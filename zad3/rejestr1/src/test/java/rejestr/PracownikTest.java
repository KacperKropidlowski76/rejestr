package rejestr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracownikTest {

    private Pracownik pracownik;
    private AdresBudynku adresBudynku;

    @BeforeEach
    public void setUp() {
        adresBudynku = new AdresBudynku("Ulica Testowa", "12", "5", "Kraków");
        pracownik = new Pracownik("ID001", "Marek", "Kowalski", LocalDate.of(1990, 8, 21), 5, adresBudynku) {
            @Override
            public double obliczWartosc() {
                return 0;
            }
        };
    }

    @Test
    public void testGetImie() {
        // Testujemy metodę getImie()
        assertEquals("Marek", pracownik.getImie(), "Imię powinno wynosić 'Marek'");
    }

    @Test
    public void testGetNazwisko() {
        assertEquals("Kowalski", pracownik.getNazwisko(), "Nazwisko powinno być równe Kowalski");
    }

    @Test
    public void testGetDataUrodzenia() {
        LocalDate expectedDataUrodzenia = LocalDate.of(1990, 8, 21);
        assertEquals(expectedDataUrodzenia, pracownik.getDataUrodzenia(), "Data urodzenia powinna być równa 1990-01-01");
    }

    @Test
    public void testGetWiek() {
        assertEquals(34, pracownik.getWiek());
    }

    @Test
    public void testGetIdentyfikator() {
        assertEquals("ID001", pracownik.getIdentyfikator(), "Identyfikator powinien wynosić 'ID001'");
    }

    @Test
    public void testGetDoswiadczenie() {
        // Testujemy metodę getDoswiadczenie()
        assertEquals(5, pracownik.getDoswiadczenie(), "Doświadczenie powinno wynosić 5");
    }

    @Test
    public void testGetAdresBudynku() {
        assertEquals(adresBudynku, pracownik.getAdresBudynku(), "Adres budynku powinien wynosić 'Ulica Testowa 12/5 Kraków'");
    }
}
