package Company;

public abstract class Staff {
    String imie;
    String nazwisko;
    double wynagrodzenie;

    public Staff(String imie, String nazwisko, double wynagrodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wynagrodzenie = wynagrodzenie;
    }

    public abstract  String toString();

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
