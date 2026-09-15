import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Usuario {
private String username;
    private String password;
    private Set<String> permisos;

    public Usuario(String username, String password, Set<String> permisosIniciales) {
        this.username = username;
        this.password = password;
        this.permisos = new HashSet<>(permisosIniciales);
    }

    public boolean validarCredenciales(String user, String pass) {
        return this.username.equalsIgnoreCase(user) && this.password.equals(pass);
    }

    public boolean tienePermiso(String permiso) {
        return this.permisos.contains(permiso);
    }

    // 1. LEER ARCHIVO
    public void leerArchivo(String rutaArchivo) {
        if (!tienePermiso("LEER")) {
            System.out.println("\n ACCESO DENEGADO: Tu usuario '" + username + "' NO tiene el permiso 'LEER'.");
            System.out.println("   Tus permisos actuales son: " + permisos);
            return;
        }

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("\n El archivo '" + rutaArchivo + "' aún no existe.");
            return;
        }

        System.out.println("\n--- CONTENIDO DEL ARCHIVO ('" + rutaArchivo + "') ---");
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
            System.out.println("----------------------------------------------");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // 2. ESCRIBIR EN ARCHIVO
    public void escribirArchivo(String rutaArchivo, String texto) {
        if (!tienePermiso("ESCRIBIR")) {
            System.out.println("\n ACCESO DENEGADO: Tu usuario '" + username + "' NO tiene el permiso 'ESCRIBIR'.");
            System.out.println("   Tus permisos actuales son: " + permisos);
            return;
        }

        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            pw.println(username + ": " + texto);
            System.out.println("\n ¡ÉXITO! Texto guardado correctamente en '" + rutaArchivo + "'.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // 3. BORRAR TEXTO ESPECÍFICO
    public void borrarTextoEspecifico(String rutaArchivo, String textoABorrar) {
        if (!tienePermiso("ESCRIBIR")) {
            System.out.println("\n ACCESO DENEGADO: Tu usuario '" + username + "' NO tiene el permiso 'ESCRIBIR' para eliminar texto.");
            System.out.println("   Tus permisos actuales son: " + permisos);
            return;
        }

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("\n El archivo no existe.");
            return;
        }

        List<String> lineasGuardadas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String lineaActual;
            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.contains(textoABorrar)) {
                    encontrado = true;
                } else {
                    lineasGuardadas.add(lineaActual);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (encontrado) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, false))) {
                for (String linea : lineasGuardadas) {
                    writer.println(linea);
                }
                System.out.println("\n ¡ÉXITO! Se eliminó la línea/texto especificado.");
            } catch (IOException e) {
                System.out.println("Error al actualizar el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("\n No se encontró ninguna línea con el texto: '" + textoABorrar + "'");
        }
    }

    // 4. BORRAR TODO EL CONTENIDO DEL ARCHIVO
    public void borrarContenidoArchivo(String rutaArchivo) {
        if (!tienePermiso("ESCRIBIR")) {
            System.out.println("\n ACCESO DENEGADO: Tu usuario '" + username + "' NO tiene el permiso 'ESCRIBIR' para vaciar el archivo.");
            System.out.println("   Tus permisos actuales son: " + permisos);
            return;
        }

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("\n El archivo '" + rutaArchivo + "' no existe para ser borrado.");
            return;
        }

        try (FileWriter fw = new FileWriter(rutaArchivo, false)) {
            fw.write("");
            System.out.println("\n ¡ÉXITO! El contenido del archivo '" + rutaArchivo + "' ha sido borrado por completo.");
        } catch (IOException e) {
            System.out.println("Error al vaciar el archivo: " + e.getMessage());
        }
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getPermisos() {
        return permisos;
    }
}
