public class App {
    public static void main(String[] args)  {
        String archivoCSV = "src/config_inicial.csv";
        JuegoDeLaVida juego = new JuegoDeLaVida(archivoCSV);

        System.out.println("=== GENERACIÓN 0 ===");
        juego.mostrarTablero();
        System.out.println();

        for (int gen = 1; gen <= 10; gen++) {
            juego.siguienteGeneracion();
            System.out.println("=== GENERACIÓN " + gen + " ===");
            juego.mostrarTablero();
            System.out.println();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

