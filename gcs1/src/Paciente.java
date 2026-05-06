public class Paciente extends Usuario {
    private String cpf;

    public Paciente(int id, String nome, String cpf) {
        super (id, nome);
        this.cpf = cpf;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getTipo() {
        return "Paciente";
    }
}
