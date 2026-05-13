import java.time.LocalDateTime;

public class Log {
    private LocalDateTime dataHora;
    private String descricao;
    private Usuario usuarioResponsavel;

    public Log(LocalDateTime dataHora, String descricao, Usuario usuario) {
        this.dataHora = LocalDateTime.now();
        this.descricao = descricao;
        this.usuarioResponsavel = usuario;
        ;
    }

   @Override
    public String toString() {
        return "[" + dataHora + "] - User ID: " + usuarioResponsavel.getId() + " - Ação: " + descricao;
    }
    
}
