public class Paciente extends Usuario {
    private String cpf; 

    public Paciente(tipoUsuario tipo,int id, String nome, String cpf) {
        super(tipo, id, nome);
        this.cpf = cpf;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
