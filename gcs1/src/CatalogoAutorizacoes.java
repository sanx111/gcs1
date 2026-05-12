import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatalogoAutorizacoes {

    private ArrayList<AutorizacaoExame> autorizacoes = new ArrayList<AutorizacaoExame>();

    public void adicionarAutorizacao(AutorizacaoExame a) {
        autorizacoes.add(a);
    }

    public ArrayList<AutorizacaoExame> getAutorizacoes() {
        return autorizacoes;
    }

    public int contarAutorizacoes() {
        return autorizacoes.size();
    }

    public double calcularPercentualRealizados() {
        if (autorizacoes.isEmpty()) {
            return 0.0;
        }
        int realizados = 0;
        for (AutorizacaoExame a : autorizacoes) {
            if (a.isRealizado()) { 
                realizados++;
            }
        }
        return (realizados * 100.0) / autorizacoes.size();

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