import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaArchivo {
    public static int convertirMesAIndice(String mes) {
        switch (mes.toLowerCase().trim()) {
            case "enero": return 0;
            case "febrero": return 1;
            case "marzo": return 2;
            case "abril": return 3;
            case "mayo": return 4;
            case "junio": return 5;
            case "julio": return 6;
            case "agosto": return 7;
            case "septiembre": return 8;
            case "octubre": return 9;
            case "noviembre": return 10;
            case "diciembre": return 11;
            default: return -1;
        }
    }

    public static double extraerDato(String rutaArchivo, String redSocial, String concepto, int indiceMes) {
        File archivo = new File(rutaArchivo);

        try (Scanner scannerArchivo = new Scanner(archivo)) {
            if (scannerArchivo.hasNextLine()) {
                scannerArchivo.nextLine(); // Saltar encabezado
            }

            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                Scanner scannerLinea = new Scanner(linea);
                scannerLinea.useDelimiter(",");

                if (scannerLinea.hasNext()) {
                    String red = scannerLinea.next().trim();
                    String con = scannerLinea.hasNext() ? scannerLinea.next().trim() : "";

                    if (red.equalsIgnoreCase(redSocial) && con.equalsIgnoreCase(concepto)) {
                        if (scannerLinea.hasNext()) {
                            scannerLinea.next(); // Saltar columna del año
                        }

                        int mesActual = 0;
                        while (scannerLinea.hasNext()) {
                            String valorStr = scannerLinea.next().trim().replace("\"", "").replace(",", "");
                            if (mesActual == indiceMes) {
                                scannerLinea.close();
                                return Double.parseDouble(valorStr);
                            }
                            mesActual++;
                        }
                    }
                }
                scannerLinea.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear el dato numérico.");
        }
        return 0.0;
    }
}
