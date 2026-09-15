import java.util.ArrayList;
import java.util.List;

public class SistemaUsuarios {
    private List<Usuario> listaUsuarios;

    public SistemaUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario autenticar(String username, String password) {
        for (Usuario u : listaUsuarios) {
            if (u.validarCredenciales(username, password)) {
                return u; // Retorna el usuario autenticado
            }
        }
        return null; // Credenciales incorrectas
    }
   
}
