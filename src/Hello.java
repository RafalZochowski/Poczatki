import java.util.Scanner;

public class Hello {
    String cos;

    public Hello(String cos) {
        this.cos = cos;
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos;
    }

    @Override
    public String toString() {
        return "Przywitanie się " +
                "jak mam się przywitać ='" + cos + '\'' +
                '}';
    }
}
