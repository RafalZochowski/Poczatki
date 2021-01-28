package Company;

import java.time.LocalDate;
import java.util.*;

public class BazaFilmow {

        static List<Film> listaFilmow = new ArrayList<>();
        static List<Aktor> listaAktorrów = new ArrayList<>();
        static List<Rezyser> listaRezyserow = new ArrayList<>();

        static void selctMenu(){
            boolean licznik = true;

            while (licznik){
                wyswietlMenu();
                Scanner scanner= new Scanner(System.in);

                String selectMenu= scanner.nextLine();

                switch (selectMenu){
                    case "1":
                        dodajFilm();
                        break;
                    case "2":
                        znajdzFilmmPoNazwie();
                        break;
                    case "3":
                        znajdzFilmmWDatach();
                        break;
                    case "4":
                        znajdzFilmyZAktrorami();
                        break;
                    case "5":
                        pokazCeneProdukcjiFilmu();
                        break;
                    case "6":
                        dodajAktora();
                        break;
                    case "7":
                        dodajRezysera();
                        break;
                    case "0":
                        licznik=false;
                        break;
                    default:
                        licznik=false;
                }
            }



    }

    private static void dodajFilm(){
            Scanner scanner1= new Scanner(System.in);
            Scanner scanner2= new Scanner(System.in);

        System.out.println("Podaj tytuł : ");
        String tytul=scanner1.nextLine();
        System.out.println("Podaj nazwisko rezysera : ");
        String nazwiskoRezysera = scanner1.nextLine();

        Rezyser rezyser= null;
        for (Rezyser rezyserZlisty: listaRezyserow){
            if (rezyserZlisty.getNazwisko().equals(nazwiskoRezysera)){
                rezyser= rezyserZlisty;
            }
        }
        System.out.println("Podaj dzień premiery : ");
        int dzien = scanner2.nextInt();

        System.out.println("Podaj miesiąc premiery: ");
        int miesiac = scanner2.nextInt();

        System.out.println("Podaj rok premiery: ");
        int rok = scanner2.nextInt();


        System.out.println("Podaj iliść aktorów: ");
        int iloscAktorow = scanner2.nextInt();
        List<Aktor> listaAktorowZFilu= new ArrayList<>();

        for (int i=0; i<iloscAktorow;i++){
            System.out.println("Podaj nazwisko Aktora:");
            Scanner scanner3=new Scanner(System.in);
            String nazwiskoAktora = scanner3.nextLine();

            for(Aktor aktor:listaAktorrów){
                if (aktor.getNazwisko().equals(nazwiskoAktora)){
                    listaAktorowZFilu.add(aktor);

                }
            }
        }

        System.out.println("Podaj typ filmu : horror \n" +
                "    romantyczny\n" +
                "    akcja ");

        String typFilmu = scanner1.nextLine();
        MovieType movieType;
        switch (typFilmu) {
            case "horror":
                movieType = MovieType.horror;
                break;
            case "romantyczny":
                movieType=MovieType.romantyczny;
                break;
            case "akcja":
                movieType=MovieType.akcja;
                break;
            default:
                movieType=null;
        }

        Film film = new Film(tytul,rezyser,LocalDate.of(rok,miesiac,dzien),listaAktorowZFilu,movieType);
        listaFilmow.add(film);
    }

    private static void pokazCeneProdukcjiFilmu(){
        System.out.println("Podaj nazwę filmu: ");
        Scanner scanner3 = new Scanner(System.in);

        String tytulFilmu = scanner3.nextLine();

        for (Film film: listaFilmow){
            if (tytulFilmu.equals(film.getTytul())){
                double koszt = film.getRezyser().getWynagrodzenie();
                for (Aktor aktor: film.getAktorzy()){
                    koszt += aktor.getWynagrodzenie();
                }
                System.out.println(koszt);
            }
        }
    }

    private static void wyswietlMenu(){
        System.out.println("Wybierz z menu: \n" +
                "1. Dodaj film \n" +
                "2. Szukaj filmu po nazwie \n" +
                "3. Wypisz film z zakresu dat \n" +
                "4. Spr w jakich filmach grał dany aktor \n" +
                "5. Ile kosztowało wyprodukowanie danego filmu \n" +
                "6. Dodaj aktora: \n" +
                "7. Dodaj rezysera: \n" +
                "0. Wyjście");
    }

