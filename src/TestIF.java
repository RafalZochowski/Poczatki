public class TestIF {
    public static void main(String[] args) {
        int zmienna=5;

        if (zmienna%2==0){
            System.out.println("Liczba parzysta");
        }else {
            System.out.println("liczba nieparzysta");
        }

        if (zmienna>10){
            System.out.println("Liczba większa od 10");
        } else  if (zmienna>0 && zmienna<=10){
            System.out.println("liczba dodatnia mniejsza lub rowna 10");
        } else {
            System.out.println("Liczba ujemna");
        }
    }

    public TestIF() {

    }

}
