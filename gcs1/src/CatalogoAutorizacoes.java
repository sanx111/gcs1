import java.util.ArrayList;
import java.util.List;

public class CatalogoAutorizacoes {

    private List<AutorizacaoExame> autorizacoes;

    public CatalogoAutorizacoes() {
        this.autorizacoes = new ArrayList<>();
    }

    public void adicionarAutorizacao(AutorizacaoExame autorizacao) {
        autorizacoes.add(autorizacao);
    }

    public List<AutorizacaoExame> getAutorizacoes() {
        return autorizacoes;
    }

}