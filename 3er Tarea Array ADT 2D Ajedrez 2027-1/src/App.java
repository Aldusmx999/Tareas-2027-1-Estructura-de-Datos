import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
     // Cambiar la consola de Windows a UTF-8 automáticamente
        try {
            new ProcessBuilder("cmd", "/c", "chcp 65001").inheritIO().start().waitFor();
        } catch (Exception ignored) {}

        // Redirigir System.out a UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("=== TABLERO DE AJEDREZ (Array2DADT) ===\n");

        TableroAjedrez juego = new TableroAjedrez();
        juego.mostrar();
    }
}


