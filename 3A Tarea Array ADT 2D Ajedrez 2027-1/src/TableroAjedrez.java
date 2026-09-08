
public class TableroAjedrez {

    // Códigos Unicode exactos de Piezas Negras
    private static final String TORRE_NEGRA   = "\u265C";
    private static final String CABALLO_NEGRO = "\u265E";
    private static final String ALFIL_NEGRO   = "\u265D";
    private static final String REINA_NEGRA   = "\u265B";
    private static final String REY_NEGRO     = "\u265A";
    private static final String PEON_NEGRO    = "\u265F";

    // Códigos Unicode exactos de Piezas Blancas
    private static final String TORRE_BLANCA   = "\u2656";
    private static final String CABALLO_BLANCO = "\u2658";
    private static final String ALFIL_BLANCO   = "\u2657";
    private static final String REINA_BLANCA   = "\u2655";
    private static final String REY_BLANCO     = "\u2654";
    private static final String PEON_BLANCO    = "\u2659";

    private ArrayADT2D<String> tablero;

    public TableroAjedrez() {
        this.tablero = new ArrayADT2D<>(8, 8);
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Fila 0: Piezas principales negras
        tablero.insertarElemento(0, 0, TORRE_NEGRA);
        tablero.insertarElemento(0, 1, CABALLO_NEGRO);
        tablero.insertarElemento(0, 2, ALFIL_NEGRO);
        tablero.insertarElemento(0, 3, REINA_NEGRA);
        tablero.insertarElemento(0, 4, REY_NEGRO);
        tablero.insertarElemento(0, 5, ALFIL_NEGRO);
        tablero.insertarElemento(0, 6, CABALLO_NEGRO);
        tablero.insertarElemento(0, 7, TORRE_NEGRA);

        // Fila 1: Peones negros
        for (int col = 0; col < 8; col++) {
            tablero.insertarElemento(1, col, PEON_NEGRO);
        }

        // Fila 6: Peones blancos
        for (int col = 0; col < 8; col++) {
            tablero.insertarElemento(6, col, PEON_BLANCO);
        }

        // Fila 7: Piezas principales blancas
        tablero.insertarElemento(7, 0, TORRE_BLANCA);
        tablero.insertarElemento(7, 1, CABALLO_BLANCO);
        tablero.insertarElemento(7, 2, ALFIL_BLANCO);
        tablero.insertarElemento(7, 3, REINA_BLANCA);
        tablero.insertarElemento(7, 4, REY_BLANCO);
        tablero.insertarElemento(7, 5, ALFIL_BLANCO);
        tablero.insertarElemento(7, 6, CABALLO_BLANCO);
        tablero.insertarElemento(7, 7, TORRE_BLANCA);
    }

    public void mostrar() {
        tablero.imprimir();
    }
    
}
