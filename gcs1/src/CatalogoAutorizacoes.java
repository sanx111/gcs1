import java.time.LocalDate;
import java.util.ArrayList;

public class CatalogoAutorizacoes {
    private ArrayList<AutorizacaoExame> autorizacoes;

    public CatalogoAutorizacoes() {
        this.autorizacoes = new ArrayList<>();
    }

    public void listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        boolean encontrou = false;
        for (AutorizacaoExame a : autorizacoes) {
            // Verifica se a data de cadastro está entre o intervalo
            if ((a.getDataCadastro().isAfter(inicio) || a.getDataCadastro().isEqual(inicio)) &&
                (a.getDataCadastro().isBefore(fim) || a.getDataCadastro().isEqual(fim))) {
                System.out.println(a);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma autorização encontrada no período.");
        }
    }

    public void adicionar(AutorizacaoExame a) {
        this.autorizacoes.add(a);
    }
}