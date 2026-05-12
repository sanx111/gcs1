import java.util.Scanner;

public class App {

    public void executar() {

        int opcao;
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoAutorizacoes catalogoAutorizacoes = new CatalogoAutorizacoes();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("=== MENU ===");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar usuario");
            System.out.println("[2] Listar usuarios");
            System.out.println("[3] Menu do administrador");
            System.out.print("Opcao: ");

            opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastraUsuario(catalogoUsuarios);
                    break;
                case 2:
                    listarUsuarios(catalogoUsuarios);
                    break;
                case 3:
                    menuAdministrador(catalogoUsuarios, catalogoAutorizacoes);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (opcao != 0);
    }

    public void cadastraUsuario(CatalogoUsuarios catalogoUsuarios) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o id do usuario");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome do usuario");
        String nome = in.nextLine();
        System.out.println("Selecione o tipo de usuario a ser adicionado:");
        System.out.println("[0] Sair");
        System.out.println("[1] Paciente");
        System.out.println("[2] Medico");
        System.out.println("[3] Administrador");
        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                System.out.println("Digite o cpf do paciente:");
                String cpf = in.nextLine();
                Usuario p = new Paciente(tipoUsuario.PACIENTE, id, nome, cpf);
                catalogoUsuarios.adicionarUsuario(p);
                break;
            case 2:
                System.out.println("Digite o crm do medico:");
                String crm = in.nextLine();
                Usuario m = new Medico(tipoUsuario.MEDICO, id, nome, crm);
                catalogoUsuarios.adicionarUsuario(m);
                break;
            case 3:
                System.out.println("Digite o cracha do administrador:");
                String cracha = in.nextLine();
                Usuario a = new Administrador(tipoUsuario.ADMINISTRADOR, id, nome, cracha);
                catalogoUsuarios.adicionarUsuario(a);
                break;
            default:
                System.out.println("tipo inexistente");
                break;
        }
    }

    public void listarUsuarios(CatalogoUsuarios catalogoUsuarios) {
        for (Usuario u : catalogoUsuarios.getUsuarios()) {
            if (u.getTipo() == tipoUsuario.PACIENTE) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Paciente p = (Paciente) u;
                System.out.println("CPF: " + p.getCpf());
            } else if (u.getTipo() == tipoUsuario.MEDICO) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Medico m = (Medico) u;
                System.out.println("crm: " + m.getCrm());
            } else if (u.getTipo() == tipoUsuario.ADMINISTRADOR) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Administrador a = (Administrador) u;
                System.out.println("Cracha: " + a.getCracha());
            }
        }
    }

    public void menuAdministrador(CatalogoUsuarios catalogoUsuarios,
                                  CatalogoAutorizacoes catalogoAutorizacoes) {

        Scanner in = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== MENU ADMINISTRADOR ===");
            System.out.println("[0] Voltar");
            System.out.println("[1] Ver estatisticas gerais");
            System.out.print("Opcao: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    mostrarEstatisticasGerais(catalogoUsuarios, catalogoAutorizacoes);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (opcao != 0);
    }

    public void mostrarEstatisticasGerais(CatalogoUsuarios catalogoUsuarios,
                                          CatalogoAutorizacoes catalogoAutorizacoes) {

        int numMedicos = catalogoUsuarios.contarMedicos();
        int numPacientes = catalogoUsuarios.contarPacientes();
        int numAutorizacoes = catalogoAutorizacoes.contarAutorizacoes();

        System.out.println("=== ESTATISTICAS ===");
        System.out.println("Numero de medicos: " + numMedicos);
        System.out.println("Numero de pacientes: " + numPacientes);
        System.out.println("Numero de autorizacoes emitidas: " + numAutorizacoes);
    }

    public void criarAutorizacao() {
        System.out.println("ID do Medico:");
        int idMed = in.nextInt();
        Medico medico = (Medico) buscarUsuarioPorId(idMed, tipoUsuario.MEDICO);

        System.out.println("ID do Paciente:");
        int idPac = in.nextInt();
        Paciente paciente = (Paciente) buscarUsuarioPorId(idPac, tipoUsuario.PACIENTE);

        if (medico == null || paciente == null) {
            System.out.println("Erro: Medico ou Paciente nao encontrados.");
            return;
        }

        System.out.println("Escolha o Exame:");
        Exame[] examesDisponiveis = Exame.values();
        for (int i = 0; i < examesDisponiveis.length; i++) {
            System.out.println("[" + i + "] " + examesDisponiveis[i]);
        }
        int escolha = in.nextInt();
        
        if (escolha >= 0 && escolha < examesDisponiveis.length) {
            Exame exameEscolhido = examesDisponiveis[escolha];
            AutorizacaoExame nova = new AutorizacaoExame(medico, paciente, exameEscolhido);
            catalogo.adicionar(nova);
            System.out.println("Autorizacao gerada! Codigo: " + nova.getCodigo());
        } else {
            System.out.println("Exame invalido.");
        }
    }

    private Usuario buscarUsuarioPorId(int id, tipoUsuario tipo) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId() == id && u.getTipo() == tipo) {
                return u;
            }
        }
        return null;
    }
}