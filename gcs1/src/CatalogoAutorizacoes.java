import java.util.ArrayList;

public class CatalogoAutorizacoes {

    public ArrayList<AutorizacaoExame> listarExamesDoPaciente(Paciente paciente) {
        ArrayList<AutorizacaoExame> resultado = new ArrayList<>();

        for (AutorizacaoExame exame : listaAutorizacoes) {
            if (exame.getPaciente().equals(paciente)) {
                resultado.add(exame);
            }
        }

        return resultado;
    }
    public ArrayList<AutorizacaoExame> getListaAutorizacoes() {
    return listaAutorizacoes;

}
