package rejestr;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pracownik {
    private final String identyfikator;
    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    private final int doswiadczenie;
    private final AdresBudynku adresBudynku;

    public Pracownik(String identyfikator, String imie, String nazwisko, LocalDate dataUrodzenia, int doswiadczenie, AdresBudynku adresBudynku) {
        this.identyfikator = identyfikator;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.doswiadczenie = doswiadczenie;
        this.adresBudynku = adresBudynku;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public int getWiek() {
        return Period.between(dataUrodzenia, LocalDate.now()).getYears();
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

    public AdresBudynku getAdresBudynku() {
        return adresBudynku;
    }

    public abstract double obliczWartosc();
}
