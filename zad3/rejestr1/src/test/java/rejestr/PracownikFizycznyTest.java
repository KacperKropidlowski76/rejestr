package rejestr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracownikFizycznyTest {

    private PracownikFizyczny pracownikFizyczny;
    private AdresBudynku adresBudynku;

    @BeforeEach
    public void setUp() {
        adresBudynku = new AdresBudynku("Ulica Fizyczna", "30", "2", "Gdańsk");
        pracownikFizyczny = new PracownikFizyczny("ID003", "Jan", "Nowak", LocalDate.of(1992, 8, 21), 10, adresBudynku, 100);
    }

    @Test
    public void testGetSilaFizyczna() {
        assertEquals(100, pracownikFizyczny.getSilaFizyczna(), "Siła fizyczna powinna wynosić 100");
    }

    @Test
    public void testObliczWartosc() {
        assertEquals(31.25, pracownikFizyczny.obliczWartosc(), 0.01); //Doswiadczenie * silaFizyczna / Wiek
    }
}