    static void przygotowanieDanych(){
            Rezyser stivenSpilberg = new Rezyser("Stiven", "Spilberg",1000,false);
            Rezyser jamesCameron = new Rezyser("James","Cameron", 1200,true);

            Aktor tomHanks = new Aktor("Tom", "Hanks",500,Sex.mężczyzna);
            Aktor juliaRoberts = new Aktor("Julia","Roberts",300,Sex.kobieta);
            Aktor tomCruise = new Aktor("Tom", "Cruise",700,Sex.mężczyzna);
            Aktor sylwesterStalone = new Aktor("Sylwester","Stalone",450,Sex.mężczyzna);
            Aktor nicoleKidman = new Aktor("Nicole", "Kidman", 600, Sex.kobieta);


            Film titanic = new Film("Titanik",jamesCameron,LocalDate.of(2020,12,1),
                    Arrays.asList(juliaRoberts,tomHanks,sylwesterStalone),MovieType.romantyczny);
            Film rambo = new Film("Rambo",stivenSpilberg,LocalDate.of(2021,1,23),
                    Arrays.asList(tomCruise,nicoleKidman),MovieType.akcja);
            Film maniak = new Film("Maniak", jamesCameron,LocalDate.of(2025,3,12),
                    Arrays.asList(tomHanks,tomCruise,juliaRoberts,sylwesterStalone,nicoleKidman),MovieType.horror);


            listaFilmow.add(titanic);
            listaFilmow.add(rambo);
            listaFilmow.add(maniak);

            listaAktorrów.add(tomCruise);
            listaAktorrów.add(tomHanks);
            listaAktorrów.add(juliaRoberts);
            listaAktorrów.add(sylwesterStalone);
            listaAktorrów.add(nicoleKidman);

            listaRezyserow.add(jamesCameron);
            listaRezyserow.add(stivenSpilberg);
    }

    private static void znajdzFilmyZAktrorami(){
        System.out.println("Podaj nazwisko aktora: ");
        Scanner scanner2 = new Scanner(System.in);
        String nazwiskoAktora = scanner2.nextLine();

        for (Film film: listaFilmow){
            for (Aktor aktor: film.getAktorzy()){
                if (aktor.getNazwisko().equals(nazwiskoAktora)){
                    System.out.println(film.getTytul());
                }
            }
    }}


    private static void znajdzFilmmPoNazwie(){
        System.out.println("Podaj nazwę filmu: ");
        Scanner scanner1 = new Scanner(System.in);

        String nazwaFilmu = scanner1.nextLine();
        for (Film film: listaFilmow){
            if(nazwaFilmu.equals(film.getTytul())){
                System.out.println(film.toString());
            }
        }
    }

    private static void znajdzFilmmWDatach(){
        System.out.println("Podaj zakres dat w których chcesz szukać rok: ");
        Scanner scanner1 = new Scanner(System.in);
        int rokin = scanner1.nextInt();
        System.out.println("miesiac: ");
        int miesiacin = scanner1.nextInt();
        System.out.println("dzien: ");
        int dzienin = scanner1.nextInt();
        LocalDate Od = LocalDate.of(rokin,miesiacin,dzienin);

        System.out.println("Podar rok do ");
        int rokdo = scanner1.nextInt();
        System.out.println("miesiac: ");
        int miesiacdo = scanner1.nextInt();
        System.out.println("dzien: ");
        int dziendo = scanner1.nextInt();
        LocalDate Do = LocalDate.of(rokdo,miesiacdo,dziendo);


        for (Film film: listaFilmow){
            if (Od.isBefore(film.getDataPremiery())){
            if(Do.isAfter(film.getDataPremiery())) {
                System.out.println(film.toString());
            }}
        }
    }

    private static void dodajAktora(){
        System.out.println("Podaj imię : ");
        Scanner scanner = new Scanner(System.in);
        String imie1= scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String nazwisko1= scanner.nextLine();
        System.out.println("Podaj wynagrodzenie: ");
        Scanner scanner1= new Scanner(System.in);
        int wynagrodzenie = scanner1.nextInt();


        System.out.println("Podaj pleć z  \n" +
                "    mężczyzna,\n" +
                "    kobieta,\n");

        String plec = scanner.nextLine();
        Sex plecAktora;
        switch (plec) {
            case "mężczyzna":
                plecAktora = Sex.mężczyzna;
                break;
            case "kobieta":
                plecAktora=Sex.kobieta;
                break;
            default:
                plecAktora=null;
        }

        Aktor aktor = new Aktor(imie1,nazwisko1,wynagrodzenie,plecAktora);
        listaAktorrów.add(aktor);
    }

    private static void dodajRezysera(){
        System.out.println("Podaj imię : ");
        Scanner scanner = new Scanner(System.in);
        String imie1= scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String nazwisko1= scanner.nextLine();
        System.out.println("Podaj wynagrodzenie: ");
        Scanner scanner1= new Scanner(System.in);
        double wynagrodzenie = scanner1.nextInt();


        System.out.println("Podaj Rage z  \n" +
                "Tak,\n" +
                "Nie");
        String wsieklosc = scanner.nextLine();

        Boolean reage1=false;
        switch (wsieklosc) {
            case "Tak":
                reage1 = true;
                break;
            case "Nie":
                reage1 = false;
                break;
        }

        Rezyser rezyser1 = new Rezyser(imie1,nazwisko1,wynagrodzenie,reage1);
        listaRezyserow.add(rezyser1);
    }


}
