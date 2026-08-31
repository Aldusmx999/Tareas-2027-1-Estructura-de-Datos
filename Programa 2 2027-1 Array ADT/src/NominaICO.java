import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NominaICO {

private ArrayADT<Empleado> datos;
private String rutaArchivo;

//inicializa el ArrayADT con tamaño 14 
    public NominaICO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.datos = new ArrayADT<>(14); 
    }
public void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimeraLinea = true;
            int indice = 0; // Contador para controlar la posición en el ArrayADT

            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }

                if (linea.trim().isEmpty()) continue;

                String[] campos = linea.split(",");

                int numTrabajador = Integer.parseInt(campos[0].trim());
                String nombres = campos[1].trim();
                String paterno = campos[2].trim();
                String materno = campos[3].trim();
                float horasExtras = Float.parseFloat(campos[4].trim());
                float sueldoBase = Float.parseFloat(campos[5].trim());
                int anioIngreso = Integer.parseInt(campos[6].trim());

                Empleado emp = new Empleado(numTrabajador, nombres, materno, paterno, horasExtras, sueldoBase, anioIngreso);
                
                // Uso de tu método insertarElemento
                if (indice < datos.longitud()) {
                    datos.insertarElemento(indice, emp);
                    indice++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Empleado obtenerMayorAntiguedad() {
        if (datos.longitud() == 0) return null;

        // método obtenerElemento
        Empleado mayor = datos.obtenerElemento(0);
        for (int i = 1; i < datos.longitud(); i++) {
            Empleado actual = datos.obtenerElemento(i);
            if (actual != null && actual.getAnioingreso() < mayor.getAnioingreso()) {
                mayor = actual;
            }
        }
        return mayor;
    }

    public Empleado obtenerMenorAntiguedad() {
        if (datos.longitud() == 0) return null;

        // método obtenerElemento
        Empleado menor = datos.obtenerElemento(0);
        for (int i = 1; i < datos.longitud(); i++) {
            Empleado actual = datos.obtenerElemento(i);
            if (actual != null && actual.getAnioingreso() > menor.getAnioingreso()) {
                menor = actual;
            }
        }
        return menor;
    }

   public void imprimirNomina() {
    System.out.println("======================================== NÓMINA DE EMPLEADOS ========================================");
    for (int i = 0; i < datos.longitud(); i++) {
        Empleado emp = datos.obtenerElemento(i);
        if (emp != null) {
            double sueldoFinal = emp.calcularSueldo();
            System.out.printf("ID: %-5d | Nombre: %-25s | Antigüedad: %d años | Sueldo Final: $%.2f%n",
                    emp.getNumTrabajador(),
                    emp.getNombres() + " " + emp.getApellidoPaterno(),
                    (2026 - emp.getAnioingreso()),
                    sueldoFinal);
        }
    }
    System.out.println("====================================================================================================");
}

}
