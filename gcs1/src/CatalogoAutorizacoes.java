
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
    public ArrayList<AutorizacaoExame> getListaAutorizacoes() {
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

            public ArrayList<AutorizacaoExame> listarExamesDoPaciente(Paciente paciente) {
        ArrayList<AutorizacaoExame> resultado = new ArrayList<>();

        for (AutorizacaoExame exame : autorizacoes) {
            if (exame.getPaciente().equals(paciente)) {
                resultado.add(exame);
            }
        }

        return resultado;
    }
    public AutorizacaoExame buscarPorCodigo(int codigo) {
        for (int i = 0; i < autorizacoes.size(); i++) {
            if (autorizacoes.get(i).getCodigo() == codigo) {
                return autorizacoes.get(i);
            }
        }
        return null;
    }
    public void marcarExame(int codigo, LocalDate data) {
    AutorizacaoExame aut = buscarPorCodigo(codigo);
    if (aut != null) {
        aut.realizarExame(data);
    }
}

}
    


