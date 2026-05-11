import java.time.LocalDate;

public class AutorizacaoExame {

    private static int proximoCodigo = 1000;

    private int codigo;
    private LocalDate dataCadastro;
    private Medico medico;
    private Paciente paciente;
    private Exame exame;
    private LocalDate dataRealizacao;
    private boolean realizado;

    public AutorizacaoExame(Medico medico, Paciente paciente, Exame exame) {
        this.codigo = proximoCodigo;
        proximoCodigo++; // incrementa a cada novo objeto

        this.dataCadastro = LocalDate.now();
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.dataRealizacao = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Exame getExame() {
        return exame;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void realizarExame(LocalDate data) {
        if (data.isBefore(dataCadastro)) {
            throw new IllegalArgumentException("Data não pode ser antes da solicitação.");
        }

        if (data.isAfter(dataCadastro.plusDays(30))) {
            throw new IllegalArgumentException("Exame deve ser realizado em até 30 dias.");
        }

        this.dataRealizacao = data;
    }

    //Verifica se já foi realizado
    public boolean isRealizado() {
        return dataRealizacao != null;
    }
    public void marcaComoRealizado(){
        this.realizado=true;
    }

    //Representação em texto
    @Override
    public String toString() {
        return "AutorizacaoExame{" +
                "codigo=" + codigo +
                ", dataCadastro=" + dataCadastro +
                ", medico=" + medico.getNome() +
                ", paciente=" + paciente.getNome() +
                ", exame=" + exame +
                ", dataRealizacao=" + dataRealizacao +
                '}';
    }
}