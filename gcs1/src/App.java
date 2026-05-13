import java.util.Scanner;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public void executar() {

        int opcao;
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoAutorizacoes catalogoAutorizacoes = new CatalogoAutorizacoes();
        Scanner in = new Scanner(System.in);
        CatalogoAutorizacoes cat = new CatalogoAutorizacoes();

        do {
            System.out.println("=== MENU ===");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar usuario");
            System.out.println("[2] Listar usuarios");           
            System.out.println("[3] marcar Exame como realizado");
            System.out.println("[4] listar exames do paciente");
            System.out.println("[5] Menu do administrador");
           System.out.println("[6] Autorizao de usuarios");
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
                    listarExamesPaciente(cat, in);
                    break;
                case 4:
                    marcarExame(cat, in);
                    break;
                case 5:
                        menuAdministrador(catalogoUsuarios, catalogoAutorizacoes);
                        break;
                case 6:
                    menu_AutorizacaoUsuario(usuarios);
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


    public void menu_AutorizacaoUsuario(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);

        System.out.println("Selecione o tipo de consulta:");
        System.out.println("[0] Sair");
        System.out.println("[1] Busca o tipo de autorizacao de um usuario especifico");
        System.out.println("[2] Lista todos os usuarios com o mesmo tipo de autorizacao");

        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                buscaAutorizacaoUsuario(usuarios);
                break;
            case 2:
                listaUsuarioByAutorizacao(usuarios);
                break;
            default:
                System.out.println("Entrada invalida");
                break;
        }
    }


    //buscar um usuario atraves de seu numero de id e lista seu tipo de autorizacao se encontrado
    public void buscaAutorizacaoUsuario(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o id do usuario");
        int id_usuario = in.nextInt();
        
        for(Usuario u: usuarios){
            if(id_usuario == u.getId()){
                System.out.println("O usuario possui autorizacao do tipo: " + u.getTipo());
            }
        }
    }

    //lista todos os usuarios cadastrados a partir de um tipo de usuario selecionado
    public void listaUsuarioByAutorizacao(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Selecione o tipo de autorizacao");
        System.out.println("[0] Sair");
        System.out.println("[1] Paciente");
        System.out.println("[2] Medico");
        System.out.println("[3] Administrador");
        int opcao = in.nextInt();
        in.nextLine();
        tipoUsuario tipoAutorizacao = null;

        switch(opcao){
            case 0:
                break;
            case 1:
                tipoAutorizacao = tipoUsuario.PACIENTE;
                break;
            case 2:
                tipoAutorizacao = tipoUsuario.MEDICO;
                break;
            case 3:
                tipoAutorizacao = tipoUsuario.ADMINISTRADOR;
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
        
        for(Usuario u: usuarios){
            if(tipoAutorizacao == u.getTipo()){
                System.out.println(u.getNome() + ", ID: " + u.getId() + ", tipo: " + u.getTipo());
            }
        }
    
    }


    public void marcarExame(CatalogoAutorizacoes cat, Scanner in) {

        System.out.println("Codigo do exame:");
        int codigo = in.nextInt();

        System.out.println("Data (yyyy-mm-dd):");
        String data = in.next();

        cat.marcarExame(codigo, LocalDate.parse(data));

    }

    public void listarExamesPaciente(CatalogoAutorizacoes cat, Scanner in) {

        in.nextLine();
        System.out.println("Nome do paciente:");
        String nome = in.nextLine();

        for (AutorizacaoExame a : cat.getListaAutorizacoes()) {
            if (a.getPaciente().getNome().equalsIgnoreCase(nome)) {
                System.out.println(a);
            }
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
}
