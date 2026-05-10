import java.util.ArrayList;

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
}