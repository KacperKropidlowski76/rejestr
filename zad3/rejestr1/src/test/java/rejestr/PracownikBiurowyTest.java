package rejestr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracownikBiurowyTest {

    private AdresBudynku adresBudynku;
    private PracownikBiurowy pracownikBiurowy;

    @BeforeEach
    public void setUp() {
        adresBudynku = new AdresBudynku("Ulica Biurowa", "10", "15", "Warszawa");
        pracownikBiurowy = new PracownikBiurowy("ID002", "Anna", "Kowalska", LocalDate.of(1989, 8, 21), 6, adresBudynku, 120, "Stanowisko Biurowe");
    }

    @Test
    public void testGetIntelekt() {
        assertEquals(120, pracownikBiurowy.getIntelekt(), "Intelekt powinien wynosić 120");
    }

    @Test
    public void testObliczWartosc() {
        assertEquals(720.0, pracownikBiurowy.obliczWartosc());
    }

    @Test
    public void testGetStanowisko() {
        assertEquals("Stanowisko Biurowe", pracownikBiurowy.getStanowisko(), "Stanowisko powinno być równe 'Stanowisko Biurowe'.");
    }
}
