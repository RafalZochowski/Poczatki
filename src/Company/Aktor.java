package Company;

public class Aktor extends Staff{
    Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Aktor(String imie, String nazwisko, double wynagrodzenie, Sex sex) {
        super(imie, nazwisko, wynagrodzenie);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Aktor{" +
                "sex=" + sex +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wynagrodzenie=" + wynagrodzenie +
                '}';
    }
}
