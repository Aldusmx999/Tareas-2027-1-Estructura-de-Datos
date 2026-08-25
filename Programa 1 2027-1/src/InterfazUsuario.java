import java.util.Scanner;

public class InterfazUsuario {

    public static void mostrarMenu(String archivo) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n==================================================");
            System.out.println("      MENÚ DE ANÁLISIS DE REDES SOCIALES         ");
            System.out.println("==================================================");
            System.out.println("1. Diferencia de seguidores en Twitter (Enero - Junio)");
            System.out.println("2. Diferencia de visualizaciones en YouTube (por teclado)");
            System.out.println("3. Promedio de crecimiento (Enero - Junio) Facebook y Twitter");
            System.out.println("4. Promedio anual de 'Me gusta' (YouTube, Twitter, Facebook)");
            System.out.println("5. Mostrar reporte completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer
            } else {
                teclado.nextLine();
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    double diffTw = CalculadoraEstadisticas.calcularDiferenciaMeses(
                        archivo, "TWITTER", "SEGUIDORES (FOLLOWERS)", "enero", "junio"
                    );
                    System.out.println("\n-> Diferencia de seguidores en Twitter (Enero vs Junio): " + (long) diffTw);
                    break;

                case 2:
                    System.out.print("\nIngrese el primer mes (ej. enero): ");
                    String mes1 = teclado.nextLine();
                    System.out.print("Ingrese el segundo mes (ej. junio): ");
                    String mes2 = teclado.nextLine();

                    double diffYt = CalculadoraEstadisticas.calcularDiferenciaMeses(
                        archivo, "YOUTUBE", "VISUALIZACIONES", mes1, mes2
                    );
                    System.out.println("-> Diferencia de visualizaciones en YouTube (" + mes1 + " vs " + mes2 + "): " + (long) diffYt);
                    break;

                case 3:
                    double promFbCrec = CalculadoraEstadisticas.calcularPromedioCrecimientoEneroAJunio(
                        archivo, "FACEBOOK", "CRECIMIENTO (seguidores)"
                    );
                    double promTwCrec = CalculadoraEstadisticas.calcularPromedioCrecimientoEneroAJunio(
                        archivo, "TWITTER", "CRECIMIENTO DE FOLLOWERS"
                    );
                    System.out.printf("\n-> Promedio Crecimiento Facebook (Ene-Jun): %.2f\n", promFbCrec);
                    System.out.printf("-> Promedio Crecimiento Twitter (Ene-Jun):  %.2f\n", promTwCrec);
                    break;

                case 4:
                    double promFbLikes = CalculadoraEstadisticas.calcularPromedioMeGustaAnual(
                        archivo, "FACEBOOK", "ME GUSTA EN PUBLICACIONES"
                    );
                    double promTwLikes = CalculadoraEstadisticas.calcularPromedioMeGustaAnual(
                        archivo, "TWITTER", "ME GUSTA"
                    );
                    double promYtLikes = CalculadoraEstadisticas.calcularPromedioMeGustaAnual(
                        archivo, "YOUTUBE", "ME GUSTA"
                    );
                    System.out.printf("\n-> Promedio anual 'Me gusta' Facebook: %.2f\n", promFbLikes);
                    System.out.printf("-> Promedio anual 'Me gusta' Twitter:  %.2f\n", promTwLikes);
                    System.out.printf("-> Promedio anual 'Me gusta' YouTube:  %.2f\n", promYtLikes);
                    break;

                case 5:
                    ejecutarReporteCompleto(archivo, teclado);
                    break;

                case 6:
                    System.out.println("\n has salido del programa");
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);

        teclado.close();
    }

    private static void ejecutarReporteCompleto(String archivo, Scanner teclado) {
        System.out.println("\n--- REPORTE COMPLETO ---");
        System.out.println("1. Twitter seguidores (Enero - Junio): " + (long) CalculadoraEstadisticas.calcularDiferenciaMeses(
            archivo, "TWITTER", "SEGUIDORES (FOLLOWERS)", "enero", "junio"
        ));

        System.out.print("2. Ingrese el primer mes para YouTube: ");
        String m1 = teclado.nextLine();
        System.out.print("   Ingrese el segundo mes para YouTube: ");
        String m2 = teclado.nextLine();
        System.out.println("   -> Diferencia YouTube (" + m1 + " vs " + m2 + "): " + (long) CalculadoraEstadisticas.calcularDiferenciaMeses(
            archivo, "YOUTUBE", "VISUALIZACIONES", m1, m2
        ));

        System.out.printf("3. Promedio Crecimiento FB (Ene-Jun): %.2f | TW: %.2f\n", 
            CalculadoraEstadisticas.calcularPromedioCrecimientoEneroAJunio(archivo, "FACEBOOK", "CRECIMIENTO (seguidores)"),
            CalculadoraEstadisticas.calcularPromedioCrecimientoEneroAJunio(archivo, "TWITTER", "CRECIMIENTO DE FOLLOWERS")
        );

        System.out.printf("4. Promedios 'Me gusta' Anuales -> FB: %.2f | TW: %.2f | YT: %.2f\n",
            CalculadoraEstadisticas.calcularPromedioMeGustaAnual(archivo, "FACEBOOK", "ME GUSTA EN PUBLICACIONES"),
            CalculadoraEstadisticas.calcularPromedioMeGustaAnual(archivo, "TWITTER", "ME GUSTA"),
            CalculadoraEstadisticas.calcularPromedioMeGustaAnual(archivo, "YOUTUBE", "ME GUSTA")
        );
    }
}
