import java.util.ArrayList;

public class CatalogoAutorizacoes {
    private ArrayList<AutorizacaoExame> listaAutorizacoes;

    public CatalogoAutorizacoes(){
        listaAutorizacoes = new ArrayList<>();

    }
    public boolean marcarExameComoRealizado(int codigo){
        for(AutorizacaoExame exame: listaAutorizacoes){
            if(exame.getCodigo()==codigo){
                exame.marcaComoRealizado();
                return true;
            }
        }

        return false;

    }
}
