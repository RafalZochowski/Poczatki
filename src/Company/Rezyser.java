package Company;

public class Rezyser extends Staff{
    boolean reage;

    public boolean isReage() {
        return reage;
    }

    public void setReage(boolean reage) {
        reage = reage;
    }

    public boolean Wscieklosc(){
        return reage;
    }

    public Rezyser(String imie, String nazwisko, double wynagrodzenie, boolean reage) {
        super(imie, nazwisko, wynagrodzenie);
        this.reage = reage;
    }

    @Override
    public String toString() {
        return "Rezyser{" +
                "reage=" + reage +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wynagrodzenie=" + wynagrodzenie +
                '}';
    }
}
