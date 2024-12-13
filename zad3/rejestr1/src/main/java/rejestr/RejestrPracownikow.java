package rejestr;

import java.util.*;

public class RejestrPracownikow {
    private final List<Pracownik> pracownicy = new ArrayList<>();

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void usunPracownika(String identyfikator) {
        pracownicy.removeIf(p -> p.getIdentyfikator().equals(identyfikator));
    }

    public List<Pracownik> sortujWedlugWieku() {
        pracownicy.sort(Comparator.comparingInt(Pracownik::getWiek));
        return pracownicy;
    }

    public List<Pracownik> sortujWedlugDoswiadczenia() {
        pracownicy.sort(Comparator.comparingInt(Pracownik::getDoswiadczenie).reversed());
        return pracownicy;
    }

    public List<Pracownik> wyswietlZMiasta(String miasto) {
        List<Pracownik> wynik = new ArrayList<>();
        for (Pracownik p : pracownicy) {
            if (p.getAdresBudynku().getMiasto().equals(miasto)) {
                wynik.add(p);
            }
        }
        return wynik;
    }
}
