public class Administrador extends Usuario {
    private String cracha;

    public Administrador(tipoUsuario tipo, int id, String nome, String cracha) {
        super(tipo, id, nome);
        this.cracha = cracha;
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }
}
