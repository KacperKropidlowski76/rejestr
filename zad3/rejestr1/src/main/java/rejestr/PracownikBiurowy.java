package rejestr;

import java.time.LocalDate;

public class PracownikBiurowy extends Pracownik {
    private final int intelekt;
    private final String stanowisko;  // Identyfikator stanowiska biurowego

    public PracownikBiurowy(String identyfikator, String imie, String nazwisko, LocalDate dataUrodzenia, int doswiadczenie, AdresBudynku adresBudynku, int intelekt, String stanowisko) {
        super(identyfikator, imie, nazwisko, dataUrodzenia, doswiadczenie, adresBudynku);
        this.intelekt = intelekt;
        this.stanowisko = stanowisko;  // Inicjalizacja identyfikatora stanowiska
    }

    public int getIntelekt() {
        return intelekt;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    @Override
    public double obliczWartosc() {
        return getDoswiadczenie() * intelekt;
    }
}
