import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ArrayADT2D <T>{
private int filas;
    private int columnas;
    private Object[][] datos;

    public ArrayADT2D(int f, int c) {
        this.filas = f;
        this.columnas = c;
        this.datos = new Object[filas][columnas];
    }

    @SuppressWarnings("unchecked")
    public T obtenerElemento(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (T) datos[fila][columna];
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int fila, int columna, T elemento) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            datos[fila][columna] = elemento;
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void rellenar(T elemento) {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                datos[f][c] = elemento;
            }
        }
    }

    public void imprimir() {
        // Garantiza salida UTF-8
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

        out.print("  ");
        for (int c = 0; c < columnas; c++) {
            out.print(c + " ");
        }
        out.println();

        for (int f = 0; f < filas; f++) {
            out.print(f + " ");
            for (int c = 0; c < columnas; c++) {
                Object val = datos[f][c];
                out.print((val != null ? val : ".") + " ");
            }
            out.println();
        }
    }
   
}

