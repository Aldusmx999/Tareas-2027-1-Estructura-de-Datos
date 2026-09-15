import java.util.Scanner;
import java.util.Set;

public class App {
    private static final String ARCHIVO_TXT = "notas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaUsuarios sistema = new SistemaUsuarios();

        // Registro de usuarios de prueba con sus conjuntos de permisos
        sistema.registrarUsuario(new Usuario("admin", "admin123", Set.of("LEER", "ESCRIBIR", "IMPRIMIR")));
        sistema.registrarUsuario(new Usuario("lector", "1234", Set.of("LEER")));
        sistema.registrarUsuario(new Usuario("invitado", "0000", Set.of()));

        System.out.println("=====================================");
        System.out.println("    SISTEMA DE GESTIÓN CON SETS      ");
        System.out.println("=====================================");

        // --- LOGIN ---
        Usuario usuarioLogueado = null;
        while (usuarioLogueado == null) {
            System.out.print("\nUsuario: ");
            String user = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            usuarioLogueado = sistema.autenticar(user, pass);

            if (usuarioLogueado == null) {
                System.out.println(" Credenciales incorrectas. Intenta de nuevo.");
            }
        }

        System.out.println("\nSesión iniciada como: " + usuarioLogueado.getUsername());
        System.out.println("Conjunto de permisos: " + usuarioLogueado.getPermisos());

        // --- MENÚ DE ACCIONES ACTUALIZADO ---
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- OPCIONES ---");
            System.out.println("1. Leer archivo txt");
            System.out.println("2. Modificar/Escribir en archivo txt");
            System.out.println("3. Borrar contenido del archivo txt");
            System.out.println("4. Borrar texto específico del archivo txt");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    usuarioLogueado.leerArchivo(ARCHIVO_TXT);
                    break;
                case "2":
                    System.out.print("Texto a agregar: ");
                    String texto = scanner.nextLine();
                    usuarioLogueado.escribirArchivo(ARCHIVO_TXT, texto);
                    break;
                case "3":
                    usuarioLogueado.borrarContenidoArchivo(ARCHIVO_TXT);
                    break;
                case "4":
                    System.out.print("Ingresa el texto o palabra que deseas borrar del archivo: ");
                    String textoBorrar = scanner.nextLine();
                    usuarioLogueado.borrarTextoEspecifico(ARCHIVO_TXT, textoBorrar);
                    break;
                case "5":
                    System.out.println("Cerrando sesión...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
 }



