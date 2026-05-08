public class Medico extends Usuario{
    private String crm;

    public Medico(tipoUsuario tipo, int id, String nome, String crm) {
        super(tipo, id, nome);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
