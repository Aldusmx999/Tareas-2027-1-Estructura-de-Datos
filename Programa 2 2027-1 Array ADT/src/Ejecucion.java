public class  Ejecucion {
    public static void main(String[] args) {
       
        NominaICO nomina = new NominaICO("src/junio.dat");

        nomina.cargarDesdeArchivo();
        
        // Imprimir la nómina completa con los sueldos finales calculados
        nomina.imprimirNomina();

        System.out.println();

        // Consultar y mostrar el empleado con mayor antigüedad
        Empleado mayorAntiguedad = nomina.obtenerMayorAntiguedad();
        if (mayorAntiguedad != null) {
            System.out.println("--- EMPLEADO CON MAYOR ANTIGÜEDAD ---");
            System.out.println(mayorAntiguedad);
            System.out.println("Sueldo Calculado: $" + String.format("%.2f", mayorAntiguedad.calcularSueldo()));
        }

        System.out.println();

        // Consultar y mostrar el empleado con menor antigüedad
        Empleado menorAntiguedad = nomina.obtenerMenorAntiguedad();
        if (menorAntiguedad != null) {
            System.out.println("--- EMPLEADO CON MENOR ANTIGÜEDAD ---");
            System.out.println(menorAntiguedad);
            System.out.println("Sueldo Calculado: $" + String.format("%.2f", menorAntiguedad.calcularSueldo()));
        }
    }
    
}

