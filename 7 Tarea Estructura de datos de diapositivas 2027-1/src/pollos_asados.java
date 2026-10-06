public class pollos_asados {
public static void main(String[] args) {
MetodosImplementados<PolloAsado> menu = new MetodosImplementados<>();
System.out.println("=== 1. ESTA VACIA? ===");
        System.out.println("¿La lista está vacía al inicio? " + menu.esta_vacia());

        System.out.println("\n=== 2. AGREGAR (Por defecto al final) ===");
        PolloAsado clasico = new PolloAsado("Pollo Clasico", 150.0);
        menu.Agregar(clasico);
        System.out.println("Se agrego 'Pollo Clasico' a la lista.");

        System.out.println("\n=== 3. AGREGAR AL FINAL ===");
        menu.agregar_al_final(new PolloAsado("Pollo Enchilado", 160.0));
        System.out.println("Se agrego 'Pollo Enchilado' al final de la lista.");

        System.out.println("\n=== 4. AGREGAR AL INICIO ===");
        menu.agregar_al_inicio(new PolloAsado("Paquete Familiar", 280.0));
        System.out.println("Se agrego 'Paquete Familiar' al inicio de la lista.");

        // Prueba explícita del método transversal
        System.out.println("\n=== 5. TRANSVERSAL (Mostrar todos los elementos) ===");
        menu.transversal();

        System.out.println("\n=== 6. AGREGAR DESPUES DE REFERENCIA ===");
        System.out.println("Agregando 'Medio Pollo' despues de 'Pollo Clasico'...");
        menu.agregar_despues_de(new PolloAsado("Pollo Clasico", 0), new PolloAsado("Medio Pollo", 80.0));
        menu.transversal();

        System.out.println("\n=== 7. BUSCAR ===");
        PolloAsado aBuscar = new PolloAsado("Medio Pollo", 0);
        int posicion = menu.buscar(aBuscar);
        System.out.println("El elemento 'Medio Pollo' esta en el indice: " + posicion);

        System.out.println("\n=== 8. ACTUALIZAR ===");
        System.out.println("Cambiando 'Pollo Enchilado' por 'Pollo BBQ'...");
        menu.actualizar(new PolloAsado("Pollo Enchilado", 0), new PolloAsado("Pollo BBQ", 175.0));
        menu.transversal();

        System.out.println("\n=== 9. ELIMINAR EL PRIMERO ===");
        System.out.println("Se eliminara el primer elemento ('Paquete Familiar')...");
        menu.eliminar_el_primero();
        menu.transversal();

        System.out.println("\n=== 10. ELIMINAR EL FINAL ===");
        System.out.println("Se eliminara el ultimo elemento ('Pollo BBQ')...");
        menu.eliminar_el_final();
        menu.transversal(); 

        System.out.println("\n=== 11. OBTENER TAMANIO ===");
        System.out.println("El tamanio final de la lista es: " + menu.get_tamanio());
    }
}
