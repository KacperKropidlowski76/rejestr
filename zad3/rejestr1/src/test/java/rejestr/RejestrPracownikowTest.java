package rejestr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RejestrPracownikowTest {

    private RejestrPracownikow rejestrPracownikow;
    private AdresBudynku adresBudynku1;
    private AdresBudynku adresBudynku2;
    private Pracownik pracownik1;
    private Pracownik pracownik2;


    @BeforeEach
    public void setUp() {
        adresBudynku1 = new AdresBudynku("Ulica Testowa", "10", "1", "Gdańsk");
        adresBudynku2 = new AdresBudynku("Ulica Przykładowa", "20", "2", "Warszawa");

        pracownik1 = new PracownikFizyczny("ID001", "Jan", "Kowalski", LocalDate.of(1921, 8, 21), 5, adresBudynku1, 90);
        pracownik2 = new PracownikFizyczny("ID002", "Anna", "Nowak", LocalDate.of(1951, 8, 21), 3, adresBudynku2, 80);

        rejestrPracownikow = new RejestrPracownikow();
        rejestrPracownikow.dodajPracownika(pracownik1);
        rejestrPracownikow.dodajPracownika(pracownik2);
    }

    @Test
    public void testUsunPracownika() {
        rejestrPracownikow.usunPracownika("ID001");

        List<Pracownik> pracownicy = rejestrPracownikow.sortujWedlugWieku();
        assertEquals(1, pracownicy.size(), "Powinien pozostać tylko jeden pracownik.");
        assertEquals("ID002", pracownicy.get(0).getIdentyfikator(), "Powinien pozostać tylko pracownik o identyfikatorze ID002.");
    }

    @Test
    public void testSortujWedlugDoswiadczenia() {
        List<Pracownik> pracownicy = rejestrPracownikow.sortujWedlugDoswiadczenia();

        assertEquals("ID001", pracownicy.get(0).getIdentyfikator(), "Pracownik z większym doświadczeniem powinien być na początku.");
        assertEquals("ID002", pracownicy.get(1).getIdentyfikator(), "Pracownik z mniejszym doświadczeniem powinien być na końcu.");
    }

    @Test
    public void testWyswietlZMiasta() {
        List<Pracownik> pracownicy = rejestrPracownikow.wyswietlZMiasta("Gdańsk");

        assertEquals(1, pracownicy.size(), "Powinien być tylko jeden pracownik z Gdańska.");
        assertEquals("Gdańsk", pracownicy.get(0).getAdresBudynku().getMiasto(), "Pracownik powinien pochodzić z Gdańska.");
    }

    @Test
    public void testDodajPracownika() {
        RejestrPracownikow rejestr = new RejestrPracownikow();
        AdresBudynku adres = new AdresBudynku("Ulica Pracownicza", "22", "5", "Miasto");
        Pracownik pracownik = new PracownikBiurowy("006", "Marek", "Kaczmarek", LocalDate.of(1995, 1, 1), 3, adres, 110, "Stanowisko Biurowe");
        rejestr.dodajPracownika(pracownik);
        assertEquals(1, rejestr.sortujWedlugWieku().size());
    }

    @Test
    public void testSortujWedlugWieku() {
        RejestrPracownikow rejestr = new RejestrPracownikow();

        rejestr.dodajPracownika(pracownik1);
        rejestr.dodajPracownika(pracownik2);

        List<Pracownik> sortedList = rejestr.sortujWedlugWieku();
        assertEquals("Anna", sortedList.get(0).getImie());  // Pracownik urodzony w 1990 roku
    }
}
