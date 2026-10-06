public class MetodosImplementados<T> {
    private Nodo<T> head;
    private int tamanio;

    // Constructor
    public MetodosImplementados() {
        this.head = null;
        this.tamanio = 0;
    }

    // esta_vacia()
    public boolean esta_vacia() {
        return this.head == null; 
    }

    // get_tamanio()
    public int get_tamanio() {
        return this.tamanio;
    }

    // Agregar(valor)
    public void Agregar(T valor) {
        agregar_al_final(valor);
    }

    // agregar_al_final(valor)
    public void agregar_al_final(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (esta_vacia()) {
            this.head = nuevo;
        } else {
            Nodo<T> aux = this.head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        this.tamanio++;
    }

    // agregar_al_inicio(valor)
    public void agregar_al_inicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor, this.head);
        this.head = nuevo;
        this.tamanio++;
    }

    // agregar_después_de(referencia, valor)
    public void agregar_despues_de(T referencia, T valor) {
        Nodo<T> aux = this.head;
        
        while (aux != null && !aux.getDato().equals(referencia)) {
            aux = aux.getSiguiente();
        }
        
        if (aux != null) {
            Nodo<T> nuevo = new Nodo<>(valor, aux.getSiguiente());
            aux.setSiguiente(nuevo);
            this.tamanio++;
        } else {
            System.out.println("Referencia no encontrada.");
        }
    }

    // eliminar_el_primero()
    public void eliminar_el_primero() {
        if (!esta_vacia()) {
            this.head = this.head.getSiguiente();
            this.tamanio--;
        }
    }

    // eliminar_el_final()
    public void eliminar_el_final() {
        if (!esta_vacia()) {
            if (this.head.getSiguiente() == null) {
                this.head = null;
            } else {
                Nodo<T> aux = this.head;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
            }
            this.tamanio--;
        }
    }

    // buscar(valor)
    public int buscar(T valor) {
        Nodo<T> aux = this.head;
        int posicion = 0;
        while (aux != null) {
            if (aux.getDato().equals(valor)) {
                return posicion;
            }
            aux = aux.getSiguiente();
            posicion++;
        }
        return -1; 
    }

    // actualizar(a_buscar, valor)
    public void actualizar(T a_buscar, T valor) {
        Nodo<T> aux = this.head;
        while (aux != null) {
            if (aux.getDato().equals(a_buscar)) {
                aux.setDato(valor);
                return; 
            }
            aux = aux.getSiguiente();
        }
    }

    // transversal()
    public void transversal() {
        Nodo<T> aux = this.head;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }
}
