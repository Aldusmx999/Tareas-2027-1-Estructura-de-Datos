import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoDeLaVida {
private Array2D<Integer> grid;
    private int renglones;
    private int columnas;

    public JuegoDeLaVida(String rutaCSV) {
        cargarDesdeCSV(rutaCSV);
    }

    private void cargarDesdeCSV(String rutaCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            int maxCol = 0;
            int totalRen = 0;

            // Determinar dimensiones
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    totalRen++;
                    String[] valores = linea.split(",");
                    maxCol = Math.max(maxCol, valores.length);
                }
            }

            this.renglones = Math.max(totalRen, 10);
            this.columnas = Math.max(maxCol, 10);
            this.grid = new Array2D<>(this.renglones, this.columnas);
            this.grid.rellenar(0);

            // Cargar los datos del CSV
            BufferedReader br2 = new BufferedReader(new FileReader(rutaCSV));
            int r = 0;
            while ((linea = br2.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] valores = linea.split(",");
                for (int c = 0; c < valores.length; c++) {
                    int val = Integer.parseInt(valores[c].trim());
                    grid.setElemento(r, c, val);
                }
                r++;
            }
            br2.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public int getVecinosVivos(int r, int c) {
        int vivos = 0;
        int[][] direcciones = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] dir : direcciones) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (grid.esValido(nr, nc) && grid.getElemento(nr, nc) == 1) {
                vivos++;
            }
        }
        return vivos;
    }

    public void siguienteGeneracion() {
        Array2D<Integer> nuevoGrid = new Array2D<>(renglones, columnas);

        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                int estadoActual = grid.getElemento(i, j);
                int vecinosVivos = getVecinosVivos(i, j);

                if (estadoActual == 1) {
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        nuevoGrid.setElemento(i, j, 1);
                    } else {
                        nuevoGrid.setElemento(i, j, 0);
                    }
                } else {
                    if (vecinosVivos == 3) {
                        nuevoGrid.setElemento(i, j, 1);
                    } else {
                        nuevoGrid.setElemento(i, j, 0);
                    }
                }
            }
        }
        this.grid = nuevoGrid;
    }

    public void mostrarTablero() {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(grid.getElemento(i, j) == 1 ? "█ " : "· ");
            }
            System.out.println();
        }
    }
}
