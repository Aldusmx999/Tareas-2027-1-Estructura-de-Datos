public class pollos_asados {
public static void main(String[] args) {
        // 1. Probando el Constructor (ListaLigada)
        MetodosImplementados<String> menu = new MetodosImplementados<>();

        System.out.println("=== 1. ESTA VACIA? ===");
        System.out.println("¿La lista está vacía al inicio? " + menu.esta_vacia());

        System.out.println("\n=== 2. AGREGAR (Por defecto al final) ===");
        menu.Agregar("Pollo Clásico");
        menu.transversal();

        System.out.println("\n=== 3. AGREGAR AL FINAL ===");
        menu.agregar_al_final("Pollo Enchilado");
        menu.transversal();

        System.out.println("\n=== 4. AGREGAR AL INICIO ===");
        menu.agregar_al_inicio("Paquete Familiar");
        menu.transversal();

        System.out.println("\n=== 5. AGREGAR DESPUÉS DE REFERENCIA ===");
        System.out.println("Agregando 'Refresco 2L' después de 'Pollo Clásico'...");
        menu.agregar_despues_de("Pollo Clásico", "Refresco 2L");
        menu.transversal();

        System.out.println("\n=== 6. BUSCAR ===");
        String aBuscar = "Refresco 2L";
        int posicion = menu.buscar(aBuscar);
        System.out.println("El elemento '" + aBuscar + "' está en el índice (empezando en 0): " + posicion);

        System.out.println("\n=== 7. ACTUALIZAR ===");
        System.out.println("Cambiando 'Pollo Enchilado' por 'Pollo BBQ'...");
        menu.actualizar("Pollo Enchilado", "Pollo BBQ");
        menu.transversal();

        System.out.println("\n=== 8. ELIMINAR EL PRIMERO ===");
        System.out.println("Se eliminará el 'Paquete Familiar'...");
        menu.eliminar_el_primero();
        menu.transversal();

        System.out.println("\n=== 9. ELIMINAR EL FINAL ===");
        System.out.println("Se eliminará el 'Pollo BBQ'...");
        menu.eliminar_el_final();
        menu.transversal(); // Prueba final de recorrido transversal

        System.out.println("\n=== 10. OBTENER TAMAÑO ===");
        System.out.println("El tamaño final de la lista es: " + menu.get_tamanio());
        
        System.out.println("\n=== VERIFICACIÓN FINAL ESTA_VACIA ===");
        System.out.println("¿La lista está vacía ahora? " + menu.esta_vacia());
    }
}
