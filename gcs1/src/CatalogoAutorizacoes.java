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
    public List<AutorizacaoExame> listarPorPaciente(Paciente paciente) {
        List<AutorizacaoExame> resultado = new ArrayList<>();
        for (AutorizacaoExame a : autorizacoes) {
            if (a.getPaciente().getId() == paciente.getId()) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}