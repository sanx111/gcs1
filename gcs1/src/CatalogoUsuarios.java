import java.util.ArrayList;

public class CatalogoUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public int contarMedicos() {
        int count = 0;
        for (Usuario u : usuarios) {
            if (u.getTipo() == tipoUsuario.MEDICO) {
                count++;
            }
        }
        return count;
    }

    public int contarPacientes() {
        int count = 0;
        for (Usuario u : usuarios) {
            if (u.getTipo() == tipoUsuario.PACIENTE) {
                count++;
            }
        }
        return count;
    }
}