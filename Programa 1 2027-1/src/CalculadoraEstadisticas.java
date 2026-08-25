public class CalculadoraEstadisticas {

    public static double calcularDiferenciaMeses(String archivo, String red, String concepto, String mesInicio, String mesFin) {
        int idxInicio = LecturaArchivo.convertirMesAIndice(mesInicio);
        int idxFin = LecturaArchivo.convertirMesAIndice(mesFin);

        double valInicio = LecturaArchivo.extraerDato(archivo, red, concepto, idxInicio);
        double valFin = LecturaArchivo.extraerDato(archivo, red, concepto, idxFin);

        return valFin - valInicio;
    }

    public static double calcularPromedioCrecimientoEneroAJunio(String archivo, String red, String conceptoCrecimiento) {
        double suma = 0.0;
        for (int i = 0; i <= 5; i++) { // Enero (0) a Junio (5)
            suma += LecturaArchivo.extraerDato(archivo, red, conceptoCrecimiento, i);
        }
        return suma / 6.0;
    }

    public static double calcularPromedioMeGustaAnual(String archivo, String red, String conceptoMeGusta) {
        double suma = 0.0;
        for (int i = 0; i < 12; i++) {
            suma += LecturaArchivo.extraerDato(archivo, red, conceptoMeGusta, i);
        }
        return suma / 12.0;
    }
}
