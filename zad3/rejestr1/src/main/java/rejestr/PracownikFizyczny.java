package rejestr;

import java.time.LocalDate;

public class PracownikFizyczny extends Pracownik {
    private final int silaFizyczna;

    public PracownikFizyczny(String identyfikator, String imie, String nazwisko, LocalDate dataUrodzenia, int doswiadczenie, AdresBudynku adresBudynku, int silaFizyczna) {
        super(identyfikator, imie, nazwisko, dataUrodzenia, doswiadczenie, adresBudynku);
        this.silaFizyczna = silaFizyczna;
    }

    public int getSilaFizyczna() {
        return silaFizyczna;
    }

    @Override
    public double obliczWartosc() {
        return (double) getDoswiadczenie() * silaFizyczna / getWiek();
    }
}
