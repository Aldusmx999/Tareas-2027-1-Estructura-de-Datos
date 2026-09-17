public class ListaAuxiliares {
    // Método auxiliar para imprimir los valores de la lista de forma legible
    public static void imprimirLista(Nodo<String> cabeza) {
        Nodo<String> aux = cabeza;
        StringBuilder sb = new StringBuilder();
        while (aux != null) {
            sb.append("[").append(aux.getDato()).append("]");
            if (aux.getSiguiente() != null) {
                sb.append(" -> ");
            }
            aux = aux.getSiguiente();
        }
        System.out.println(sb.toString());
    }

    // Método auxiliar para obtener la referencia del último nodo
    public static Nodo<String> obtenerUltimoNodo(Nodo<String> cabeza) {
        Nodo<String> aux = cabeza;
        while (aux != null && aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
}
