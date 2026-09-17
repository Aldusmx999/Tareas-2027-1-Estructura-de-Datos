public class ListaEnlazada {

    public static void main(String[] args) {

            // 1. Construcción manual de la lista según la imagen: Al -> B -> C -> De -> Mc -> Zi
            Nodo<String> nodoZi = new Nodo<>("Zi");
            Nodo<String> nodoMc = new Nodo<>("Mc", nodoZi);
            Nodo<String> nodoDe = new Nodo<>("De", nodoMc);
            Nodo<String> nodoC = new Nodo<>("C", nodoDe);
            Nodo<String> nodoB = new Nodo<>("B", nodoC);
            Nodo<String> cabeza = new Nodo<>("Al", nodoB); // Puntero 'head'

            // Estado inicial completo
            System.out.println("--- 1. Estado inicial de la lista ---");
            ListaAuxiliares.imprimirLista(cabeza);

            // 2. Imprimir únicamente el dato almacenado en el primer nodo
            System.out.println("\n--- 2. Dato del primer nodo ---");
            System.out.println("Primer dato: " + cabeza.getDato());

            // 3. Imprimir el estado completo del nodo ubicado en la última posición
            System.out.println("\n--- 3. Estado completo del último nodo ---");
            Nodo<String> ultimo = ListaAuxiliares.obtenerUltimoNodo(cabeza);
            System.out.println("Último nodo: " + ultimo);

            // 4. Insertar un nuevo nodo con el valor "Fe" entre "De" y "Mc"
            System.out.println("\n--- 4. Inserción de 'Fe' entre 'De' y 'Mc' ---");
            Nodo<String> nodoFe = new Nodo<>("Fe", nodoMc);
            nodoDe.setSiguiente(nodoFe);
            ListaAuxiliares.imprimirLista(cabeza);

            // 5. Insertar un nuevo nodo con el valor "Zz" al final de la lista
            System.out.println("\n--- 5. Inserción de 'Zz' al final ---");
            Nodo<String> nodoZz = new Nodo<>("Zz");
            Nodo<String> actualUltimo = ListaAuxiliares.obtenerUltimoNodo(cabeza);
            actualUltimo.setSiguiente(nodoZz);
            ListaAuxiliares.imprimirLista(cabeza);

            // 6. Insertar un nuevo nodo con el valor "Aa" al inicio de la lista
            System.out.println("\n--- 6. Inserción de 'Aa' al inicio (Estado final) ---");
            cabeza = new Nodo<>("Aa", cabeza);
            ListaAuxiliares.imprimirLista(cabeza);
        }
    }


