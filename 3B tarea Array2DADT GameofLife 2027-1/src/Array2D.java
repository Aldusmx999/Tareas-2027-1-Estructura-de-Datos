public class Array2D <T>{
    private int renglones;
    private int columnas;
    private Object[][] datos;

    public Array2D(int ren, int col) {
        this.renglones = ren;
        this.columnas = col;
        this.datos = new Object[ren][col];
    }

    public int getRenglones() {
        return renglones;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setElemento(int ren, int col, T dato) {
        if (esValido(ren, col)) {
            datos[ren][col] = dato;
        } else {
            throw new ArrayIndexOutOfBoundsException("Coordenadas fuera de rango: (" + ren + ", " + col + ")");
        }
    }

    @SuppressWarnings("unchecked")
    public T getElemento(int ren, int col) {
        if (esValido(ren, col)) {
            return (T) datos[ren][col];
        } else {
            throw new ArrayIndexOutOfBoundsException("Coordenadas fuera de rango: (" + ren + ", " + col + ")");
        }
    }

    public void rellenar(T dato) {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = dato;
            }
        }
    }

    public boolean esValido(int ren, int col) {
        return ren >= 0 && ren < renglones && col >= 0 && col < columnas;
    }

    public void imprimir() {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(getElemento(i, j) + " ");
            }
            System.out.println();
        }
    }
    
}
