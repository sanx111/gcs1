public abstract class Usuario {
    private int id;
    private String nome;
    private tipoUsuario tipo;

    public Usuario(tipoUsuario tipo,int id, String nome){
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
    }

    public tipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
