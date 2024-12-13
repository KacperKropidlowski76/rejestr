package rejestr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandlarzTest {

    private Handlarz handlarzNiska;
    private Handlarz handlarzBrakSkutecznosci;
    private Handlarz handlarz;

    @BeforeEach
    public void setUp() {
        AdresBudynku adres = new AdresBudynku("Ulica Handlowa", "5", "3", "Warszawa");
        handlarz = new Handlarz("H001", "Anna", "Nowak", LocalDate.of(1989, 8, 21), 10, adres, "WYSOKA", 5000);
        handlarzNiska = new Handlarz("H002", "Kuba", "Miska", LocalDate.of(1921, 8, 21), 10, adres, "NISKA", 5000);
        handlarzBrakSkutecznosci = new Handlarz("H003", "Jan", "Kowalski", LocalDate.of(1939, 8, 21), 12, adres, "BRAK", 7000);
    }

    @Test
    public void testGetSkutecznosc() {
        assertEquals("WYSOKA", handlarz.getSkutecznosc(), "Skuteczność powinna być równa WYSOKA");
    }

    @Test
    public void testGetWysokoscProwizji() {
        assertEquals(5000, handlarz.getWysokoscProwizji(), "Wysokość prowizji powinna wynosić 5000");
    }

    @Test
    public void testObliczWartosc() {
        assertEquals(1200.0, handlarz.obliczWartosc());
    }

    @Test
    public void testObliczWartoscSkutecznoscSrednia() {
        AdresBudynku adres = new AdresBudynku("Ulica Handlowa", "10", "2B", "Miasto");
        Handlarz handlarz = new Handlarz("003", "Ewa", "Nowak", LocalDate.of(1990, 5, 10), 8, adres, "ŚREDNIA", 800.0);
        assertEquals(720.0, handlarz.obliczWartosc());
    }

    @Test
    public void testObliczWartoscSkutecznoscNISKA() {
        double expectedWartosc = 10 * 60;
        assertEquals(expectedWartosc, handlarzNiska.obliczWartosc(), "Obliczona wartość powinna wynosić 600");
    }

    @Test
    public void testObliczWartoscDefault() {
        double expectedWartosc = 12 * 0;
        assertEquals(expectedWartosc, handlarzBrakSkutecznosci.obliczWartosc(), "Obliczona wartość powinna wynosić 0");
    }
}
