package rejestr;

public class AdresBudynku {
    private final String ulica;
    private final String numerBudynek;
    private final String numerLokalu;
    private final String miasto;

    public AdresBudynku(String ulica, String numerBudynek, String numerLokalu, String miasto) {
        this.ulica = ulica;
        this.numerBudynek = numerBudynek;
        this.numerLokalu = numerLokalu;
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNumerBudynek() {
        return numerBudynek;
    }

    public String getNumerLokalu() {
        return numerLokalu;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getPelnyAdres() {
        return ulica + " " + numerBudynek + "/" + numerLokalu + ", " + miasto;
    }
}

