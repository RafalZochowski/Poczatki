package Company;

import java.time.LocalDate;
import java.util.List;

public class Film {
    String tytul;
    Rezyser rezyser;
    LocalDate dataPremiery;
    List<Aktor> aktorzy;
    MovieType movieType;

    public Film(String tytul, Rezyser rezyser, LocalDate dataPremiery, List<Aktor> aktorzy, MovieType movieType) {
        this.tytul = tytul;
        this.rezyser = rezyser;
        this.dataPremiery = dataPremiery;
        this.aktorzy = aktorzy;
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytul='" + tytul + '\'' +
                ", rezyser=" + rezyser +
                ", dataPremiery=" + dataPremiery +
                ", aktorzy=" + aktorzy +
                ", movieType=" + movieType +
                '}';
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setRezyser(Rezyser rezyser) {
        this.rezyser = rezyser;
    }

    public void setDataPremiery(LocalDate dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    public void setAktorzy(List<Aktor> aktorzy) {
        this.aktorzy = aktorzy;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getTytul() {
        return tytul;
    }

    public Rezyser getRezyser() {
        return rezyser;
    }

    public LocalDate getDataPremiery() {
        return dataPremiery;
    }

    public List<Aktor> getAktorzy() {
        return aktorzy;
    }

    public MovieType getMovieType() {
        return movieType;
    }
}
