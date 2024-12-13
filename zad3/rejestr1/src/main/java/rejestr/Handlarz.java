package rejestr;

import java.time.LocalDate;

public class Handlarz extends Pracownik {
    private final String skutecznosc;
    private final double wysokoscProwizji;

    public Handlarz(String identyfikator, String imie, String nazwisko, LocalDate dataUrodzenia, int doswiadczenie, AdresBudynku adresBudynku, String skutecznosc, double wysokoscProwizji) {
        super(identyfikator, imie, nazwisko, dataUrodzenia, doswiadczenie, adresBudynku);
        this.skutecznosc = skutecznosc;
        this.wysokoscProwizji = wysokoscProwizji;
    }

    public String getSkutecznosc() {
        return skutecznosc;
    }

    public double getWysokoscProwizji() {
        return wysokoscProwizji;
    }

    @Override
    public double obliczWartosc() {
        int mnoznik;
        switch (skutecznosc) {
            case "NISKA":
                mnoznik = 60;
                break;
            case "ŚREDNIA":
                mnoznik = 90;
                break;
            case "WYSOKA":
                mnoznik = 120;
                break;
            default:
                mnoznik = 0;
                break;
        }
        return getDoswiadczenie() * mnoznik;
    }
}
