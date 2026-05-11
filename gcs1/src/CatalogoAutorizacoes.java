import java.time.LocalDate;
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

    public List<AutorizacaoExame> listarPorExame(Exame exame) {
        List<AutorizacaoExame> resultado = new ArrayList<>();
        for (AutorizacaoExame a : autorizacoes) {
            if (a.getExame() == exame) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public List<AutorizacaoExame> listarPorData(LocalDate data) {
        List<AutorizacaoExame> resultado = new ArrayList<>();
        for (AutorizacaoExame a : autorizacoes) {
            if (a.getDataCadastro().equals(data)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public List<AutorizacaoExame> listarRealizados() {
        List<AutorizacaoExame> resultado = new ArrayList<>();
        for (AutorizacaoExame a : autorizacoes) {
            if (a.isRealizado()) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}